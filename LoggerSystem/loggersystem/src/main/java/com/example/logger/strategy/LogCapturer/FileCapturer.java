package com.example.logger.strategy.LogCapturer;

import java.io.FileWriter;
import java.io.IOException;

import com.example.logger.model.LogMessage;
import com.example.logger.strategy.LogFormatter.LogFormatter;
import com.example.logger.strategy.LogFormatter.PlainTextFormatter;

public class FileCapturer implements LogCapturer{
    private final LogFormatter logFormatter;
    private final static Object OBJECT_LOCK = new Object();
    public FileCapturer()
    {
        this.logFormatter = new PlainTextFormatter();
    }

    @Override
    public void capture(LogMessage logMessage)
    {
        String formatedMessage = logFormatter.format(logMessage);
        synchronized(OBJECT_LOCK){
            try(FileWriter writer = new FileWriter("logs.txt",true)
            ){
                writer.write(formatedMessage);
                writer.write(System.lineSeparator());
            }
            catch(IOException exception)
            {
               System.out.println(exception.getMessage());
            }
        }
    }
}
