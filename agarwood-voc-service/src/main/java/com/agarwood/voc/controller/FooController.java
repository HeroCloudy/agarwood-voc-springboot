package com.agarwood.voc.controller;

import com.agarwood.common.exception.CommonException;
import com.agarwood.common.vo.PageInfo;
import com.agarwood.common.vo.PageReq;
import com.agarwood.common.vo.Result;
import com.agarwood.voc.entity.Foo;
import com.agarwood.voc.service.FooService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Foo管理", description = "Foo 增删改查接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("foo")
public class FooController {

    private final FooService fooService;

    @Operation(summary = "列表查询", description = "查询所有 Foo 数据")
    @GetMapping("/list")
    public Result<List<Foo>> list() {
        return Result.ok(fooService.list());
    }

    @GetMapping("page")
    public Result<PageInfo<Foo>> page(PageReq pageReq) {
        Page<Foo> req = new Page<>(pageReq.getPageNo(), pageReq.getPageSize());
        Page<Foo> result = fooService.page(req);
        return Result.ok(new PageInfo<>(result.getTotal(), result.getRecords()));
    }

    @Operation(summary = "保存", description = "保存 Foo 数据")
    @PostMapping()
    public Result<Void> save(@Valid @RequestBody Foo foo) {
        fooService.save(foo);
        return Result.ok();
    }

    @Operation(summary = "更新", description = "更新 Foo 数据")
    @PutMapping()
    public Result<Void> update(@RequestBody Foo foo) {
        fooService.updateById(foo);
        return Result.ok();
    }

    @Operation(summary = "删除", description = "根据 ID 删除 Foo 数据")
    @DeleteMapping("{id}")
    public Result<Void> delete(@PathVariable String id) {
        fooService.removeById(id);
        return Result.ok();
    }

    @Operation(summary = "查询详情", description = "根据 ID 查询 Foo 详情")
    @GetMapping("{id}")
    public Result<Foo> get(@PathVariable String id) {
        Foo foo = fooService.getById(id);
        if (foo == null) {
            throw new CommonException("数据不存在");
        }
        return Result.ok();
    }
}
