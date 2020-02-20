package com.example.controller;

import com.example.entity.Stock;
import com.example.service.StockService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Stock)表控制层
 *
 * @author makejava
 * @since 2020-02-18 14:19:46
 */
@RestController
@RequestMapping("stock")
public class StockController {
    /**
     * 服务对象
     */
    @Resource
    private StockService stockService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Stock selectOne(Integer id) {
        return this.stockService.queryById(id);
    }

}