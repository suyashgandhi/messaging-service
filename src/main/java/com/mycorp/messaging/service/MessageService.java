package com.mycorp.messaging.service;

import org.openapitools.model.Messages;

public interface MessageService {

    Messages getMessages(int offset);
}
