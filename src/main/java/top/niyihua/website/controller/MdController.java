//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package top.niyihua.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.niyihua.website.bean.Article;
import top.niyihua.website.repository.ArticleRepo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping({"/md"})
public class MdController extends BaseController{
    @Autowired
    ArticleRepo articleRepo;

    public MdController() {
    }

    @RequestMapping({"/add"})
    public String menuManage(Model model) {
        return "/layui/md/main";
    }

    @RequestMapping({"/articles"})
    public String articlesManage(Model model) {
        return "/layui/md/articles";
    }

    @RequestMapping({"/articles/data"})
    @ResponseBody
    public String articleData(String id)  {
        Article article = articleRepo.findById(id).orElse(new Article());
        return article.getContext();
    }

    @RequestMapping({"/articles/list"})
    @ResponseBody
    public Map<String, Object> listArticles(Model model) throws IOException {
        Map<String, Object> resultMap = new HashMap();
        List<Article> article = articleRepo.findAll();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", article.size());
        resultMap.put("data", article);
        return resultMap;
    }

    @RequestMapping({"/articles/add"})
    @ResponseBody
    public String add(Article article)  {
        article.setId(UUID.randomUUID().toString().replace("-", ""));
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        articleRepo.save(article);
        return "{\"result\":\"success\"}";
    }

    @RequestMapping({"/articles/delete/{id}"})
    @ResponseBody
    public String delete(@PathVariable("id") String id) throws IOException {
        articleRepo.deleteById(id);
        return "{\"result\":\"success\"}";
    }

    @RequestMapping({"/index"})
    public String index(Model model) throws IOException {
        allPermission(model);
        Map<String, Object> resultMap = new HashMap();
        List<Article> article = articleRepo.findAll();
        model.addAttribute("articles",article);
        return "md";
    }

    @RequestMapping({"/view/{id}"})
    public String aou(Model model,@PathVariable("id") String id) {
        allPermission(model);
        model.addAttribute("id",id);
        return "md-view";
    }
}
