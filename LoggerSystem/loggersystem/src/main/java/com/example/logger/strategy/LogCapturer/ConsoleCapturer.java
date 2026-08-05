package com.example.logger.strategy.LogCapturer;

import com.example.logger.model.LogMessage;
import com.example.logger.strategy.LogFormatter.JsonFormatter;
import com.example.logger.strategy.LogFormatter.LogFormatter;

public class ConsoleCapturer implements LogCapturer{
    private final LogFormatter logFormatter;
    public ConsoleCapturer()
    {
        this.logFormatter = new JsonFormatter();
    }
    @Override
    public void capture(LogMessage logMessage)
    {
        String formatedMessage = logFormatter.format(logMessage);
        System.out.println(formatedMessage);
    }
}
