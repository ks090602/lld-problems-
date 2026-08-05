package com.example.logger.LogHandler;

import com.example.logger.enums.LogLevel;

public class WARNHandler extends LogHandler{

    @Override
    public boolean canHandle(LogLevel level)
    {
        if(level==LogLevel.WARN) return true;
        return false;
    }
}
