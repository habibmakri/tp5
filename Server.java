package tp5rmi;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

import tp2tcp.users;

public class Server implements Impl5 {
	static ArrayList<products> stockage = new ArrayList<products>();
	
    public Server() {
		stockage.add(new products("lait",15));
		stockage.add(new products("pain",12));
		stockage.add(new products("pomme",18));
        


    }
    public static int state1 = -9;
    public static void main(String args[]) {

        try {
            Server obj = new Server();
            Impl5 stub2 = (Impl5) UnicastRemoteObject.exportObject(obj, 0);

           
            Registry registry = LocateRegistry.createRegistry(4542); 
            Naming.rebind("rmi://localhost:4542/Impl", stub2);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
    public String hello() throws RemoteException{
    	return "hello";
    }
		public ArrayList<products> Show_products() throws RemoteException {
			
			return stockage;			
		}
		public int modify_products(String r1, int r2) throws RemoteException, NotBoundException  {
			int index = -1;
			for( int i =0;i<stockage.size();i++) {
				if (stockage.get(i).name.equals(r1)) {
					index = i;
				}
			}
			
			System.out.println(index);
			stockage.get(index).quantity = r2;
			/*Registry registry = LocateRegistry.getRegistry(4542); // Change here
	        Impl2 stub3 = (Impl2) registry.lookup("Impl2");
			stub3.alerte();*/
			return 1;			
		}
			

		
}
