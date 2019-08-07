package com.mycorp.messaging.entity;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class MessageTest {

    private static final String TEXT = "test";
    private static final long EMPLOYEE_ID = 1L;
    private static final Date CREATE_DATE = new Date();
    private static int ROW_ID = 1;

    @Test
    public void testGettersAndSetters() {
        Message message = new Message();
        message.setText(TEXT);
        message.setTitle(TEXT);
        message.setEmployeeId(EMPLOYEE_ID);
        message.setCreateDate(CREATE_DATE);
        message.setId(ROW_ID);
        message.setRowId(ROW_ID);
        message.setUpdateDate(CREATE_DATE);
        assertSame(TEXT, message.getText());
        assertSame(TEXT, message.getTitle());
        assertEquals(EMPLOYEE_ID, message.getEmployeeId());
        assertSame(CREATE_DATE, message.getCreateDate());
        assertEquals(ROW_ID, message.getRowId());
        assertSame(CREATE_DATE, message.getUpdateDate());
    }
}
