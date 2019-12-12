package com.myimooc.boot.start.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * <br>
 * 标题: 通用mapper<br>
 * 描述: 继承自己的MyMapper<br>
 * 特别注意，该接口不能被扫描到，否则会出错
 *
 * @author zc
 * @date 2018/04/26
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
