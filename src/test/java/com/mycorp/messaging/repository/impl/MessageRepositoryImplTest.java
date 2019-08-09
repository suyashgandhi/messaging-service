package com.mycorp.messaging.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;

import com.mycorp.messaging.entity.Message;
import com.mycorp.messaging.entity.Messages;

@RunWith(MockitoJUnitRunner.class)
public class MessageRepositoryImplTest {

    @InjectMocks
    private MessageRepositoryImpl messageRepository;
    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    public void getMessages_noResults_shouldSucced() {
        Messages messages = messageRepository.getMessages(0, 5);
        verify(jdbcTemplate).query(eq(MessageRepositoryImpl.GET_MESSAGES_QUERY), any(BeanPropertyRowMapper.class), eq(1), eq(5));
        assertEquals(0, messages.getOffset());
        assertTrue(CollectionUtils.isEmpty(messages.getMessageList()));
    }

    @Test
    public void getMessages_shouldSucceed() {
        List<Message> messageList = new ArrayList<Message>();
        Message message = new Message();
        message.setRowId(1);
        messageList.add(message);
        when(jdbcTemplate.query(eq(MessageRepositoryImpl.GET_MESSAGES_QUERY), any(BeanPropertyRowMapper.class), eq(1), eq(5))).thenReturn(messageList);
        Messages result = messageRepository.getMessages(0, 5);
        verify(jdbcTemplate).query(eq(MessageRepositoryImpl.GET_MESSAGES_QUERY), any(BeanPropertyRowMapper.class), eq(1), eq(5));
        assertEquals(1, result.getOffset());
        assertSame(messageList, result.getMessageList());
    }

    @Test
    public void getMessage_shouldSucceed() {
        Message message = new Message();
        when(jdbcTemplate.queryForObject(eq(MessageRepositoryImpl.GET_MESSAGE_QUERY), any(BeanPropertyRowMapper.class), eq(1))).thenReturn(message);
        Message result = messageRepository.getMessage(1);
        verify(jdbcTemplate).queryForObject(eq(MessageRepositoryImpl.GET_MESSAGE_QUERY), any(BeanPropertyRowMapper.class), eq(1));
        assertSame(message, result);
    }

    @Test
    public void addMessage_shouldSucceed() {
        Message message = new Message();
        messageRepository.addMessage(1, message);
        verify(jdbcTemplate).update(eq(MessageRepositoryImpl.ADD_MESSAGE_QUERY), any(), any());
    }
}
