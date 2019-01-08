package com.alibaba.sample.event.handler;

import com.alibaba.cola.event.EventHandler;
import com.alibaba.cola.event.EventHandlerI;
import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import com.alibaba.sample.dto.domainevent.CustomerCreatedEvent;

/**
 * 同步搜索器的handler
 *
 * @author frankzhang
 * @date 2017/11/30
 */
@EventHandler
public class CustomerCreatedSyncSearchHandler implements EventHandlerI<CustomerCreatedEvent> {

    private Logger logger = LoggerFactory.getLogger(CustomerCreatedSyncSearchHandler.class);

    @Override
    public void execute(CustomerCreatedEvent event) {
        logger.debug("Sync new customer to Search");
    }
}
