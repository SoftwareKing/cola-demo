package com.alibaba.sample.convertor.extension;

import com.alibaba.cola.context.Context;
import com.alibaba.cola.extension.Extension;
import com.alibaba.sample.common.BizCode;
import com.alibaba.sample.convertor.CustomerConvertor;
import com.alibaba.sample.convertor.extensionpoint.CustomerConvertorExtPt;
import com.alibaba.sample.domain.customer.entity.CustomerE;
import com.alibaba.sample.domain.customer.valueobject.SourceType;
import com.alibaba.sample.dto.clientobject.CustomerCO;
import org.springframework.beans.factory.annotation.Autowired;

@Extension(bizCode = BizCode.BIZ_ONE)
public class CustomerBizOneConvertorExt implements CustomerConvertorExtPt{

    @Autowired
    private CustomerConvertor customerConvertor;

    @Override
    public CustomerE clientToEntity(CustomerCO customerCO, Context context) {
        CustomerE customerE = customerConvertor.clientToEntity(customerCO, context);
        customerE.setSourceType(SourceType.BIZ_ONE);
        return customerE;
    }
}