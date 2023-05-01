package tp5rmi;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;


import tp4rmi.Impl;

public class Client {
    public static int[][] r1 ;

    private Client() {}

    public static void main(String[] args) {

        try {
        	// Getting the registry
            Registry registry = LocateRegistry.getRegistry(4542); // Change here
    		Scanner scan = new Scanner(System.in);

            // Looking up the registry for the remote object
            Impl5 stub2 = (Impl5) registry.lookup("Impl");
            
            ArrayList<products> stockage = stub2.Show_products();
        	for (int i=0;i<stockage.size();i++) {
				System.out.println("produit n°"+i+" est "+stockage.get(i).name+" disponible avec une quantité de: "+stockage.get(i).quantity);
				
			}
				
        	System.out.println("pour modifier appuyer sur 1 pour quitter appuyer sur 2:");
        	int r = scan.nextInt();
        	if (r == 1) {
        		System.out.println("taper le produit pour modifier son quantité:");
    			String r1 = scan.next();
    			System.out.println("taper la nouvelle quantité:");
    			int r2 = scan.nextInt();
        		stub2.modify_products(r1,r2);
        		System.out.println("la nouvelle liste apres  modification");
        		 stockage = stub2.Show_products();
            	for (int i=0;i<stockage.size();i++) {
    				System.out.println("produit n°"+i+" est "+stockage.get(i).name+" disponible avec une quantité de: "+stockage.get(i).quantity);
    				
    			}
        	}else {
        		System.out.println("vous choissisez de quitter");
        	}
        	
        	
        	
        	
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
    public int alerte() throws RemoteException {
    	System.out.println("laliste a était modifier");
    	return 1;
    }
}
