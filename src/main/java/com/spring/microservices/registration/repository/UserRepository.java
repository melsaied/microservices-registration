package com.spring.microservices.registration.repository;

import com.spring.microservices.registration.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    public static Map<Integer, User> map = new HashMap<>();

    public User findById(Long id) {
        return new User(id, "firstName", "lastName", "email", "password");
    }

    public Collection<User> findAll() {
        Collection users = new ArrayList();
        long id = 0;
        users.add(new User(id++, "firstName", "lastName", "email", "password"));
        users.add(new User(id++, "firstName", "lastName", "email", "password"));
        users.add(new User(id++, "firstName", "lastName", "email", "password"));
        users.add(new User(id++, "firstName", "lastName", "email", "password"));
        users.add(new User(id++, "firstName", "lastName", "email", "password"));
        return users;
    }

    public User save(User user) {
        if (user.getId() != null)
            return new User(user.getId() + 1, "firstName", "lastName", "email", "password");
        int id = map.size() + 1;
        user.setId(Long.valueOf(id));
        map.put(id, user);
        return map.get(id);
    }

    public User deleteById(Long id) {
        return new User(id, "firstName", "lastName", "email", "password");
    }
}