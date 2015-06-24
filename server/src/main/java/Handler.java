/**
 * Created by sebastian on 22/06/15.
 */
import org.apache.thrift.TException;
import transfer.Transfer;

public class Handler implements Transfer.Iface {


        @Override
        public int number(int n1) throws TException {
            System.out.println("Received " + n1);
            return n1 +1;
        }

}
