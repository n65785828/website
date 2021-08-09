package top.niyihua.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.niyihua.website.bean.Article;

public interface ArticleRepo extends JpaRepository<Article,String> {
}
