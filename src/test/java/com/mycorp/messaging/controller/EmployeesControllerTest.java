package com.mycorp.messaging.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.openapitools.model.Employee;
import org.openapitools.model.Follower;
import org.openapitools.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mycorp.messaging.exception.NotFoundException;
import com.mycorp.messaging.service.impl.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeesControllerTest {

    @InjectMocks
    private EmployeesController controller;
    @Mock
    private EmployeeServiceImpl employeeService;

    @Test
    public void postMessage_shouldSucceed() throws NotFoundException {
        Message message = new Message();
        ResponseEntity responseEntity = controller.postMessage(1, message);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(employeeService).addMessage(1, message);
    }

    @Test
    public void getFollowers_shouldSucceed() throws NotFoundException {
        List<Employee> employeeList = new ArrayList<>();
        when(employeeService.getFollowers(1)).thenReturn(employeeList);
        ResponseEntity responseEntity = controller.getFollowers(1);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(employeeService).getFollowers(1);
    }

    @Test
    public void addFollower_shouldSucceed() throws NotFoundException {
        Follower follower = new Follower();
        follower.setEmployeeId(2);
        ResponseEntity responseEntity = controller.addFollower(1, follower);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(employeeService).addFollower(1, follower.getEmployeeId());
    }

    @Test
    public void removeFollower_shouldSucceed() throws NotFoundException {
        ResponseEntity responseEntity = controller.removeFollower(1, 2);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(employeeService).removeFollower(1, 2);
    }

    @Test
    public void getMessagesByEmployee_shouldSucceed() {
        ResponseEntity responseEntity = controller.getMessagesByEmployee(1);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
        verifyZeroInteractions(employeeService);
    }
}
