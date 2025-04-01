package com.coldsink.service.impl;

import com.coldsink.mapper.WorkMapper;
import com.coldsink.entity.Work;
import com.coldsink.entity.PageBean;
import com.coldsink.service.WorkService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkMapper workMapper;

    @Override
    public PageBean<Work> list(Integer pageNumber, Integer pageSize, String search, String type) {
        // 设置分页参数
        Integer pageStart = (pageNumber - 1) * pageSize;

        // 执行数据库查询
        List<Work> workList = workMapper.list(pageStart, pageSize, search, type);

        // 获取分页信息
        PageInfo<Work> pageInfo = new PageInfo<>(workList);
        System.out.println("分页信息：" + pageInfo);

        // 返回封装的PageBean对象
        return new PageBean<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public void delete(List<Integer> ids) {
        workMapper.delete(ids);
    }

    @Override
    public void add(Work work) {
        // 设置创建时间为当前时间
        work.setCreateTime(LocalDateTime.now());
        workMapper.insert(work);
    }

    @Override
    public void update(Work work) {
        workMapper.update(work);
    }
}