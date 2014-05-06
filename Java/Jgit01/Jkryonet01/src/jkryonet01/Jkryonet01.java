
package jkryonet01;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;
import java.io.IOException;

public class Jkryonet01 {

    public static void main(String[] args) {

        try {
            Server server = new Server();
            server.addListener(new ListenerImpl());
            
            Kryo kryo = server.getKryo();
            kryo.register(SomeRequest.class);
            kryo.register(SomeResponse.class);
            
            int tcpPort = 34500;
            server.bind(tcpPort);
            server.start();
            System.out.println("Server started on: " + tcpPort);
            
        } catch (IOException ex) {
            System.err.println("Error!");
            System.err.println(ex.getMessage());
        }
    }

}
