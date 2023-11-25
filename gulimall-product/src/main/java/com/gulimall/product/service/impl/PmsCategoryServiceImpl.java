package com.gulimall.product.service.impl;

import com.gulimall.product.entity.PmsCategory;
import com.gulimall.product.feign.RedisFeignService;
import com.gulimall.product.mapper.PmsCategoryMapper;
import com.gulimall.product.service.PmsCategoryService;
import com.gulimall.product.vo.Catelog2Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PmsCategoryServiceImpl implements PmsCategoryService {

    @Resource
    private PmsCategoryMapper pmsCategoryMapper;

    @Autowired
    private RedisFeignService redisFeignService;

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
    public List<PmsCategory> getLevelCategorys(Long parentId) {
        //查询parentId对应的分类信息
        return pmsCategoryMapper.selectByParentId(parentId);
    }
    @Override
    public Map<String, List<Catelog2Vo>> getCatalogJson() {
        //判断是否存在缓存
        Boolean catalogJSON = redisFeignService.isExist("catalogJSON");
        if(catalogJSON){
            //从缓存中获取三级目录内容
            Map<String, List<Catelog2Vo>> catalog = redisFeignService.hmget("catalogJSON");
            return catalog;
        }
        Map<String, List<Catelog2Vo>> catalogJsonFromDB = getCatalogJsonFromDB();
        //加入缓存
        redisFeignService.saveCatalogJson("catalogJSON",catalogJsonFromDB);
        return catalogJsonFromDB;
    }

    //从数据库查询并封装数据
    public Map<String, List<Catelog2Vo>> getCatalogJsonFromDB() {
        /**
         * 将数据库的多次查询变成一次查询
         */
        List<PmsCategory> pmsCategories = pmsCategoryMapper.selectAll();
        //查出所有一级分类
        List<PmsCategory> level1Categorys = getLevelCategorys(pmsCategories,0L);
        Map<String, List<Catelog2Vo>> parent_cid = level1Categorys.stream().collect(Collectors.toMap(k -> k.getCatId().toString(), l1 -> {
            //查询每个一级分类下的二级分类
            List<PmsCategory> categoryList1 = getParentId(pmsCategories,l1.getCatId());
            List<Catelog2Vo> catelog2VoList = null;
            if (!categoryList1.isEmpty()) {
                catelog2VoList = categoryList1.stream().map(level2 -> {
                    Catelog2Vo catelog2Vo = new Catelog2Vo(l1.getCatId().toString(), null, level2.getCatId().toString(), level2.getName());
                    //查询每个二级分类下的三级分类
                    List<PmsCategory> categoryList3 = getCategoryList3(pmsCategories,level2.getCatId());
                    if (!categoryList3.isEmpty()) {
                        List<Catelog2Vo.Catelog3Vo> catelog3Vos = categoryList3.stream().map(level3 -> {
                            Catelog2Vo.Catelog3Vo catelog3Vo = new Catelog2Vo.Catelog3Vo(level2.getCatId().toString(), level3.getCatId().toString(), level3.getName());
                            return catelog3Vo;
                        }).collect(Collectors.toList());
                        catelog2Vo.setCatalog3list(catelog3Vos);
                    }
                    return catelog2Vo;
                }).collect(Collectors.toList());
            }
            return catelog2VoList;
        }));
        return  parent_cid;
    }

    //查询一级分类
    private List<PmsCategory> getLevelCategorys(List<PmsCategory>pmsCategories ,Long parentId) {
        return pmsCategories.stream().filter(item->item.getParentCid()==parentId).collect(Collectors.toList());
    }
    //查询三级分类
    private List<PmsCategory> getCategoryList3(List<PmsCategory>pmsCategories ,Long parentId) {
        return pmsCategories.stream().filter(item->item.getParentCid()==parentId).collect(Collectors.toList());
    }
    //查询二级分类
    private List<PmsCategory> getParentId(List<PmsCategory>pmsCategories ,Long parentId) {
        return pmsCategories.stream().filter(item->item.getParentCid()==parentId).collect(Collectors.toList());
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
