package com.mycorp.messaging.repository;

import java.util.List;

import javax.validation.constraints.Min;

import com.mycorp.messaging.entity.Employee;

public interface EmployeeRepository {

    List<Employee> getFollowers(int employeeId);

    void addFollower(@Min(0) Integer employeeId, Integer followerId);

    void deleteFollower(@Min(0) Integer employeeId, @Min(0) Integer followerId);
}
