package pl.edu.agh.kis.pz1;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ServerApplication {

    public static void main(String[] args) throws IOException
    {
        Server server = new Server();
        server.start();

    }
}