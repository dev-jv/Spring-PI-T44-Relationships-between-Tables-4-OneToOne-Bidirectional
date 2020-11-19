package connectionhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCliente {
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Client.class)
									.addAnnotatedClass(DetailsClient.class)
									.buildSessionFactory();
		
		// create session
		Session mySession = myFactory.openSession();
		
		try {
			
			// start a transaction
			mySession.beginTransaction();
			
			// create a DetailsClient object
			DetailsClient detClients = mySession.get(DetailsClient.class, 5);
			
			System.out.println(" <> ---- Show Details Client");
			
			System.out.println(detClients); // Show Details P
			
			
			System.out.println(" <> ---- Show Client");
			
			System.out.println(detClients.getClient()); // Show Client P <- Details P
			
			// commit transaction
			mySession.getTransaction().commit();
			
			mySession.close();
			
		} finally {
			
			myFactory.close();
			
		}
		
	}
}



/*

	El objetivo es obtener en consola datos de un Cliente a partir de los Detalles del Cliente.
	Datos de una tabla solicitándola a otra! :)

*/