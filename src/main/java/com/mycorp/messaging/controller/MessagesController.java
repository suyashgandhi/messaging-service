package com.mycorp.messaging.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.openapitools.api.MessagesApi;
import org.openapitools.model.Message;
import org.openapitools.model.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.mycorp.messaging.exception.NotFoundException;
import com.mycorp.messaging.service.MessageService;

/**
 * Controller for Messages API
 *
 * @author sgandhi
 */
@Controller
public class MessagesController implements MessagesApi {

    @Autowired
    private MessageService messagesService;

    @Override
    public ResponseEntity<Messages> getMessages(@Min(0) @Valid Integer offset) {
        return ResponseEntity.ok(messagesService.getMessages(offset != null ? offset : 0));
    }

    @Override
    public ResponseEntity<Message> getMessage(@Min(0) Integer messageId) {
        Message message;
        try {
            message = messagesService.getMessage(messageId);
            return ResponseEntity.ok(message);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
