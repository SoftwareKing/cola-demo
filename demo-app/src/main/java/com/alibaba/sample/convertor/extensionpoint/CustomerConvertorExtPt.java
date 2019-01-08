package com.alibaba.sample.convertor.extensionpoint;

import com.alibaba.cola.context.Context;
import com.alibaba.cola.convertor.ConvertorI;
import com.alibaba.cola.extension.ExtensionPointI;
import com.alibaba.sample.dto.clientobject.CustomerCO;
import com.alibaba.sample.domain.customer.entity.CustomerE;

/**
 * CustomerConvertorExtPt
 *
 * @author Frank Zhang
 * @date 2018-01-07 2:37 AM
 */
public interface CustomerConvertorExtPt extends ConvertorI, ExtensionPointI {

    public CustomerE clientToEntity(CustomerCO customerCO, Context context);
}
