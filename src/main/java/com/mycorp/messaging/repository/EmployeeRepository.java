package com.mycorp.messaging.repository;

import java.util.List;

import com.mycorp.messaging.entity.Employee;

public interface EmployeeRepository {

    List<Employee> getFollowers(int employeeId);

    void addFollower(int employeeId, int followerId);

    void deleteFollower(int employeeId, int followerId);

    Employee getEmployee(int employeeId);
}
