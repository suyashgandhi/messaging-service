package com.mycorp.messaging.entity;

import java.util.List;

import com.mycorp.messaging.repository.MessageRepository;

/**
 * Model POJO to map the result of {@link MessageRepository#getMessages(int, int)}}
 *
 */
public class Messages {

    private List<Message> messageList;
    private int offset;

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
