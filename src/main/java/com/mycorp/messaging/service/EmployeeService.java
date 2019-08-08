package com.mycorp.messaging.service;

import java.util.List;

import org.openapitools.model.Employee;
import org.openapitools.model.Message;

import com.mycorp.messaging.exception.NotFoundException;

public interface EmployeeService {

    void addMessage(int employeeId, Message message) throws NotFoundException;

    List<Employee> getFollowers(int employeeId) throws NotFoundException;

    void addFollower(int employeeId, int followerId) throws NotFoundException;

    void removeFollower(int employeeId, int followerId) throws NotFoundException;
}
