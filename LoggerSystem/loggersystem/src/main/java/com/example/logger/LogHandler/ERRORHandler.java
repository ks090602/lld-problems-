package com.example.logger.LogHandler;


import com.example.logger.enums.LogLevel;
import com.example.logger.model.LogMessage;

public class ERRORHandler extends LogHandler{
    @Override
    public boolean canHandle(LogLevel level)
    {
        if(level==LogLevel.ERROR) return true;
        return false;
    }

    @Override
    public void handle(LogMessage logMessage)
    {
        if(canHandle(logMessage.getLogLevel()))
        {
            notifyAll(logMessage);
        }
        else 
        {
            System.out.println("No Such log level to fullfill the request");
        }
    }
}
