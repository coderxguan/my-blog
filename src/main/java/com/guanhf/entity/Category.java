package com.guanhf.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/27 17:55
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private int id;

    private String name;

    private String description;
}
