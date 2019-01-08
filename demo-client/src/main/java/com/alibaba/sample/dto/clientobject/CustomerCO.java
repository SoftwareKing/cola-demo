package com.alibaba.sample.dto.clientobject;

import com.alibaba.cola.dto.ClientObject;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CustomerCO extends ClientObject {
    private String customerId;
    private String memberId;
    private String customerName;
    private String customerType;
    @NotEmpty
    private String companyName;
    @NotEmpty
    private String source;



}
