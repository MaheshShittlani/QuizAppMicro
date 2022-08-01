package com.learn.quiz.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learn.quiz.entity.LoginSession;

@Repository
public class LoginSessionDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Integer deleteByAccessToken(String accessToken) {
		return jdbcTemplate.update("delete from login_session ls where ls.access_token = ?",
				new Object[] { accessToken });
	}

	public LoginSession findByAccessToken(String accessToken) {
		List<LoginSession> rs = jdbcTemplate.query("SELECT ls.* from login_session ls where ls.access_token = ?",
				new BeanPropertyRowMapper<LoginSession>(LoginSession.class), new Object[] { accessToken });
		if (rs != null && rs.size() > 0) {
			return rs.get(0);
		} else {
			return null;
		}
	}

	public LoginSession getByUserId(Long userId) {
		List<LoginSession> rs = jdbcTemplate.query("SELECT ls.* from login_session ls where ls.user_id = ?",
				new BeanPropertyRowMapper<LoginSession>(LoginSession.class), new Object[] { userId });
		if (rs != null && rs.size() > 0) {
			return rs.get(0);
		} else {
			return null;
		}
	}

	public LoginSession save(LoginSession loginSession) {
		jdbcTemplate.update("INSERT INTO `quiz`.`login_session` (`user_id`, `access_token`) VALUES (?, ?)",
				new Object[] { loginSession.getUserId(), loginSession.getAccessToken() });
		return getByUserId(loginSession.getUserId());
	}

}
