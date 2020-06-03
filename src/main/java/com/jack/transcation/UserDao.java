package com.jack.transcation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manchong on 2020/6/1.
 */
@Repository("jdbcUserDao")
public class UserDao {


    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public UserInfo getUserInfo(Integer userId){
        String sql="select user_id userId,user_name userName from who_style_user_info where user_id=?";
        RowMapper<UserInfo> rowMapper = new BeanPropertyRowMapper<>(UserInfo.class);
        UserInfo userInfo = jdbcTemplate.queryForObject(sql, new Object[]{userId}, rowMapper);
        return userInfo;
    }

    public void insert(Integer userId,Integer time){
        String insertSql ="insert into who_style_small_top(user_id,update_time) values(?,?)";

        jdbcTemplate.update(insertSql,userId,time);
    }

    public void insert2(Integer userId,Integer time){
        String insertSql ="insert into who_style_small_top(user_id,update_time) values(?,?)";
        jdbcTemplate.update(insertSql,userId,time);
        jdbcTemplate.update(insertSql,userId,time);
    }

    public static class UserInfo{
        private Integer userId;
        private String userName;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        @Override
        public String toString() {
            return "UserInfo{" +
                    "userId=" + userId +
                    ", userName='" + userName + '\'' +
                    '}';
        }
    }
}
