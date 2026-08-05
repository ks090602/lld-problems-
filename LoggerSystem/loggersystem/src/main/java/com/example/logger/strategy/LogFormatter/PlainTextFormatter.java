package com.example.logger.strategy.LogFormatter;

import com.example.logger.model.LogMessage;

public class PlainTextFormatter implements LogFormatter{
    @Override
    public String format(LogMessage logMessage)
    {
        return logMessage.getMessage();
    }
}
