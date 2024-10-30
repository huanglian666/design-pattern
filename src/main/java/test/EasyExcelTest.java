package test;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import test.entity.DemoData;
import test.entity.TestSseEventBuilderImpl;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EasyExcelTest {
    public static void main(String[] args) throws Exception {
        SseEmitter emitter = new SseEmitter();
        emitter.send(new TestSseEventBuilderImpl().data("aaaa"));
        String fileName = "test1.xlsx";
        List<DemoData> data = new ArrayList<>();
        // 添加数据
        data.add(new DemoData("张三aaaaa", 20));
        data.add(new DemoData("李四bbbbbb", 25));

        FileOutputStream out = new FileOutputStream(fileName);

        // 写入Excel
        ExcelWriter excelWriter = EasyExcelFactory.write(out, DemoData.class).build();

        WriteSheet writeSheet = EasyExcelFactory.writerSheet("Sheet1").build();

        excelWriter.write(data, writeSheet);

        excelWriter.finish();



        System.out.println("Excel文件生成完毕");

    }

}
