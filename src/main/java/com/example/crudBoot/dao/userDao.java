package com.example.crudBoot.dao;
import com.example.crudBoot.model.User;

import java.util.List;

public interface userDao {
    List<User> allUsers ();
    void add (User user);
    void delete (User user);
    void edit (User user);
    User getById (int id);
}
