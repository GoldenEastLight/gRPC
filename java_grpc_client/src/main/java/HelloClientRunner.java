import java.time.Clock;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloClientRunner {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 36200)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setName("KimDongBeen")
                .setAlias("GoldenEastLight")
                .build());

        System.out.println("\n----------------------------------");
        System.out.print(helloResponse);
        System.out.println("----------------------------------\n");

        channel.shutdown();
    }
}
