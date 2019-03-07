package com.hzxy.show.web.api;

import com.hzxy.domain.entity.Category;
import com.hzxy.domain.utils.ResultModel;
import com.hzxy.domain.utils.ResultTools;
import com.hzxy.domain.utils.pageResult;
import com.hzxy.show.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/show/category")
public class CategoryController1 {
  @Autowired
    private CategoryService categoryService;

    @GetMapping("/selectAll")
    public  ResultModel selectAll(){
        Map<String,Object> result=new HashMap<>();
        List<Category> categories = categoryService.selectAll();
        int flag=0;
        if(categories.size()==0){
            flag=1;
        }
        result.put("data",categories);
        return ResultTools.result(flag,"",result);
    }

    //获取该系统下的所有区域
    @GetMapping("/getArea")
    public pageResult count(){
        pageResult pageResult = categoryService.selectByName("贺州语言处理系统");
        return pageResult;
    }

    //获取各区域下的所有语种及种数
    @GetMapping("/category")
    public Map<String,Object> wuzhou(){
        Map<String,Object> result=new HashMap<>();

        pageResult pageResult1 = categoryService.selectByName("梧州");
        pageResult pageResult2 = categoryService.selectByName("八步区");
        pageResult pageResult3 = categoryService.selectByName("平桂区");
        pageResult pageResult4 = categoryService.selectByName("绍平县");
        pageResult pageResult5 = categoryService.selectByName("钟山县");
        result.put("梧州",pageResult1);
        result.put("八步区",pageResult2);
        result.put("平桂区",pageResult3);
        result.put("绍平县",pageResult4);
        result.put("钟山县",pageResult5);

        return result;
    }



}