
package jkryonet01cl01;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class Jkryonet01cl01 {

    public static void main(String[] args) {

        try {
            Client client = new Client();
            client.addListener(new Listener() {

                @Override
                public void received(Connection connection, Object object) {
                    if (object instanceof SomeResponse) {
                        SomeResponse response = (SomeResponse) object;
                        System.out.println(response.text);
                    }
                }
            });
            
            Kryo kryo = client.getKryo();
            kryo.register(SomeRequest.class);
            kryo.register(SomeResponse.class);
            
            int tcpPort = 34500;
            
            client.start();
            client.connect(5000, "127.0.0.1", tcpPort);
            System.out.println("Client connected!");
            
            SomeRequest request = new SomeRequest();
            request.text = "Here is the request";
            client.sendTCP(request);
            
            try {
                Thread.sleep(2);
            } catch (Exception e) {}
            
        } catch (Exception ex) {
            System.err.println("Error!");
            System.err.println(ex.getMessage());
        }

    }
}
