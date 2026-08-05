package com.example.logger.strategy.LogFormatter;

import com.example.logger.model.LogMessage;

public class JsonFormatter implements LogFormatter{
    @Override
    public String format(LogMessage logMessage)
    {
        return convertStringToJSON(logMessage);
    }

    private String convertStringToJSON(LogMessage logMessage)
    {
        return String.format("{\"level\" : \"%s\" , \"message\" : \"%s\" , \"timestamp\" : \"%s\"}",
            logMessage.getLogLevel(),
            logMessage.getMessage(),
            logMessage.getTimestamp()
        );
    }
}
