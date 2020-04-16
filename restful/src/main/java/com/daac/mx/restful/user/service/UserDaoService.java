package com.daac.mx.restful.user.service;

import com.daac.mx.restful.user.User;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor
@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<User>();
    private static int usersCount = 3;

    static{
        users.add(new User(1,"Dante", new Date()));
        users.add(new User(2, "Elizabeth", new Date()));
        users.add(new User(3, "Azel", new Date()));
    }

    private User user;

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if (user.getId() == null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        return users.stream()
                         .filter(findUser -> findUser.getId() == id)
                         .findAny()
                         .orElse(null);
    }

    public User deleteById(int id){
        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()){
            User user = userIterator.next();
            if(user.getId() == id){
                userIterator.remove();
                return user;
            }
        }
        return null;
    }
}
