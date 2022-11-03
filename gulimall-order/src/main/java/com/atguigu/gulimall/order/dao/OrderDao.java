package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author Nich01s
 * @email s17717033286@163.com
 * @date 2022-11-03 12:48:59
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
