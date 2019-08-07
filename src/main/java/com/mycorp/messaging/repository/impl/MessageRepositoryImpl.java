package com.mycorp.messaging.repository.impl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mycorp.messaging.entity.Message;
import com.mycorp.messaging.entity.Messages;
import com.mycorp.messaging.repository.MessageRepository;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String GET_MESSAGES_QUERY = "SELECT * from (SELECT rownum as row_id, * FROM MESSAGE order by create_date desc) where row_id between ? and ?";

    @Override
    public Messages getMessages(int offset, int pageSize) {
        Messages messages = new Messages();
        List<Message> messageList = jdbcTemplate
                .query(GET_MESSAGES_QUERY, new BeanPropertyRowMapper<>(Message.class), offset + 1, offset + pageSize);
        messages.setMessageList(messageList);
        if (messageList.size() == 0) {
            messages.setOffset(0);
        } else {
            messages.setOffset(messageList.get(0).getRowId());
        }
        return messages;
    }

    @Override
    public void addMessage(int employeeId, Message message) {
        Object[] params = new Object[] { employeeId, message.getTitle(), message.getText()};
        int[] types = new int[] { Types.INTEGER, Types.VARCHAR, Types.VARCHAR};
        jdbcTemplate.update("insert into message(employee_id, title, text) values(?,?,?)", params, types);
    }
}
