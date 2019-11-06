package com.offcn.sys.service;

import com.offcn.sys.bean.Sources;
import com.offcn.sys.bean.SourcesExample;
import com.offcn.sys.mapper.SourcesMapper;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SourcesServiceImpl implements SourcesService {

    @Resource
    private SourcesMapper sourcesMapper;
    @Resource
    private JedisPool jedisPool;
    @Override
    public List<Sources> infoSource(int pid) {
        SourcesExample example = new SourcesExample();
        SourcesExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(pid);
        return sourcesMapper.selectByExample(example);
    }

    @Override
    public void insertSource(Sources sources) {
        sourcesMapper.insertSelective(sources);
    }

    @Override
    public Sources lookSource(Integer id) {
        return sourcesMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateSource(Sources sources) {
        sourcesMapper.updateByPrimaryKeySelective(sources);
    }

    @Override
    public void deleteSource(Integer id) {
        sourcesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Sources> lookMenu(Integer eid) {

        List<Sources> list = sourcesMapper.lookMenu(eid, 1);
        for (Sources source : list) {
                Integer id = source.getId();
                List<Sources> sources = sourcesMapper.lookMenu(eid, id);
                source.setChildren(sources);
            }
        return list;
    }
/*
    //使用redis缓存
    @Override
    public List<Sources> lookMenu(Integer eid) {
        Jedis jedis = jedisPool.getResource();

        String s = jedis.get("menu" + eid);
        List<Sources> list = null;
        if(s== null || s.equals("")){
            list = sourcesMapper.lookMenu(eid,1);
            for (Sources source : list) {
                Integer id = source.getId();
                List<Sources> sources = sourcesMapper.lookMenu(eid, id);
                source.setChildren(sources);
            }
            jedis.set("menu"+eid, JSON.toJSONString(list));
        }else{
            list = JSON.parseArray(s, Sources.class);
        }
        return list;
    }
*/
}
