package com.mycorp.messaging.service.impl;

import java.util.List;

import org.openapitools.model.Employee;
import org.openapitools.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mycorp.messaging.exception.NotFoundException;
import com.mycorp.messaging.mapper.ModelMapper;
import com.mycorp.messaging.repository.EmployeeRepository;
import com.mycorp.messaging.repository.MessageRepository;
import com.mycorp.messaging.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired private MessageRepository messageRepository;
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private ModelMapper mapper;

    @Override
    public void addMessage(int employeeId, Message message) throws NotFoundException {
        validateEmployeeId(employeeId);
        com.mycorp.messaging.entity.Message messageToAdd = new com.mycorp.messaging.entity.Message();
        messageToAdd.setEmployeeId(employeeId);
        messageToAdd.setTitle(message.getTitle());
        messageToAdd.setText(message.getText());
        messageRepository.addMessage(employeeId, messageToAdd);
    }

    @Override
    public List<Employee> getFollowers(int employeeId) throws NotFoundException {
        validateEmployeeId(employeeId);
        return mapper.mapAsList(employeeRepository.getFollowers(employeeId), org.openapitools.model.Employee.class);
    }

    @Override
    public void addFollower(int employeeId, int followerId) throws NotFoundException {
        validateEmployeeId(employeeId);
        validateEmployeeId(followerId);
        employeeRepository.addFollower(employeeId, followerId);
    }

    @Override
    public void removeFollower(int employeeId, int followerId) throws NotFoundException {
        validateEmployeeId(employeeId);
        validateEmployeeId(followerId);
        employeeRepository.deleteFollower(employeeId, followerId);
    }

    private void validateEmployeeId(int employeeId) throws NotFoundException {
        try {
            employeeRepository.getEmployee(employeeId);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("No employee found with employee id=" + employeeId);
        }
    }
}
