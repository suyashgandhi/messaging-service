package com.mycorp.messaging.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.openapitools.api.EmployeesApi;
import org.openapitools.model.Employee;
import org.openapitools.model.Follower;
import org.openapitools.model.Message;
import org.openapitools.model.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.mycorp.messaging.exception.NotFoundException;
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
        try {
            employeeService.addMessage(employeeId, message);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException nfe) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<Employee>> getFollowers(@Min(0) Integer employeeId) {
        try {
            List<Employee> followers = employeeService.getFollowers(employeeId);
            return ResponseEntity.ok(followers);
        } catch (NotFoundException nfe) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> addFollower(@Min(0) Integer employeeId, @Valid Follower follower) {
        try {
            employeeService.addFollower(employeeId, follower.getEmployeeId());
            return ResponseEntity.noContent().build();
        } catch (NotFoundException nfe) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> removeFollower(@Min(0) Integer employeeId, @Min(0) Integer followerId) {
        try {
            employeeService.removeFollower(employeeId, followerId);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException nfe) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Messages> getFeed(@Min(0) Integer employeeId) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @Override
    public ResponseEntity<Messages> getMessagesByEmployee(@Min(0) Integer employeeId) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
