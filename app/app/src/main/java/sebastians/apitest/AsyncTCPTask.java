package sebastians.apitest;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import sebastians.apitest.transfer.Transfer;

class AsyncTCPTask extends AsyncTask {


    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            TTransport transport;

            transport = new TSocket("192.168.178.60", 9090);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            Transfer.Client client = new Transfer.Client(protocol);

            int product = client.number(3);
            Log.i("FromServer", "" + client.number(3));

            transport.close();
        } catch (Exception x) {
            x.printStackTrace();
        }
        return null;
    }
}
