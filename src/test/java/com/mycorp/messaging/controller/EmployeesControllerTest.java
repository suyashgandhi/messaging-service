package com.mycorp.messaging.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
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
}
