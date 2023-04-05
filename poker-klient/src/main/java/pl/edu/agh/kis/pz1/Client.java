package pl.edu.agh.kis.pz1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class Client
{
    public SocketChannel client;

    public void start() throws IOException
    {
        try
        {
            InetSocketAddress serverAddr = new InetSocketAddress(6677);
            client = SocketChannel.open(serverAddr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Połączono z serwerem: " + client.getRemoteAddress());
    }

    public void stop() throws IOException
    {
        client.close();
    }

    public void sendMessage(String message) throws IOException {
        String response = null;
        byte[] messageBytes = new String(message).getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(messageBytes);
        try
        {
            client.write(buffer);
            buffer.clear();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void receiveMessage() throws IOException
    {
        ByteBuffer buffer = ByteBuffer.allocate(128);
        client.read(buffer);
        String response = new String(buffer.array()).trim();
        System.out.println("Otrzymano: " + response);
    }
}
