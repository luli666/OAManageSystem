package com.offcn.usual.service;

import com.offcn.usual.bean.Task;
import com.offcn.usual.bean.TaskExample;
import com.offcn.usual.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    private TaskMapper taskMapper;
    @Override
    public void insertTask(Task task) {
        taskMapper.insertSelective(task);
    }

    @Override
    public List<Map<String, Object>> listTask() {
        return taskMapper.listTask();
    }

    @Override
    public Boolean deleteTask(Integer[] ids) {
        List<Integer> list = Arrays.asList(ids);
        TaskExample example = new TaskExample();
        TaskExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(list);
        int row = taskMapper.deleteByExample(example);
        return row == ids.length;
    }

    @Override
    public Map<String, Object> lookTask(Integer id) {
        return taskMapper.lookTask(id);
    }

    @Override
    public Map<String, Object> lookTask1(Integer id) {
        return taskMapper.lookTask1(id);
    }
}
