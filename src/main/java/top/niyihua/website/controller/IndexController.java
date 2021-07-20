package top.niyihua.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/tabledata")
    public String tableData(){
        return "table-datatable";
    }

    @RequestMapping("/tablebasic")
    public String tableBasic(){
        return "table-basic";
    }
}
