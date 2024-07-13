package com.example.jpa;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class UserMain {

    // @Slf4j와 같음
//    private static final Logger log = LoggerFactory.getLogger(UserMain.class);

    public static void main(String[] args) {
//        UserDao userDao = new UserDao();
//
//        User ksuser = new User("dao","dao@gmail.com");
//
//        userDao.creatUser(ksuser);
//
//        log.info("Create User : " + ksuser.getName());
//
//        log.info("User Email : {}" , ksuser.getEmail());
//    }

        UserDao userDao = new UserDao();

//        //findUSer()
//        log.info("======================findUSer()=====================");
//        User finduser = userDao.finduser(1L);
//        log.info("Found user {} ", finduser.getName());
//
//        User finduser2 = userDao.finduser(1L);
//        if(finduser == finduser2) {
//            log.info("finduser == finduser2 ");
//        }else
//            log.info("finduser /= finduser2 ");
//    }

        User user = new User();
        user.setId(2L);

        userDao.deleteUser(user);

//        userDao.updateUSer(user);

    }
}
