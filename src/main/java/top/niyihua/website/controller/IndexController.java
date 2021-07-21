package top.niyihua.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.niyihua.website.bean.Menu;
import top.niyihua.website.repository.MenuRepo;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private  List<Menu> list ;
    @Autowired
    MenuRepo menuRepo;
    @RequestMapping("/")
    public String index(Model model){
        List<Menu> menusByPidIsNull = menuRepo.findMenusByPidIsNull();
        for(int i = 0;i<menusByPidIsNull.size();i++){
            Menu menu = menusByPidIsNull.get(i);
            List<Menu> menusByPid = menuRepo.findMenusByPid(menu.getId());
            menu.setChildren(menusByPid);
        }
        list = menusByPidIsNull;
        model.addAttribute("menuPermission",list);
        return "index";
    }

    @RequestMapping("/index")
    public String home(Model model){
        List<Menu> menusByPidIsNull = menuRepo.findMenusByPidIsNull();
        for(int i = 0;i<menusByPidIsNull.size();i++){
            Menu menu = menusByPidIsNull.get(i);
            List<Menu> menusByPid = menuRepo.findMenusByPid(menu.getId());
            menu.setChildren(menusByPid);
        }
        list = menusByPidIsNull;
        model.addAttribute("menuPermission",list);
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

    @RequestMapping("/login")
    public String login(){
        return "page-login";
    }
}
