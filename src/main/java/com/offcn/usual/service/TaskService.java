package com.offcn.usual.service;

import com.offcn.usual.bean.Task;

import java.util.List;
import java.util.Map;

public interface TaskService {
    void insertTask(Task task);

    List<Map<String, Object>> listTask();

    Boolean deleteTask(Integer[] ids);

    Map<String, Object> lookTask(Integer id);

    Map<String, Object> lookTask1(Integer id);
}
