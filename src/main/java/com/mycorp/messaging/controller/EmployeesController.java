package com.mycorp.messaging.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.openapitools.api.EmployeesApi;
import org.openapitools.model.Employee;
import org.openapitools.model.Follower;
import org.openapitools.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.mycorp.messaging.service.EmployeeService;

/**
 * Controller for Employee APIs
 *
 * @author sgandhi
 */
@Controller
public class EmployeesController implements EmployeesApi {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<Void> postMessage(@Min(0) Integer employeeId, @Valid Message message) {
        employeeService.addMessage(employeeId, message);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Employee>> getFollowers(@Min(0) Integer employeeId) {
        List<Employee> followers = employeeService.getFollowers(employeeId);
        return ResponseEntity.ok(followers);
    }

    @Override
    public ResponseEntity<Void> addFollower(@Min(0) Integer employeeId, @Valid Follower follower) {
        employeeService.addFollower(employeeId, follower.getEmployeeId());
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> removeFollower(@Min(0) Integer employeeId, @Min(0) Integer followerId) {
        employeeService.removeFollower(employeeId, followerId);
        return ResponseEntity.noContent().build();
    }
}
