package br.furb.JPATutorial.controle;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.furb.JPATutorial.modelo.Individuo;
import br.furb.JPATutorial.modelo.Materias;

public class MateriasControle implements DAO<Materias> {

	private EntityManager entityManager;

	public MateriasControle() {
		entityManager = ConexaoDB.getInstance();
	}

	@Override
	public Materias buscar(int idMateria) {

		return entityManager.find(Materias.class, idMateria);
	}

	@Override
	public void inserir(Materias materia) {
		entityManager.getTransaction().begin();
		entityManager.persist(materia);
		entityManager.getTransaction().commit();
	}

	@Override
	public void alterar(Materias materiaAntiga, Materias materiaNova) throws Exception {
		materiaAntiga = achar(materiaAntiga);
		materiaAntiga.setNome(materiaNova.getNome());
		materiaAntiga.setDuracao(materiaNova.getDuracao());
		materiaAntiga.setProfessor(materiaNova.getProfessor());
		entityManager.getTransaction().begin();
		entityManager.merge(materiaAntiga);
		entityManager.getTransaction().commit();
	}

	@Override
	public void excluir(Materias Materia) throws Exception {
		entityManager.getTransaction().begin();
		Materia = achar(Materia);
		entityManager.remove(Materia);
		entityManager.getTransaction().commit();
	}

	@Override
	public Materias achar(Materias Materia) throws Exception {
		try {
			Query q = entityManager
					.createNativeQuery("SELECT idMateria FROM cadastrocliente.materias WHERE nomeMateria = '"
							+ Materia.getNome()+"' and duracaoMateria = '"+Materia.getDuracao()+"'"
							+ " and professorMateria = '"+Materia.getProfessor()+"'");
			List l = q.getResultList();
			int id = (int) l.get(0);
			return entityManager.find(Materias.class, id);
		} catch (Exception e) {
			throw new Exception("Materia nao foi encontrada \nErro: " + e.getMessage());
		}
	}
}
