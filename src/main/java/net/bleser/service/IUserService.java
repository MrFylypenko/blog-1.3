package net.bleser.service;

import net.bleser.dao.IUserDao;
import net.bleser.entity.Message;
import net.bleser.entity.User;

import java.util.List;

/**
 * Created by bleser on 16.10.16.
 */
public interface IUserService{


     void save(User user);


     void update(User user);


     List getAllUsers();


     User findUsername(String username);


     List<Message> getUserMessages(String username) ;
}
