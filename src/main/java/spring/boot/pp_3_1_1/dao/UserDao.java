package spring.boot.pp_3_1_1.dao;



import spring.boot.pp_3_1_1.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void add(User user);

    User getUser(Long id);

    void update(User user);

    void deleteById(Long id);
}
