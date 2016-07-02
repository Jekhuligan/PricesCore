package com.pa.pricescore.simple.impl;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Jek on 03.07.16.
 */
@Component
public class IDGen
{
    public UUID getId()
    {
        return UUID.randomUUID();
    }

}
