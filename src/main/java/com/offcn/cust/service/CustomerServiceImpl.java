package com.offcn.cust.service;

import com.offcn.cust.bean.Customer;
import com.offcn.cust.bean.CustomerExample;
import com.offcn.cust.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Resource
    private CustomerMapper customerMapper;
    @Override
    public void insertCustomer(Customer customer) {
        customer.setAddtime(new Date());

        customerMapper.insert(customer);
    }

    @Override
    public List<Customer> findAllCustomer() {
        //PageHelper.startPage(4,3);
        CustomerExample example = new CustomerExample();
        List<Customer> customers = customerMapper.selectByExample(example);
        //PageInfo<Customer> pageInfo = new PageInfo<>(customers,3);

        /*System.out.println("总页数： " + pageInfo.getPages());
        System.out.println("总记录数： " + pageInfo.getTotal());
        System.out.println("当前页： " + pageInfo.getPageNum());
        System.out.println("上一页： " + pageInfo.getPrePage());
        System.out.println("下一页： " + pageInfo.getNextPage());
        System.out.println("是否有上一页： " + pageInfo.isHasPreviousPage());
        System.out.println("是否有下一页： " + pageInfo.isHasNextPage());
        System.out.println("是否为首页： " + pageInfo.isIsFirstPage());
        System.out.println("是否为尾页： " + pageInfo.isIsLastPage());
        int[] nums = pageInfo.getNavigatepageNums();
        System.out.println(Arrays.toString(nums));*/

        return customers;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteCustomer(String ids) {
        String[] split = ids.split(",");
        List<String> id = Arrays.asList(split);
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(id);
        int row = customerMapper.deleteByExample(example);
        return split.length == row;
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public List<Customer> searchCustomer(Integer cid, String keyword, Integer orderby) {
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        if(cid == 0){
            criteria.andComnameLike("%"+keyword+"%");
            CustomerExample.Criteria criteria1 = example.createCriteria();
            criteria1.andCompanypersonLike("%" + keyword + "%");
            example.or(criteria1);
        }else if(cid ==1 ){
            criteria.andComnameLike("%"+keyword+"%");
        }else {
            criteria.andCompanypersonLike("%" + keyword + "%");
        }
        if(orderby == 1){
            example.setOrderByClause("id desc");
        }
        return customerMapper.selectByExample(example);
    }

    @Override
    public void importExcel(List<Customer> customers) {
        for (Customer customer : customers) {
            customerMapper.insertSelective(customer);
        }
    }

    @Override
    public List<Map<String, Object>> infoAndTask() {
        return customerMapper.infoAndTask();
    }
}
