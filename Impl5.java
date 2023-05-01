package tp5rmi;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Impl5 extends Remote {
	public ArrayList<products> Show_products()throws RemoteException;
	public int modify_products(String r1, int r2) throws RemoteException, NotBoundException;
   
}
