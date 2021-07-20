package top.niyihua.website;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.niyihua.website.bean.User;
import top.niyihua.website.repository.UserRepo;

@SpringBootTest
class WebsiteApplicationTests {

    @Autowired
    UserRepo userRepo;

    @Test
    void contextLoads() {
        User yihua = userRepo.getUserByUserName("yihua");
        System.out.println(yihua);
    }

}
