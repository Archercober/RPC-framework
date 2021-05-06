package com.archer.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.archer.rpc.annotation.Service;
import com.archer.rpc.api.HelloObject;
import com.archer.rpc.api.HelloService;


@Service
public class HelloServiceImpl implements HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);



    @Override
    public String sayhello(HelloObject object) {
        logger.info("接收到消息：{}", object.getMessage());
        return "这是Impl1方法";

    }
}
