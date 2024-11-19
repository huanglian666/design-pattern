package controller;

import cn.hutool.json.JSONUtil;
import com.yubico.webauthn.AssertionRequest;
import com.yubico.webauthn.FinishAssertionOptions;
import com.yubico.webauthn.RelyingParty;
import com.yubico.webauthn.StartRegistrationOptions;
import com.yubico.webauthn.data.*;
import controller.dto.InMemoryCredentialRepository;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * Title: <br/>
 * Description: <br/>
 * Copyright: 2024 <br/>
 * Company:<br/>
 * Project: design-pattern <br/>
 *
 * @Author huanglian <br/>
 * Create Time:11/19/24 10:37 <br/>
 */
@RestController("/passkey")
public class PassKeyController {
    private final RelyingParty relyingParty;

    public PassKeyController() {
        this.relyingParty = RelyingParty.builder()
                .identity(RelyingPartyIdentity.builder()
                        .id("example.com")
                        .name("Example")
                        .build())
                .credentialRepository(new InMemoryCredentialRepository())
                .origins(Collections.singleton("https://example.com"))
                .build();
    }

    @GetMapping("/challenge")
    public String challenge() {
        PublicKeyCredentialCreationOptions options = relyingParty.startRegistration(
                StartRegistrationOptions.builder()
                        .user(UserIdentity.builder()
                                .name("user")
                                .displayName("User")
                                .id(new ByteArray("user-id".getBytes()))
                                .build())
                        .build()
        );
        return JSONUtil.toJsonStr(options);
    }

    @SneakyThrows
    @PostMapping("/verify")
    public String verify(String jsonResponse, AssertionRequest request) {
        PublicKeyCredential<AuthenticatorAssertionResponse, ClientAssertionExtensionOutputs> credential =
                PublicKeyCredential.parseAssertionResponseJson(jsonResponse);

        relyingParty.finishAssertion(
                FinishAssertionOptions.builder()
                        .request(request)
                        .response(credential)
                        .build()
        );
        return "";
    }
}
