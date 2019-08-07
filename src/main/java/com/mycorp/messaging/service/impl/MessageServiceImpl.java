package com.mycorp.messaging.service.impl;

import org.openapitools.model.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycorp.messaging.mapper.ModelMapper;
import com.mycorp.messaging.repository.MessageRepository;
import com.mycorp.messaging.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ModelMapper mapper;
    private final int PAGE_SIZE = 2;

    @Override
    public Messages getMessages(int offset) {
        com.mycorp.messaging.entity.Messages result = messageRepository.getMessages(offset, PAGE_SIZE);
        Messages messages = new Messages();
        messages.setMessages(mapper.mapAsList(result.getMessageList(), org.openapitools.model.Message.class));
        messages.setOffset(result.getOffset());
        return messages;
    }
}
