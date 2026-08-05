package com.example.logger.service;

import com.example.logger.LogHandler.ERRORHandler;
import com.example.logger.LogHandler.INFOHandler;
import com.example.logger.LogHandler.LogHandler;
import com.example.logger.LogHandler.WARNHandler;
import com.example.logger.enums.LogLevel;
import com.example.logger.model.LogMessage;
import com.example.logger.strategy.LogCapturer.ConsoleCapturer;
import com.example.logger.strategy.LogCapturer.FileCapturer;

public class Logger {
    private static final Logger instance = new Logger();
    private Logger() {
        INFOHandler info = new INFOHandler();
        WARNHandler warn = new WARNHandler();
        ERRORHandler error = new ERRORHandler();

        info.setNextHandler(warn);
        warn.setNextHandler(error);

        info.subscribe(new ConsoleCapturer());

        warn.subscribe(new ConsoleCapturer());
        warn.subscribe(new FileCapturer());

        error.subscribe(new ConsoleCapturer());
        error.subscribe(new FileCapturer());

        this.logHandler = info;
    }   
    public static Logger getInstance()
    {
        return instance;
    }

    private final LogHandler logHandler;

    public void log(LogLevel logLevel,String message)
    {
        LogMessage logMessage = new LogMessage(logLevel, message);
        logHandler.handle(logMessage);
    }

    public void info(String message)
    {
        LogMessage logMessage = new LogMessage(LogLevel.INFO,message);
        logHandler.handle(logMessage);
    }
    public void warn(String message)
    {
        LogMessage logMessage = new LogMessage(LogLevel.WARN,message);
        logHandler.handle(logMessage);
    }
    public void error(String message)
    {
        LogMessage logMessage = new LogMessage(LogLevel.ERROR,message);
        logHandler.handle(logMessage);
    }
}
