package com.offcn.pro.service;

import com.offcn.pro.bean.Project;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    List<Project> findAllProject();

    void insertProject(Project project);

    Project lookProject(Integer pid);

    Boolean deleteProject(String ids);

    Project editProject(Integer pid);

    void updateProject(Project project);

    List<Project> searchProject(Integer cid, String keyword, Integer orderby);

    List<Map<String, Object>> infoProject();

    List<Project> infoAndAtta();
}
