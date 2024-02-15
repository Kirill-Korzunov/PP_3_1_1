package spring.boot.pp_3_1_1.service;



import spring.boot.pp_3_1_1.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void add(User user);

    User getUser(Long id);

    void update(User user);

    void deleteById(Long id);
}
