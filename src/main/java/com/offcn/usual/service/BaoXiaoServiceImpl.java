package com.offcn.usual.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.commons.Page;
import com.offcn.usual.bean.BaoXiao;
import com.offcn.usual.bean.BaoXiaoExample;
import com.offcn.usual.mapper.BaoXiaoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BaoXiaoServiceImpl implements BaoXiaoService{

    @Resource
    private BaoXiaoMapper baoXiaoMapper;
    @Override
    public void insertBaoXiao(BaoXiao baoXiao) {
        //生成baoxiao表的id
        String bxid = UUID.randomUUID().toString().replace("-", "");
        baoXiao.setBxid(bxid);
        baoXiao.setBxstatus(0);
        baoXiaoMapper.insertSelective(baoXiao);
    }

    @Override
    public PageInfo<BaoXiao> listBaoXiao(Integer eid, Integer pageNum, Map<String, Object> map) {
        PageHelper.startPage(pageNum, Page.PAGESIZE);       //设置当前第几页，每页记录数

        //用于搜索查询
        String str1 = (String) map.get("cid");
        String keyword = (String) map.get("keyword");
        String str2 = (String) map.get("orderby");

        BaoXiaoExample example = new BaoXiaoExample();
        BaoXiaoExample.Criteria criteria = example.createCriteria();
        /*
            三个值都为空代表为未使用搜索
        */
        if(str1 != null || keyword != null || str2 != null){
            Integer cid = -1;
            Integer orderby = -1;
            if(str1 != null){
                cid = Integer.valueOf(str1);
            }
            if(str2 != null){
                orderby = Integer.valueOf(str2);
            }
            /*按类型查询*/
            if(cid ==4) {
                criteria.andBxremarkLike('%' + keyword + '%');
            }else{
                criteria.andBxremarkLike('%' + keyword + '%');
                criteria.andBxstatusEqualTo(cid);
            }
            /*升降序查询*/
            if (orderby == 2){
                example.setOrderByClause("bxtime desc");
            }else if(orderby ==1){
                example.setOrderByClause("bxtime asc");
            }
        }else{
            criteria.andEmpFkEqualTo(eid);
        }

        List<BaoXiao> baoXiaos = baoXiaoMapper.selectByExample(example);
        PageInfo<BaoXiao> page = new PageInfo<>(baoXiaos,3);        //封装结果集到分页对象中
        return page;
    }
}
