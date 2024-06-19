package test;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import test.entity.DemoData;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EasyExcelTest {
    public static void main(String[] args) throws Exception {
        String fileName = "test1.xlsx";
        List<DemoData> data = new ArrayList<>();
        // 添加数据
        data.add(new DemoData("张三", 20));
        data.add(new DemoData("李四", 25));

        FileOutputStream out = new FileOutputStream(fileName);

        // 写入Excel
        ExcelWriter excelWriter = EasyExcelFactory.write(out, DemoData.class).build();

        WriteSheet writeSheet = EasyExcelFactory.writerSheet("Sheet1").build();

        excelWriter.write(data, writeSheet);

        System.out.println("Excel文件生成完毕");
    }
}
