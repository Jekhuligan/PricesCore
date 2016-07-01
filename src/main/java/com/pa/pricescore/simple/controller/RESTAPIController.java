package com.pa.pricescore.simple.controller;

import com.pa.pricescore.simple.api.MessageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.math.BigDecimal;

/**
 * Created by Jek on 24.06.16.
 */
@RestController
public class RESTAPIController
{
    @RequestMapping(value = "/input", method = RequestMethod.POST)
    public String inputPrice(@RequestBody(required = true) MessageRequest request)
    {

        return request.getUserId().toString() + request.getShop() + request.getItem()+ request.getPrice().toString();
    }

}
