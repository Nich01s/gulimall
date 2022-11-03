package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author Nich01s
 * @email s17717033286@163.com
 * @date 2022-11-03 09:05:35
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
