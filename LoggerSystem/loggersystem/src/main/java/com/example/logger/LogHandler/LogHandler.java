package com.example.logger.LogHandler;

import java.util.ArrayList;
import java.util.List;

import com.example.logger.enums.LogLevel;
import com.example.logger.model.LogMessage;
import com.example.logger.strategy.LogCapturer.LogCapturer;

public abstract class LogHandler {
    protected LogHandler nextHandler;
    protected List<LogCapturer> observers = new ArrayList<>();
    protected abstract boolean canHandle(LogLevel logLevel);
    
    public void setNextHandler(LogHandler logHandler)
    {
        this.nextHandler = logHandler;
    }
    public void handle(LogMessage logMessage)
    {
        if(canHandle(logMessage.getLogLevel()))
        {
            notifyAll(logMessage);
        }
        else 
        {
            nextHandler.handle(logMessage);
        }
    }

    public void subscribe(LogCapturer logCapturer)
    {
        observers.add(logCapturer);
    }
    public void unsubscribe(LogCapturer logCapturer)
    {
        observers.remove(logCapturer);
    }
    public void notifyAll(LogMessage logMessage)
    {
        for(LogCapturer capturer : observers)
        {
            capturer.capture(logMessage);
        }
    }

}
