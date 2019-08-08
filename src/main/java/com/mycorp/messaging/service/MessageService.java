package com.mycorp.messaging.service;

import org.openapitools.model.Message;
import org.openapitools.model.Messages;

import com.mycorp.messaging.exception.NotFoundException;

public interface MessageService {

    Messages getMessages(int offset);

    Message getMessage(int messageId) throws NotFoundException;
}
