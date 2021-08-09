package top.niyihua.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import top.niyihua.website.bean.Menu;
import top.niyihua.website.repository.MenuRepo;

import java.util.List;

public class BaseController {
    private List<Menu> menus;
    @Autowired
    MenuRepo menuRepo;

    public void allPermission(Model model) {
        List<Menu> menusByPidIsNull = menuRepo.findMenusByPidIsNull();
        for (int i = 0; i < menusByPidIsNull.size(); i++) {
            Menu menu = menusByPidIsNull.get(i);
            List<Menu> menusByPid = menuRepo.findMenusByPid(menu.getId());
            menu.setChildren(menusByPid);
        }
        menus = menusByPidIsNull;
        model.addAttribute("menuPermission", menus);
    }
}
