package com.es.gulimalles;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallEsApplicationTests {

    @Test
    void contextLoads() {
        String str="catalog3Id=225&brandId=14&attrs=15_%E9%AB%98%E9%80%9A(Qualcomm)";
        String s="&attrs=15_%E9%AB%98%E9%80%9A%28Qualcomm%29";
        System.out.println(str.replace(s,""));
    }

}
