package com.example.logger.strategy.LogFormatter;

import com.example.logger.model.LogMessage;

public interface LogFormatter {
    String format(LogMessage logMessage);    
}
