package com.offcn.sys.service;

import com.offcn.sys.bean.EmpRoleKey;
import com.offcn.sys.bean.Employee;
import com.offcn.sys.bean.EmployeeExample;
import com.offcn.sys.mapper.EmpRoleMapper;
import com.offcn.sys.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private EmpRoleMapper empRoleMapper;

    @Override
    public List<Employee> findAllEmployee() {
        EmployeeExample example = new EmployeeExample();
        return employeeMapper.selectByExample(example);
    }

    @Override
    public List<Employee> infoEmployee() {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andPFkEqualTo(4);
        return employeeMapper.selectByExample(example);
    }

    @Override
    public Employee login(Employee employee) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(employee.getUsername());
        criteria.andPasswordEqualTo(employee.getPassword());

        List<Employee> employees = employeeMapper.selectByExample(example);
        if(employees != null && employees.size() > 0){
            return employees.get(0);
        }
        return null;
    }

    @Override
    public List<Map<String, Object>> infoAndEmail(Integer eid) {
        return employeeMapper.infoAndEmail(eid);
    }

    @Override
    public void insertEmployee(Employee employee, Integer[] ids) {
        employeeMapper.insertEmployee(employee);
        Integer eid = employee.getEid();
        for (Integer id : ids) {
            EmpRoleKey empRoleKey = new EmpRoleKey();
            empRoleKey.setEid(eid);
            empRoleKey.setRid(id);
            empRoleMapper.insert(empRoleKey);
        }
    }
}
