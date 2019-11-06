package com.offcn.cust.service;

import com.offcn.cust.bean.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    public void insertCustomer(Customer customer);

    public List<Customer> findAllCustomer();

    public Customer getCustomerById(Integer id);

    public boolean deleteCustomer(String ids);

    public void updateCustomer(Customer customer);

    public List<Customer> searchCustomer(Integer cid, String keyword, Integer orderby);

    void importExcel(List<Customer> customers);

    List<Map<String, Object>> infoAndTask();
}
