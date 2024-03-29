package com.mycorp.messaging.repository;

import com.mycorp.messaging.entity.Message;
import com.mycorp.messaging.entity.Messages;

public interface MessageRepository {

    Messages getMessages(int offset, int pageSize);

    void addMessage(int employeeId, Message message);

    Message getMessage(int messageId);

    Messages getFeed(int employeeId, int offset, int pageSize);
}
