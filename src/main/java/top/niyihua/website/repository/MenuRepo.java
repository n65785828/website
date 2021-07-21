package top.niyihua.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.niyihua.website.bean.Menu;

import java.util.List;

@Repository
public interface MenuRepo extends JpaRepository<Menu,String > {
    List<Menu> findMenusByPidIsNull();
    List<Menu> findMenusByPid(String pid);
}
