package com.safa.webservices.Web.Service.User;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int userIdCount = 3;

    static {
        users.add(new User(1, "Jhone", new Date()));
        users.add(new User(2, "Maria", new Date()));
        users.add(new User(3, "Tom", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++userIdCount);
        }
        users.add(user);

        return user;
    }
    public User findOne(int id){
        for (User user:users) {
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }

    public User delete(int id){
        Iterator<User> userIterator = users.iterator();
        while(userIterator.hasNext()){
            User user = userIterator.next();
            if(user.getId() == id){
                users.remove(user);
                return user;
            }
        }
        return null;

    }
}
