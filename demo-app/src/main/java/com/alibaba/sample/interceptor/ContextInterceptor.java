package com.alibaba.sample.interceptor;

import com.alibaba.cola.command.CommandInterceptorI;
import com.alibaba.cola.command.PreInterceptor;
import com.alibaba.cola.context.Context;
import com.alibaba.cola.dto.Command;
import com.alibaba.sample.common.BizCode;
import com.alibaba.sample.context.DemoContent;

@PreInterceptor
public class ContextInterceptor implements CommandInterceptorI{

    @Override
    public void preIntercept(Command command) {
        Context<DemoContent> context = new Context();
        DemoContent content = new DemoContent();
        content.setUserId("testUserId");
        context.setContent(content);

        if(command.getContext() != null){
            context.setBizCode(command.getContext().getBizCode());
        }
        context.setBizCode(BizCode.BIZ_ONE);
        command.setContext(context);

    }

}
