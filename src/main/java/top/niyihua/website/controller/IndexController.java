package top.niyihua.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController{


    @RequestMapping("/")
    public String index(Model model){
        allPermission(model);
        return "index";
    }

    @RequestMapping("/index")
    public String home(Model model){
        allPermission(model);
        return "index";
    }



    @RequestMapping("/tabledata")
    public String tableData(Model model){
        allPermission(model);
        return "table-datatable";
    }

    @RequestMapping("/tablebasic")
    public String tableBasic(Model model){
        allPermission(model);
        return "table-basic";
    }

    @RequestMapping("/login")
    public String login(){
        return "page-login";
    }
}
