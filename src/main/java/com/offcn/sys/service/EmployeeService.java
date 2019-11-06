package com.offcn.sys.service;

import com.offcn.sys.bean.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Employee> findAllEmployee();

    List<Employee> infoEmployee();

    Employee login(Employee employee);

    List<Map<String, Object>> infoAndEmail(Integer eid);

    void insertEmployee(Employee employee, Integer[] ids);
}
