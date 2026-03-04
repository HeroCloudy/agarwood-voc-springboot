package com.agarwood.voc.controller;

import com.agarwood.common.exception.CommonException;
import com.agarwood.common.vo.PageInfo;
import com.agarwood.common.vo.PageReq;
import com.agarwood.common.vo.Result;
import com.agarwood.voc.entity.Foo;
import com.agarwood.voc.service.FooService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("foo")
public class FooController {

    private final FooService fooService;

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

    @PostMapping()
    public Result<Void> save(@Valid @RequestBody Foo foo) {
        fooService.save(foo);
        return Result.ok();
    }

    @PutMapping()
    public Result<Void> update(@RequestBody Foo foo) {
        fooService.updateById(foo);
        return Result.ok();
    }

    @DeleteMapping("{id}")
    public Result<Void> delete(@PathVariable String id) {
        fooService.removeById(id);
        return Result.ok();
    }

    @GetMapping("{id}")
    public Result<Foo> get(@PathVariable String id) {
        Foo foo = fooService.getById(id);
        if (foo == null) {
            throw new CommonException("数据不存在");
        }
        return Result.ok();
    }
}
