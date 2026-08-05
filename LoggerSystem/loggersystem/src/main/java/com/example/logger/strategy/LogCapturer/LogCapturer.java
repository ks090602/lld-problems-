package com.example.logger.strategy.LogCapturer;

import com.example.logger.model.LogMessage;

public interface LogCapturer {
   void capture(LogMessage logMessage); 
}
