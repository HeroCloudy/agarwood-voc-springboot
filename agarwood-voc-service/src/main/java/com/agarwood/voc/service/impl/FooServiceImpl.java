package com.agarwood.voc.service.impl;

import com.agarwood.voc.entity.Foo;
import com.agarwood.voc.mapper.FooMapper;
import com.agarwood.voc.service.FooService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class FooServiceImpl  extends ServiceImpl<FooMapper, Foo> implements FooService {
}
