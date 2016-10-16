package net.bleser.service;

import net.bleser.dao.IUserDao;
import net.bleser.entity.Message;
import net.bleser.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bleser on 16.10.16.
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    @Transactional
    public List getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public User findUsername(String username) {
        return userDao.findUsername(username);
    }

    @Override
    @Transactional()
    public List<Message> getUserMessages(String username) {
        return userDao.getUserMessages(username);
    }
}
