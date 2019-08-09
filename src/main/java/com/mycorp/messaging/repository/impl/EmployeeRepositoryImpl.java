package com.mycorp.messaging.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mycorp.messaging.entity.Employee;
import com.mycorp.messaging.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    // Below constants are made visible For testing
    static String GET_FOLLOWERS_QUERY = "select * from employee where employee_id in (select follower_id from follower where publisher_id = ?)";
    static String ADD_FOLLOWER_QUERY = "insert into follower(follower_id, publisher_id) values (?, ?)";
    static String DELETE_FOLLOWER_QUERY = "delete from follower where follower_id = ? and publisher_id = ?";
    static String GET_EMPLOYEE_QUERY = "select * from employee where employee_id = ?";

    @Override
    public List<Employee> getFollowers(int employeeId) {
        return jdbcTemplate.query(GET_FOLLOWERS_QUERY, new BeanPropertyRowMapper<>(Employee.class), employeeId);
    }

    @Override
    public void addFollower(int employeeId, int followerId) {
        jdbcTemplate.update(ADD_FOLLOWER_QUERY, new Object[] {followerId, employeeId});
    }

    @Override
    public void deleteFollower(int employeeId, int followerId) {
        jdbcTemplate.update(DELETE_FOLLOWER_QUERY, followerId, employeeId);
    }

    @Override
    public Employee getEmployee(int employeeId) {
       return jdbcTemplate.queryForObject(GET_EMPLOYEE_QUERY, new BeanPropertyRowMapper<>(Employee.class), employeeId);
    }
}
