import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class HelloServerRunner {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(36200)
                .addService(new HelloServiceImpl()).build();

        System.out.println("Listening port 36200...");

        server.start();
        server.awaitTermination();
    }
}
