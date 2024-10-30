package test.entity;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Title: <br/>
 * Description: <br/>
 * Copyright: 2024 <br/>
 * Company:<br/>
 * Project: design-pattern <br/>
 *
 * @Author huanglian <br/>
 * Create Time:10/30/24 17:24 <br/>
 */
public class TestSseEventBuilderImpl implements SseEmitter.SseEventBuilder {


    private final Set<ResponseBodyEmitter.DataWithMediaType> dataToSend = new LinkedHashSet<>(4);

    @Nullable
    private StringBuilder sb;

    @NotNull
    @Override
    public SseEmitter.SseEventBuilder id(@NotNull String id) {
        append("id:").append(id).append('\n');
        return this;
    }

    @NotNull
    @Override
    public SseEmitter.SseEventBuilder name(@NotNull String name) {
        append("event:").append(name).append('\n');
        return this;
    }

    @NotNull
    @Override
    public SseEmitter.SseEventBuilder reconnectTime(long reconnectTimeMillis) {
        append("retry:").append(String.valueOf(reconnectTimeMillis)).append('\n');
        return this;
    }

    @NotNull
    @Override
    public SseEmitter.SseEventBuilder comment(@NotNull String comment) {
        append(':').append(comment).append('\n');
        return this;
    }

    @NotNull
    @Override
    public SseEmitter.SseEventBuilder data(@NotNull Object object) {
        return data(object, null);
    }

    @NotNull
    @Override
    public SseEmitter.SseEventBuilder data(@NotNull Object object, @Nullable MediaType mediaType) {
        saveAppendedText();
        this.dataToSend.add(new ResponseBodyEmitter.DataWithMediaType(object, mediaType));
        return this;
    }

    TestSseEventBuilderImpl append(String text) {
        if (this.sb == null) {
            this.sb = new StringBuilder();
        }
        this.sb.append(text);
        return this;
    }

    TestSseEventBuilderImpl append(char ch) {
        if (this.sb == null) {
            this.sb = new StringBuilder();
        }
        this.sb.append(ch);
        return this;
    }

    @NotNull
    @Override
    public Set<ResponseBodyEmitter.DataWithMediaType> build() {
        if (!StringUtils.hasLength(this.sb) && this.dataToSend.isEmpty()) {
            return Collections.emptySet();
        }
        append('\n');
        saveAppendedText();
        return this.dataToSend;
    }

    private void saveAppendedText() {
        if (this.sb != null) {
            this.dataToSend.add(new ResponseBodyEmitter.DataWithMediaType(this.sb.toString(), MediaType.TEXT_PLAIN));
            this.sb = null;
        }
    }
}
