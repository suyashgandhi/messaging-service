package com.mycorp.messaging.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.openapitools.model.Messages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mycorp.messaging.service.MessageService;

@RunWith(MockitoJUnitRunner.class)
public class MessagesControllerTest {

    @InjectMocks
    private MessagesController controller;
    @Mock
    private MessageService messageService;

    @Test
    public void getMessages_offsetNotNull_shouldSucceed() {
        Messages messages = new Messages();
        when(messageService.getMessages(anyInt())).thenReturn(messages);
        ResponseEntity result = controller.getMessages(0);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertSame(messages, result.getBody());
        verify(messageService).getMessages(0);
    }

    @Test
    public void getMessages_offsetNull_shouldSucceed() {
        Messages messages = new Messages();
        when(messageService.getMessages(anyInt())).thenReturn(messages);
        ResponseEntity result = controller.getMessages(null);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertSame(messages, result.getBody());
        verify(messageService).getMessages(0);
    }
}
