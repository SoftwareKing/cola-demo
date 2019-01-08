package com.alibaba.sample.dto;

import com.alibaba.sample.dto.clientobject.CustomerCO;
import com.alibaba.cola.dto.Command;
import lombok.Data;

@Data
public class CustomerAddCmd extends Command{

    private CustomerCO customerCO;
    
}
