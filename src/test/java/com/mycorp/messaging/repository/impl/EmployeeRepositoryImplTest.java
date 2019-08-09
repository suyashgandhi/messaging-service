package com.mycorp.messaging.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mycorp.messaging.entity.Employee;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeRepositoryImplTest {

    @InjectMocks
    private EmployeeRepositoryImpl repository;
    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    public void getFollowers_shouldSucceed() {
        repository.getFollowers(1);
        verify(jdbcTemplate).query(eq(EmployeeRepositoryImpl.GET_FOLLOWERS_QUERY), any(BeanPropertyRowMapper.class), eq(1));
    }

    @Test
    public void addFollower_shouldSucceed() {
        repository.addFollower(1, 2);
        verify(jdbcTemplate).update(eq(EmployeeRepositoryImpl.ADD_FOLLOWER_QUERY), any(Object.class));
    }

    @Test
    public void deleteFollower_shouldSucceed() {
        repository.deleteFollower(1, 2);
        verify(jdbcTemplate).update(EmployeeRepositoryImpl.DELETE_FOLLOWER_QUERY, 2, 1);
    }

    @Test
    public void getEmployee_shouldSucceed() {
        Employee employee = new Employee();
        when(jdbcTemplate.queryForObject(eq(EmployeeRepositoryImpl.GET_EMPLOYEE_QUERY), any(BeanPropertyRowMapper.class), eq(1))).thenReturn(employee);
        Employee result = repository.getEmployee(1);
        assertEquals(employee, result);
    }
}
