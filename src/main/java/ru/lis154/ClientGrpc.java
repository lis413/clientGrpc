package ru.lis154;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientGrpc {

    public static void main(String[] args) {
        // передаем и принимаем данные с сервера
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext().build();

        // оздаем объект для вызова удаленных запросов и процедур - stub
        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest.newBuilder().setName("Ilya").build();

        // передаекм stub нащ запрос
        GreetingServiceOuterClass.HelloResponse response =  stub.greeting(request);

        System.out.println(response);

        channel.shutdownNow();




    }
}
