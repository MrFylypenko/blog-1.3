package net.bleser.dao;

import net.bleser.entity.Message;
import net.bleser.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bleser on 16.10.16.
 */
@Repository
public class UserDao implements IUserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        NativeQuery<User> query = session.createNativeQuery("select * from users", User.class);
        return query.getResultList();
    }

    @Override
    public User findUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from net.bleser.entity.User as user where user.username='"+username+"'", User.class);


        return query.getSingleResult();
    }

    @Override
    public List<Message> getUserMessages(String username) {
        User user = findUsername(username);
        return user.getMessages();
    }
}
