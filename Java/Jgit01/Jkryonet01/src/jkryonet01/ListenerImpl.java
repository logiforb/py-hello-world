
package jkryonet01;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

class ListenerImpl extends Listener {

    @Override
    public void received(Connection connection, Object object) {
//        super.received(cnctn, o); //To change body of generated methods, choose Tools | Templates.
        if (object instanceof SomeRequest) {
            SomeRequest request = (SomeRequest) object;
            System.out.println(request.text);

            SomeResponse response = new SomeResponse();
            response.text = "Thanks";
            connection.sendTCP(response);
        }
    }

}
