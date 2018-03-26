package com.kqueue;

import com.kqueue.exception.IncompatibleQueueException;

public interface Processor extends Runnable{
    /**
     * Processes given queue accordign to their type
     * @param queueId
     * @throws IncompatibleQueueException
     */
    void process(String queueId) throws IncompatibleQueueException;
}
