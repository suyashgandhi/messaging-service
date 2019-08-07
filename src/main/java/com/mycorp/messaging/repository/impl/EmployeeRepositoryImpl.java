package com.mycorp.messaging.repository.impl;

import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mycorp.messaging.entity.Employee;
import com.mycorp.messaging.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getFollowers(int employeeId) {
        return jdbcTemplate
                .query("select * from employee where employee_id in (select follower_id from follower where publisher_id = ?)",
                        new BeanPropertyRowMapper<>(Employee.class), employeeId);
    }

    @Override
    public void addFollower(@Min(0) Integer employeeId, Integer followerId) {
        jdbcTemplate.update("insert into follower(follower_id, publisher_id) values (?, ?)", new Object[] {followerId, employeeId});
    }

    @Override
    public void deleteFollower(@Min(0) Integer employeeId, @Min(0) Integer followerId) {
        jdbcTemplate.update("delete from follower where follower_id = ? and publisher_id = ?", followerId, employeeId);
    }
}
