package com.offcn.pro.service;

import com.offcn.pro.bean.Project;
import com.offcn.pro.bean.ProjectExample;
import com.offcn.pro.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    public ProjectMapper projectMapper;

    @Override
    public List<Project> findAllProject() {
        return projectMapper.findAllProject();
    }

    @Override
    public void insertProject(Project project) {
        projectMapper.insertSelective(project);
    }

    @Override
    public Project lookProject(Integer pid) {
        return projectMapper.getProjectById(pid);
    }

    @Override
    public Boolean deleteProject(String ids) {
        String[] split = ids.split(",");
        List<String> list = Arrays.asList(split);
        ProjectExample example = new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        criteria.andPidIn(list);
        int row = projectMapper.deleteByExample(example);
        return row == split.length;
    }

    @Override
    public Project editProject(Integer pid) {
        return projectMapper.getProjectById(pid);
    }

    @Override
    public void updateProject(Project project) {
        projectMapper.updateByPrimaryKeySelective(project);
    }

    @Override
    public List<Project> searchProject(Integer cid, String keyword, Integer orderby) {
        return projectMapper.likeProject(cid, keyword, orderby);
    }

    @Override
    public List<Map<String, Object>> infoProject() {
        return projectMapper.infoProject();
    }

    @Override
    public List<Project> infoAndAtta() {
        ProjectExample example = new ProjectExample();
        return projectMapper.selectByExample(example);
    }
}
