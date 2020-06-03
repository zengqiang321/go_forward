package com.jack.transcation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by manchong on 2020/6/2.
 */
@Repository
public class TopicFollowDao {

    @Autowired
    @Qualifier("jdbcTemplate2")
    private JdbcTemplate jdbcTemplate;

    public void updateTopic(int id,int time){
        String sql="update who_style_topic_follow set create_time=? where id=?";
        jdbcTemplate.update(sql,time,id);
    }

}
