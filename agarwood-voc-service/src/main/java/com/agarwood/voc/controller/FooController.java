package com.agarwood.voc.controller;

import com.agarwood.voc.entity.Foo;
import com.agarwood.voc.service.FooService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("foo")
public class FooController {

    private final FooService fooService;

    @GetMapping("list")
    public List<Foo> list() {
        return fooService.list();
    }

    @GetMapping("page")
    public IPage<Foo> page(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<Foo> page = new Page<>(pageNum, pageSize);
        return fooService.page(page);
    }

    @PostMapping()
    public boolean save(@RequestBody Foo foo) {
        return fooService.save(foo);
    }

    @PutMapping()
    public boolean update(@RequestBody Foo foo) {
        return fooService.updateById(foo);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable String id) {
        return fooService.removeById(id);
    }

    @GetMapping("{id}")
    public Foo get(@PathVariable String id) {
        return fooService.getById(id);
    }
}
