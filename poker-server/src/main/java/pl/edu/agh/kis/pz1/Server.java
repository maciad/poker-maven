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

public class Server
{

    private ServerSocketChannel ssc;
    private Selector selector;

    public void start() throws IOException
    {
        selector = Selector.open();

        ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(6677));
        ssc.configureBlocking(false);

        ssc.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Serwer uruchomiony");
        System.out.println("Oczekiwanie na połączenie...");

        while (ssc.isOpen())
        {
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();

            for (Iterator<SelectionKey> it = keys.iterator(); it.hasNext(); )
            {
                SelectionKey key = it.next();
                it.remove();


                    if (key.isAcceptable() && key.isValid())
                    {
                        handleaccept();
                    }
                    else if (key.isReadable() && key.isValid())
                    {
                        handleread(key);
                    }
                    else if (key.isWritable() && key.isValid()) {
                        handlewrite(key, "asdfghjkl");
                        //broadcast("do wszystkich");
                    }
            }
        }
    }

    private void handleaccept() throws IOException
    {
        SocketChannel sc = ssc.accept();

        if(sc != null)
        {
            sc.configureBlocking(false);
            sc.register(selector, SelectionKey.OP_READ);
            System.out.println("Połączenie zaakceptowane" + sc);
        }
    }

    private void handleread(SelectionKey key) throws IOException
    {
        ByteBuffer buffer;
        SocketChannel sc = (SocketChannel) key.channel();
        buffer = ByteBuffer.allocate(128);
        sc.read(buffer);

        String result = new String(buffer.array()).trim();
        System.out.println("Odebrano: " + result);
        if(result.equals("exit"))
        {
            sc.close();
            System.out.println("Połączenie zamknięte");
        }
        else if (result.equals("bro"))
        {
            broadcast("czy dziala?");
        }
        else
        {
            key.interestOps(SelectionKey.OP_WRITE);
        }
    }

    private void handlewrite(SelectionKey key, String message) throws IOException
    {
        SocketChannel sc = (SocketChannel) key.channel();

            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            sc.write(buffer);
            key.interestOps(SelectionKey.OP_READ);
    }

    private void broadcast(String message) throws IOException
    {
        for (SelectionKey key : selector.keys())
        {
            if (key.isValid()  && key.channel() instanceof SocketChannel)
            {
                key.interestOps(SelectionKey.OP_WRITE);
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                sc.write(buffer);
                key.interestOps(SelectionKey.OP_READ);
            }
        }
    }
}