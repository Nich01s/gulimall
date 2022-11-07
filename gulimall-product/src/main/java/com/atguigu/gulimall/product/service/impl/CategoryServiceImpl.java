package com.atguigu.gulimall.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 查询所有分类及其子分类，以树形结构组装
     */
    @Override
    public List<CategoryEntity> listWithTree() {
        // 1、查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        // 2、组装成树形
        // 2.1 将所有分类收集到集合
        List<CategoryEntity> level3 = new ArrayList<>();
        List<CategoryEntity> level2 = new ArrayList<>();
        List<CategoryEntity> level1 = new ArrayList<>();
        for (CategoryEntity entity : entities) {
            if (entity.getCatLevel() == 3) {
                level3.add(entity);
            }
        }
        for (CategoryEntity entity : entities) {
            if (entity.getCatLevel() == 2) {
                level2.add(entity);
            }
        }
        for (CategoryEntity entity : entities) {
            if (entity.getCatLevel() == 1) {
                level1.add(entity);
            }
        }
        // 2.2、将所有3级分类，设置到所属的2级分类的children字段中
        for (CategoryEntity entity3 : level3) {
            // 查找3级分类所属2级分类
            Long parentCid = entity3.getParentCid();
            // 将3级分类设置到其所属的二级分类的children字段中
            for (CategoryEntity entity2 : level2) {
                if (entity2.getCatId().equals(parentCid)) {
                    List<CategoryEntity> children = entity2.getChildren();
                    children.add(entity3);
                    break;
                }
            }
        }
        // 2.3 将所有2级分类，设置到所属的1级分类children字段中
        for (CategoryEntity entity2 : level2) {
            // 查找2级分类所属丶1级分类
            Long parentCid = entity2.getParentCid();
            // 将2级分类设置到其所属的1级分类的children字段中
            for (CategoryEntity entity1 : level1) {
                if (entity1.getCatId().equals(parentCid)){
                    List<CategoryEntity> children = entity1.getChildren();
                    children.add(entity2);
                    break;
                }
            }
        }

        return level1;
    }

}