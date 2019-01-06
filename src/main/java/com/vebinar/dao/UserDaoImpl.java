package com.vebinar.dao;

import com.vebinar.config.entity.User;
import com.vebinar.config.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
//        String sql = "INSERT INTO user (name, email, age) VALUES (?, ?, ?)";
//        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge());
        String sql = "INSERT INTO user (name, email, age) VALUES";
        jdbcTemplate.update(sql + "('" + user.getName()+"', '" + user.getEmail()+"', '" + user.getAge() + "')");

    }

    @Override
    public User getById(int id) {

        String sql = "SELECT * FROM user WHERE id =";
        return (User) jdbcTemplate.queryForObject(sql+id, new UserMapper());
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE user SET ";
        //jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge(), user.getId());
        jdbcTemplate.update(sql + "name='" + user.getName()+ "', email='" + user.getEmail()+"', age=" + user.getAge() + " WHERE id=" + user.getId() + ";");

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM user WHERE id =";
        jdbcTemplate.update(sql + id);
    }
}
