package com.coldsink.controller;

import com.coldsink.entity.Work;
import com.coldsink.entity.PageBean;
import com.coldsink.entity.Result;
import com.coldsink.service.WorkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*")
@Slf4j
@RestController
@RequestMapping("/work")
public class WorkController {

    @Autowired
    private WorkService workService;

    /**
     * 分页查询作品列表
     * @param pageNumber 页码
     * @param pageSize 每页数量
     * @param name 作品名称(模糊查询)
     * @param author 作者名(模糊查询)
     * @param type 作品类型
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 分页结果
     */
    @GetMapping
    public Result<PageBean<Work>> list(
            @RequestParam(defaultValue = "1") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "") String type) {

        log.info("查询作品列表, 页码: {}, 每页数量: {}, 名称/作者: {}, 类型: {}",
                pageNumber, pageSize, search, type);

        PageBean<Work> pageBean = workService.list(pageNumber, pageSize, search, type);
        return Result.success(pageBean);
    }

    /**
     * 批量删除作品
     * @param ids 作品ID列表
     * @return 操作结果
     */
    @DeleteMapping("/{ids}")
    public Result<String> delete(@PathVariable List<Integer> ids) {
        log.info("删除作品id: {}", ids);
        workService.delete(ids);
        return Result.success();
    }

    /**
     * 新增作品
     * @param work 作品对象
     * @return 操作结果
     */
    @PostMapping
    public Result<String> add(@RequestBody Work work) {
        log.info("新增作品: {}", work);
        work.setCreateTime(LocalDateTime.now()); // 设置创建时间为当前时间
        workService.add(work);
        return Result.success();
    }

    /**
     * 更新作品信息
     * @param work 作品对象
     * @return 操作结果
     */
    @PatchMapping
    public Result<String> update(@RequestBody Work work) {
        log.info("更新作品: {}", work);
        workService.update(work);
        return Result.success();
    }
}