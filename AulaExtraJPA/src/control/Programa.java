package control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		// Instanciando objetos
	 
		Pessoa p1 = new Pessoa (null, "Carlos Silva", "carlossilva@gmail.com");
		Pessoa p2 = new Pessoa (null, "Lucas Martins", "lucasmatins@gmail.com");
		Pessoa p3 = new Pessoa (null, "Pedro Paulo", "pedropaulo@gmail.com");	 	
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Salvando objetos no banco 
	  
	 	em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		/* remoção do objeto no banco
		em.remove(p2); */
		em.getTransaction().commit();
		
		// busca no banco
		
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		
		//fechando conexão com o banco
		
		em.close();
		emf.close();
		
	}

}
