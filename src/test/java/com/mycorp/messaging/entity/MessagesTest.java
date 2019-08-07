package com.mycorp.messaging.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MessagesTest {

    @Test
    public void testGettersAndSetters() {
        Messages messages = new Messages();
        messages.setOffset(1);
        List<Message> messageList = new ArrayList<>();
        messages.setMessageList(messageList);
        assertEquals(1, messages.getOffset());
        assertSame(messageList, messages.getMessageList());
    }
}
