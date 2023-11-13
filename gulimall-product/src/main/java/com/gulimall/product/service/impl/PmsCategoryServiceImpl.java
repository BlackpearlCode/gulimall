package com.gulimall.product.service.impl;

import com.gulimall.product.mapper.PmsCategoryMapper;
import com.gulimall.product.entity.PmsCategory;
import com.gulimall.product.service.PmsCategoryService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PmsCategoryServiceImpl implements PmsCategoryService {

    @Resource
    private PmsCategoryMapper pmsCategoryMapper;

    @Override
    public int deleteByPrimaryKey(Long catId) {
        return pmsCategoryMapper.deleteByPrimaryKey(catId);
    }

    @Override
    public int insert(PmsCategory record) {
        return pmsCategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsCategory record) {
        return pmsCategoryMapper.insertSelective(record);
    }

    @Override
    public PmsCategory selectByPrimaryKey(Long catId) {
        return pmsCategoryMapper.selectByPrimaryKey(catId);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsCategory record) {
        return pmsCategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsCategory record) {
        return pmsCategoryMapper.updateByPrimaryKey(record);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public List<PmsCategory> selectlist() {
        return pmsCategoryMapper.list();
    }

    /**
     * 查询所有数据并组装成父子结构
     * @return
     */
    @Override
    public List<PmsCategory> seletcListTree() {
        //查出所有数据
        List<PmsCategory> categoryList = pmsCategoryMapper.list();
        List<PmsCategory> productLevel1 = categoryList.stream().filter((PmsCategory) ->
             PmsCategory.getParentCid() == 0
        ).map((menu)->{
            menu.setChildren(getChildrens(menu,categoryList));
            return menu;
        }).sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))).collect(Collectors.toList());
        return productLevel1;
    }

    @Override
    public int updateShowStatusList(List ids) {
        return pmsCategoryMapper.updateShowStatusList(ids);

    }

    @Override
    public List<PmsCategory> getLevel1Categorys() {
        //查询所有一级分类，即parentId=0
        return pmsCategoryMapper.selectByParentId();
    }


    /**
     * 查找当前菜单的子菜单
     * @param root 当前菜单
     * @param all 所有菜单
     * @return
     */
    private List<PmsCategory> getChildrens(PmsCategory root,List<PmsCategory> all){
        List<PmsCategory> children = all.stream().filter(PmsCategory -> {
            //获取二级子菜单
            return PmsCategory.getParentCid() == root.getCatId();
        }).map(PmsCategory->{
            //递归遍历，找到每一层的子菜单
            PmsCategory.setChildren(getChildrens(PmsCategory,all));
            return PmsCategory;
        }).sorted((menu1,menu2)->{
            //菜单排序
            return (menu1.getSort()==null?0:menu1.getSort())-(menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());
        return children;
    }

}
