package com.sevenb.invoices.repository;

import com.sevenb.invoices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * User repository. Access users database
 */
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
    public User findByUsernameAndPassword(String username, String password);
    public List<User> findAll();
    public User save(User user);

}