package tp5rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Impl extends Remote {
	public int Show_products()throws RemoteException;
	public String hello() throws RemoteException;
   
}
