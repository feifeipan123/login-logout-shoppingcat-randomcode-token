package com._520it.shopping.domain;

import lombok.Data;

@Data
public class ProductDir {
    private Long id;
    private String dirName;
    private Long parent_id;
}
