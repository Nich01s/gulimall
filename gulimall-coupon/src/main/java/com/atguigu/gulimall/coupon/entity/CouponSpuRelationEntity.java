package com.atguigu.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 优惠券与产品关联
 * 
 * @author Nich01s
 * @email s17717033286@163.com
 * @date 2022-11-03 12:29:36
 */
@Data
@TableName("sms_coupon_spu_relation")
public class CouponSpuRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 优惠券id
	 */
	private Long couponId;
	/**
	 * spu_id
	 */
	private Long spuId;
	/**
	 * spu_name
	 */
	private String spuName;

}
