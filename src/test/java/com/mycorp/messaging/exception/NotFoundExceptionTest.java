package com.mycorp.messaging.exception;

import org.junit.Test;

public class NotFoundExceptionTest {

    @Test
    public void testConstructor_shouldSucceed() {
        new NotFoundException("test");
    }
}
