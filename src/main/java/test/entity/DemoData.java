package test.entity;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ExcelIgnoreUnannotated
public class DemoData {
    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("年龄")
    private int age;


}