package com.archer.test;

import com.archer.rpc.api.ByeService;
import com.archer.rpc.api.HelloObject;
import com.archer.rpc.api.HelloService;
import com.archer.rpc.serializer.CommonSerializer;
import com.archer.rpc.transport.RpcClientProxy;
import com.archer.rpc.transport.socket.client.SocketClient;

/**
 * 测试用消费者（客户端）
 *
 *
 */
public class SocketTestClient {

    public static void main(String[] args) {
        SocketClient client = new SocketClient(CommonSerializer.KRYO_SERIALIZER);
        RpcClientProxy proxy = new RpcClientProxy(client);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.sayhello(object);
        System.out.println(res);
        ByeService byeService = proxy.getProxy(ByeService.class);
        System.out.println(byeService.sayBye("Netty"));
    }

}
