package com.mycorp.messaging.entity;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class EmployeeTest {

    @Test
    public void testGettersAndSetters() {
        final long EMPLOYEE_ID = 1L;
        final String NAME = "test";
        final Date CREATE_DATE = new Date();
        Employee employee = new Employee();
        employee.setCreateDate(CREATE_DATE);
        employee.setUpdateDate(CREATE_DATE);
        employee.setEmployeeId(EMPLOYEE_ID);
        employee.setFirstName(NAME);
        employee.setLastName(NAME);
        assertSame(CREATE_DATE, employee.getCreateDate());
        assertSame(CREATE_DATE, employee.getUpdateDate());
        assertSame(NAME, employee.getFirstName());
        assertSame(NAME, employee.getLastName());
        assertEquals(EMPLOYEE_ID, employee.getEmployeeId());
    }
}
