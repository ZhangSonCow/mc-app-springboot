package com.coldsink.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Work {
    private Integer id;             // 编号
    private String name;           // 名称
    private String author;         // 作者名
    private String type;           // 类型
    private LocalDateTime createTime; // 发布时间
    private String code;           // 组件码
    private Boolean open;          // 是否开源
    private String image;          // 封面图(Base64编码)
    private String wyId;          // 对应的网易作品id
}