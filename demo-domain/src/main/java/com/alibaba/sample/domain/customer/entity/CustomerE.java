package com.alibaba.sample.domain.customer.entity;

import com.alibaba.cola.domain.Entity;
import com.alibaba.cola.domain.EntityObject;
import com.alibaba.cola.exception.BizException;
import com.alibaba.sample.common.exception.ErrorCode;
import com.alibaba.sample.common.util.DomainEventPublisher;
import com.alibaba.sample.domain.customer.repository.ContactRepository;
import com.alibaba.sample.domain.customer.repository.CustomerRepository;
import com.alibaba.sample.domain.customer.valueobject.CompanyType;
import com.alibaba.sample.domain.customer.valueobject.SourceType;
import com.alibaba.sample.dto.domainevent.CustomerCreatedEvent;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@Entity
public class CustomerE extends EntityObject {

    private String customerId;
    private String memberId;
    private String globalId;
    private ContactE contact;  // contact Person
    private List<ContactE> contactList;
    private long registeredCapital;
    private String companyName;
    private SourceType sourceType;
    private CompanyType companyType;

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DomainEventPublisher domainEventPublisher;

    public CustomerE() {
    }

    public boolean isBigCompany() {
        return registeredCapital > 10000000; //注册资金大于1000万的是大企业
    }

    public boolean isSME() {
        return registeredCapital > 10000 && registeredCapital < 1000000; //注册资金大于10万小于100万的为中小企业
    }

    public void addNewCustomer() {
        //check conflict
        checkConfilict();

        //Persist customer
        customerRepository.persist(this);

        //Send domain event
        domainEventPublisher.publish(new CustomerCreatedEvent());

    }

    public void checkConfilict(){
        //Per different biz, the check policy could be different, if so, use ExtensionPoint
        if("ConflictCompanyName".equals(this.companyName)){
            throw new BizException(ErrorCode.B_CUSTOMER_companyNameConflict, this.companyName+" has already existed, you can not add it");
        }

    }
}
