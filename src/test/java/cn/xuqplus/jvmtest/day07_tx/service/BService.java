package cn.xuqplus.jvmtest.day07_tx.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class BService {
    /*
    create table user (
	id bigint primary key,
    name varchar(255)
    );
     */

    @Resource
    private JdbcTemplate jdbcTemplate;

    public void insertUser(Long id, String name) {
        jdbcTemplate.update("insert into user(id, name) values(?, ?)", id, name);
    }

    public void updateUser(Long id, String name) {
        jdbcTemplate.update("update user set name = ? where id = ?", name, id);
    }

    public void deleteUser(Long id) {
        jdbcTemplate.update("delete from user where id = ?", id);
    }

    public void deleteUserByName(String name) {
        jdbcTemplate.update("delete from user where name = ?", name);
    }

}
