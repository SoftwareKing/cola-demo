package com.alibaba.sample.command.query;

import com.alibaba.sample.convertor.CustomerConvertor;
import com.alibaba.sample.tunnel.database.dataobject.CustomerDO;
import com.alibaba.sample.tunnel.database.CustomerDBTunnel;
import com.alibaba.sample.dto.CustomerFindByCriteriaQry;
import com.alibaba.sample.dto.clientobject.CustomerCO;
import com.alibaba.cola.command.Command;
import com.alibaba.cola.command.QueryExecutorI;
import com.alibaba.cola.dto.MultiResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Command
public class CustomerFindByCriteriaQueryExe implements QueryExecutorI<MultiResponse<CustomerCO>, CustomerFindByCriteriaQry> {

    @Autowired
    private CustomerDBTunnel customerDBTunnel;

    @Autowired
    private CustomerConvertor customerConvertor;

    @Override
    public MultiResponse<CustomerCO> execute(CustomerFindByCriteriaQry cmd) {
        CustomerDO customerDO = customerDBTunnel.get("123");
        List<CustomerCO> customerCos = new ArrayList<>();
        customerCos.add(customerConvertor.dataToClient(customerDO));
        return MultiResponse.of(customerCos, customerCos.size());
    }
}
