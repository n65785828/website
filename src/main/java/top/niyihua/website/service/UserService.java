package top.niyihua.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.niyihua.website.bean.User;
import top.niyihua.website.repository.UserRepo;


@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User getUserByName(String userName){
       return userRepo.getUserByUserName(userName);
    }
}
