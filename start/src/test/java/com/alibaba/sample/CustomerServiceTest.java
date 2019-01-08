package com.alibaba.sample;

import com.alibaba.cola.context.Context;
import com.alibaba.cola.dto.Response;
import com.alibaba.sample.api.CustomerServiceI;
import com.alibaba.sample.common.BizCode;
import com.alibaba.sample.common.exception.ErrorCode;
import com.alibaba.sample.context.DemoContent;
import com.alibaba.sample.dto.CustomerAddCmd;
import com.alibaba.sample.dto.clientobject.CustomerCO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This is for integration test.
 *
 * Created by fulan.zjf on 2017/11/29.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class CustomerServiceTest {

    @Autowired
    private CustomerServiceI customerService;

    private Context<DemoContent> context;

    @Before
    public void setUp() {
        context = new Context<>();
    }
    @Test
    public void testCustomerAddSuccess(){
        //1.prepare
        CustomerAddCmd customerAddCmd = new CustomerAddCmd();
        context.setBizCode(BizCode.BIZ_ONE);
        customerAddCmd.setContext(context);
        CustomerCO customerCO = new CustomerCO();
        customerCO.setCompanyName("NormalName");
        customerAddCmd.setCustomerCO(customerCO);

        //2.execute
        Response response = customerService.addCustomer(customerAddCmd);

        //3.assert
        Assert.assertTrue(response.isSuccess());
    }

    @Test
    public void testCustomerAddCompanyNameConflict(){
        //1.prepare
        CustomerAddCmd customerAddCmd = new CustomerAddCmd();
        context.setBizCode(BizCode.BIZ_ONE);
        customerAddCmd.setContext(context);
        CustomerCO customerCO = new CustomerCO();
        customerCO.setCompanyName("ConflictCompanyName");
        customerAddCmd.setCustomerCO(customerCO);

        //2.execute
        Response response = customerService.addCustomer(customerAddCmd);

        //3.assert
        Assert.assertEquals(ErrorCode.B_CUSTOMER_companyNameConflict.getErrCode(), response.getErrCode());

    }
}
