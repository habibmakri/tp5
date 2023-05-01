package tp5rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Impl2 extends Remote {
	public int alerte()throws RemoteException;
   
}
