package com.alibaba.sample.domain.customer.repository;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.sample.tunnel.database.dataobject.CustomerDO;
import com.alibaba.sample.tunnel.database.CustomerDBTunnel;
import com.alibaba.sample.domain.customer.convertor.CustomerDomainConvertor;
import com.alibaba.sample.domain.customer.entity.CustomerE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.alibaba.cola.repository.RepositoryI;

@Repository
public class CustomerRepository implements RepositoryI{

    @Autowired
    private CustomerDBTunnel customerDBTunnel;

    @Autowired
    private CustomerDomainConvertor customerDomainConvertor;

    public void persist(CustomerE customer) {
        customerDBTunnel.create(customerDomainConvertor.entityToData(customer));
    }

}
