package top.niyihua.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.niyihua.website.bean.User;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    User getUserByUserName(String userName);
}
