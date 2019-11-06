package com.offcn.cust.controller;

import com.offcn.cust.bean.Customer;
import com.offcn.cust.service.CustomerService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/insert")
    public String insertCustomer(Customer customer){
        customerService.insertCustomer(customer);

        return "redirect:/customer/list";
    }
    @RequestMapping("/list")
    public String findAllCustomer(Model model){
        List<Customer> customers = customerService.findAllCustomer();
        model.addAttribute("customers", customers);

        return "customer";
    }
    @RequestMapping("/look/{id}")
    public String getCustomerById(@PathVariable("id") Integer id,Model model){
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);

        return "customer-look";
    }
    @RequestMapping("delete/{ids}")
    @ResponseBody
    public HashMap<String,Object> deleteCustomer(@PathVariable("ids") String ids){
        System.out.println(ids);
        boolean info = customerService.deleteCustomer(ids);
        HashMap<String,Object> map = new HashMap<String,Object>();
        if(info){
            map.put("status", 200);
            map.put("msg", "删除成功");
        }else{
            map.put("status", 500);
            map.put("msg", "删除失败");
        }
        return map;
    }
    @RequestMapping("/edit/{id}")
    public String editCustomer(@PathVariable("id") Integer id,Model model){
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);

        return "customer-edit";
    }
    @RequestMapping("/update")
    public String updateCustomer(Customer customer){
        customerService.updateCustomer(customer);

        return "redirect:/customer/list";
    }
    @RequestMapping("/search")
    public String searchCustomer(Integer cid,String keyword,Integer orderby,Model model){
        List<Customer> customers = customerService.searchCustomer(cid,keyword,orderby);
        model.addAttribute("customers", customers);
        return "customer";
    }

    @RequestMapping("/info")
    @ResponseBody
    public List<Customer> infoCustomer(){
        return customerService.findAllCustomer();
    }
    @RequestMapping("/infobyid/{id}")
    @ResponseBody
    public Customer infoByIdCustomer(@PathVariable("id") Integer id){
        return customerService.getCustomerById(id);
    }

    /*导出Excel文件*/
    @RequestMapping("/export")
    @ResponseBody
    public boolean exportExcel(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Customer> customers = customerService.findAllCustomer();

        //创建excel表格
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建工作表
        XSSFSheet sheet = workbook.createSheet("sheet");
        //创建行
        XSSFRow row = sheet.createRow(0);
        //创建表头单元格
        XSSFCell cell = row.createCell(0);
        XSSFCell cell1 = row.createCell(1);
        XSSFCell cell2 = row.createCell(2);
        XSSFCell cell3 = row.createCell(3);
        XSSFCell cell4 = row.createCell(4);
        cell.setCellValue("ID");
        cell1.setCellValue("公司名称");
        cell2.setCellValue("联系人");
        cell3.setCellValue("添加时间");
        cell4.setCellValue("联系电话");
        
        XSSFRow[] rows = new XSSFRow[customers.size()];
        //向excel中添加数据
        for(int i=0;i<customers.size();i++) {
            rows[i] = sheet.createRow(i+1);
            XSSFCell c = rows[i].createCell(0);
            XSSFCell c1 = rows[i].createCell(1);
            XSSFCell c2 = rows[i].createCell(2);
            XSSFCell c3 = rows[i].createCell(3);
            XSSFCell c4 = rows[i].createCell(4);

            c.setCellValue(customers.get(i).getId());
            c1.setCellValue(customers.get(i).getComname());
            c2.setCellValue(customers.get(i).getCompanyperson());
            Date addtime = customers.get(i).getAddtime();
            String date = sdf.format(addtime);
            c3.setCellValue(date);
            c4.setCellValue(customers.get(i).getComphone());
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\customer.xlsx")) {
            workbook.write(fileOutputStream);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    /*导入文件*/
    @RequestMapping("/importExcel")
    @ResponseBody
    public Map<String,Object> importExcel(MultipartFile multipart){
        Map<String,Object> map = new HashMap<>();
        List<Customer> customers = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            //获取Excel文件
            Workbook workbook = WorkbookFactory.create(multipart.getInputStream());
            //获取工作表
            for(int i= 0;i<workbook.getNumberOfSheets();i++){
                Sheet sheet = workbook.getSheetAt(i);
                //获取工作表中的每一行
                for (int j = sheet.getFirstRowNum()+1;j<=sheet.getLastRowNum(); j++){
                    Row row = sheet.getRow(j);
                    Customer customer = new Customer();
                    if(row != null){
                        String comname = row.getCell(0).getStringCellValue();
                        customer.setComname(comname);
                        String comperson = row.getCell(1).getStringCellValue();
                        customer.setCompanyperson(comperson);
                        customer.setComaddress(row.getCell(2).getStringCellValue());
                        double comphone = row.getCell(3).getNumericCellValue();
                        //处理科学计数法
                        BigDecimal comphone1 = new BigDecimal(String.valueOf(comphone));
                        customer.setComphone(comphone1.toPlainString());
                        String comera = row.getCell(4).getStringCellValue();
                        customer.setCamera(comera);
                        customer.setPresent(row.getCell(5).getStringCellValue());
                        customer.setRemark(row.getCell(6).getStringCellValue());
                        //处理日期类型
                        Date date = row.getCell(7).getDateCellValue();
                        String format = sdf.format(date);
                        Date addtime = sdf.parse(format);
                        customer.setAddtime(addtime);
                    }
                    customers.add(customer);
                }
            }
            customerService.importExcel(customers);
            map.put("statusCode",200);
            map.put("msg","上传成功");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            map.put("statusCode",500);
            map.put("msg","上传失败");
        }
        return map;
    }
    @RequestMapping("/infoAndTask")
    @ResponseBody
    public List<Map<String,Object>> infoAndTask(){
        List<Map<String,Object>> list = customerService.infoAndTask();
        return list;
    }


}
