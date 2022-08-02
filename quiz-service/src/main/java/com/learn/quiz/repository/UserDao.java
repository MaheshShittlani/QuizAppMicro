package com.learn.quiz.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learn.quiz.entity.User;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public User getByEmailIdAndPassword(String userName, String password) {
		List<User> rs = jdbcTemplate.query("SELECT u.* from user u where u.email_id = ? and u.password = ?",
				new BeanPropertyRowMapper<User>(User.class), new Object[] { userName, password });
		if (rs != null && rs.size() > 0) {
			return rs.get(0);
		} else {
			return null;
		}
	}

	public User findById(Long id) {
		List<User> rs = jdbcTemplate.query("SELECT u.* from user u where u.id = ?",
				new BeanPropertyRowMapper<User>(User.class), new Object[] { id });
		if (rs != null && rs.size() > 0) {
			return rs.get(0);
		} else {
			return null;
		}
	}

}
