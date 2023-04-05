package pl.edu.agh.kis.pz1;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Objects;
import java.util.Scanner;

public class ClientApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
    Client c = new Client();
    c.start();

    while(c.client.isConnected())
    {
        Scanner scanner = new Scanner(System.in);
        String messageToSend = scanner.nextLine();
        if (messageToSend.isBlank()) {
            continue;
        }
        c.sendMessage(messageToSend);
        if (Objects.equals(messageToSend, "exit"))
        {
            c.stop();
            break;
        }
        c.receiveMessage();
    }
    }

    }
