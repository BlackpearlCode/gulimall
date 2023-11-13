package com.gulimall.product.web;

import com.gulimall.product.entity.PmsCategory;
import com.gulimall.product.service.PmsCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private PmsCategoryService categoryService;
    @GetMapping("/")
    public String indexPage(Model model){
        //查询所有一级分类
        List<PmsCategory> categoryList = categoryService.getLevel1Categorys();
        model.addAttribute("categorys",categoryList);
        log.info("categorys的值：{}",categoryList);
        return "index";
    }
}
