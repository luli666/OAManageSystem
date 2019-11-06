package com.offcn.usual.service;

import com.github.pagehelper.PageInfo;
import com.offcn.usual.bean.BaoXiao;

import java.util.Map;

public interface BaoXiaoService {
    void insertBaoXiao(BaoXiao baoXiao);

    PageInfo<BaoXiao> listBaoXiao(Integer eid, Integer pageNum, Map<String, Object> map);
}
