package com.mycorp.messaging.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.openapitools.model.Employee;
import org.openapitools.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycorp.messaging.mapper.ModelMapper;
import com.mycorp.messaging.repository.EmployeeRepository;
import com.mycorp.messaging.repository.MessageRepository;

@Service
public class EmployeeService {

    @Autowired private MessageRepository messageRepository;
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private ModelMapper mapper;

    public void addMessage(@Min(0) Integer employeeId, @Valid Message message) {
        com.mycorp.messaging.entity.Message messageToAdd = new com.mycorp.messaging.entity.Message();
        messageToAdd.setEmployeeId(employeeId);
        messageToAdd.setTitle(message.getTitle());
        messageToAdd.setText(message.getText());
        messageRepository.addMessage(employeeId, messageToAdd);
    }

    public List<Employee> getFollowers(@Min(0) Integer employeeId) {
        return mapper.mapAsList(employeeRepository.getFollowers(employeeId), org.openapitools.model.Employee.class);
    }

    public void addFollower(@Min(0) Integer employeeId, Integer followerId) {
        employeeRepository.addFollower(employeeId, followerId);
    }

    public void removeFollower(@Min(0) Integer employeeId, @Min(0) Integer followerId) {
        employeeRepository.deleteFollower(employeeId, followerId);
    }
}
