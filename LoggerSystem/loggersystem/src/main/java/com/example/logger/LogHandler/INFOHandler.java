package com.example.logger.LogHandler;

import com.example.logger.enums.LogLevel;

public class INFOHandler extends LogHandler{

    @Override
    public boolean canHandle(LogLevel level)
    {
        if(level==LogLevel.INFO) return true;
        return false;
    }
}
