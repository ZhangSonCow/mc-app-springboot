package com.coldsink.service;

import com.coldsink.entity.Work;
import com.coldsink.entity.PageBean;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkService {
    /**
     * 分页查询作品列表
     * @param pageNumber 页码
     * @param pageSize 每页数量
     * @param search 作品/作者名称(模糊查询)
     * @param type 作品类型
     * @return 分页结果
     */
    PageBean<Work> list(Integer pageNumber, Integer pageSize, String search, String type);

    /**
     * 批量删除作品
     * @param ids 作品ID列表
     */
    void delete(List<Integer> ids);

    /**
     * 新增作品
     * @param work 作品对象
     */
    void add(Work work);

    /**
     * 更新作品信息
     * @param work 作品对象
     */
    void update(Work work);
}