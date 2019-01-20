package com.alibaba.sample;

import com.alibaba.cola.context.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.sample.common.BizCode;
import com.alibaba.sample.context.DemoContent;
import com.alibaba.sample.dto.CustomerAddCmd;
import com.alibaba.sample.dto.clientobject.CustomerCO;

public class CustomerTest {

    public static void main(String[] args) {
        CustomerAddCmd customerAddCmd = new CustomerAddCmd();
        Context<DemoContent> context=new Context<DemoContent>();
        context.setBizCode(BizCode.BIZ_ONE);
        customerAddCmd.setContext(context);
        CustomerCO customerCO = new CustomerCO();
        customerCO.setCompanyName("NormalName");
        customerAddCmd.setCustomerCO(customerCO);
        System.out.println(JSON.toJSONString(customerAddCmd));
    }
}
