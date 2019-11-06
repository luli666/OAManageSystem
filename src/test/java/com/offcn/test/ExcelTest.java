package com.offcn.test;

import com.offcn.cust.service.CustomerServiceImpl;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelTest {

    @Test
    public void test02(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerServiceImpl bean = context.getBean(CustomerServiceImpl.class);

        bean.findAllCustomer();
    }

    @Test
    public void test01(){
        //创建Excel文件
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建工作表
        XSSFSheet sheet = workbook.createSheet("sheet01");
        //新增行
        XSSFRow row = sheet.createRow(0);
        //新增单元格
        XSSFCell cell = row.createCell(2);
        //向单元格填充数据
        cell.setCellValue("hello word");
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\customer.xlsx");
            workbook.write(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
