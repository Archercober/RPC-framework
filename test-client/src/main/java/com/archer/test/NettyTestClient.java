package com.archer.test;

import com.archer.rpc.api.ByeService;
import com.archer.rpc.api.HelloObject;
import com.archer.rpc.api.HelloService;
import com.archer.rpc.serializer.CommonSerializer;
import com.archer.rpc.transport.RpcClient;
import com.archer.rpc.transport.RpcClientProxy;
import com.archer.rpc.transport.netty.client.NettyClient;

/**
 * 测试用Netty消费者
 *
 *
 */
public class NettyTestClient {

    public static void main(String[] args) {
        RpcClient client = new NettyClient(CommonSerializer.PROTOBUF_SERIALIZER);
        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.sayhello(object);
        System.out.println(res);
        ByeService byeService = rpcClientProxy.getProxy(ByeService.class);
        System.out.println(byeService.sayBye("Netty"));
    }

}
