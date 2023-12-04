package com.es.web.contorller;

import com.es.service.IMallSearchService;
import com.es.vo.SearchParam;
import com.es.vo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class SearchController {

    @Autowired
    IMallSearchService mallSearchService;
    @GetMapping("/list.html")
    public String listPage(SearchParam param, Model model) throws IOException {
        //根据传递过来的页面参数，去es中查询商品
        SearchResult result=mallSearchService.search(param);
        model.addAttribute("result",result);
        return "list";
    }
}
