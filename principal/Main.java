package br.furb.JPATutorial.principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.furb.JPATutorial.controle.IndividuoControle;
import br.furb.JPATutorial.controle.MateriasControle;
import br.furb.JPATutorial.modelo.Individuo;
import br.furb.JPATutorial.modelo.Materias;

public class Main {

	public static void main(String[] args) throws Exception {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Clientes-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		
		IndividuoControle c = new IndividuoControle();
		c.logar("gmail@gmail", "321");
//		System.out.println(c.exibir());
//		c.excluir(6);
		Individuo inserido = new Individuo("Ana", "32323232", "truco@email", "senha", "aluno");
		Individuo inserido2 = new Individuo("Joao", "23232323", "oie@oie", "talvez", "aluno");
		c.alterar(inserido, inserido2);
//		c.inserir(inserido);

		
//		MateriasControle mc = new MateriasControle();
//		Materias m = new Materias("Matematica","180","Matheus");
//		Materias n = new Materias("Ingles","260","Pedrinho");
//		Materias p = new Materias("Portugues","892","Maria");
//		
//		mc.inserir(p);
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
