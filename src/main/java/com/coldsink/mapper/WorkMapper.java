package com.coldsink.mapper;

import com.coldsink.entity.Work;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface WorkMapper {
    /**
     * 分页查询作品列表
     * @param pageStart 起始位置
     * @param pageSize 每页数量
     * @param name 作品名称(模糊查询)
     * @param author 作者名(模糊查询)
     * @param type 作品类型
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 作品列表
     */
    List<Work> list(Integer pageStart, Integer pageSize, String search, String type);

    /**
     * 批量删除作品
     * @param ids 作品ID列表
     */
    void delete(List<Integer> ids);

    /**
     * 新增作品
     * @param work 作品对象
     */
//    @Insert("INSERT INTO work_table(name, author, type, create_time, code, open, image) " +
//            "VALUES(#{name}, #{author}, #{type}, #{createTime}, #{code}, #{open}, #{image})")
    void insert(Work work);

    /**
     * 更新作品信息
     * @param work 作品对象
     */
//    @Update("UPDATE work_table SET " +
//            "name = #{name}, " +
//            "author = #{author}, " +
//            "type = #{type}, " +
//            "code = #{code}, " +
//            "open = #{open}, " +
//            "image = #{image} " +
//            "WHERE id = #{id}")
    void update(Work work);
}