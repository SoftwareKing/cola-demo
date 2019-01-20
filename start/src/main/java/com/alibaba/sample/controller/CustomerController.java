package com.alibaba.sample.controller;

import com.alibaba.cola.command.CommandBusI;
import com.alibaba.cola.context.Context;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.fastjson.JSON;
import com.alibaba.sample.common.BizCode;
import com.alibaba.sample.context.DemoContent;
import com.alibaba.sample.dto.CustomerAddCmd;
import com.alibaba.sample.dto.CustomerFindByCriteriaQry;
import com.alibaba.sample.dto.clientobject.CustomerCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class CustomerController {

    @Autowired
    private CommandBusI commandBus;

    @PostMapping("/add")
    public Response addCustomer(@RequestBody  CustomerAddCmd customerAddCmd) {
        return (Response)commandBus.send(customerAddCmd);
    }

    @GetMapping("/list")
    public MultiResponse<CustomerCO> findByCriteria(CustomerFindByCriteriaQry CustomerFindByCriteriaQry) {
        return (MultiResponse<CustomerCO>)commandBus.send(CustomerFindByCriteriaQry);
    }

}
