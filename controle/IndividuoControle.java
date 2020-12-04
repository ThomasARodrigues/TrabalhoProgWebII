package br.furb.JPATutorial.controle;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.furb.JPATutorial.modelo.Individuo;

public class IndividuoControle implements DAO<Individuo> {
	boolean logado = false;
	Individuo IndividuoLogado;

	private EntityManager entityManager;

	public IndividuoControle() {
		entityManager = ConexaoDB.getInstance();
	}

	@Override
	public Individuo buscar(int codigo) {
		return entityManager.find(Individuo.class, codigo);
	}

	@Override
	public void inserir(Individuo ind) throws Exception {
		if (logado) {
			if (IndividuoLogado.getTipo().equals("adm")) {
				entityManager.getTransaction().begin();
				entityManager.persist(ind);
				entityManager.getTransaction().commit();
			} else {
				throw new Exception("Voce nao tem permissao para isto");
			}
		} else {
			throw new Exception("Usuario nao esta logado");
		}
	}

	@Override
	public void alterar(Individuo indAntigo, Individuo indNovo) throws Exception {
		if (logado) {
			if (IndividuoLogado.getTipo().equals("adm")) {
				indAntigo = achar(indAntigo);
				indAntigo.setNome(indNovo.getNome());
				indAntigo.setCpf(indNovo.getCpf());
				indAntigo.setEmail(indNovo.getEmail());
				indAntigo.setSenha(indNovo.getSenha());
				indAntigo.setTipo(indNovo.getTipo());
				entityManager.getTransaction().begin();
				entityManager.merge(indAntigo);
				entityManager.getTransaction().commit();
			} else {
				throw new Exception("Voce nao tem permissao para isto");
			}
		} else {
			throw new Exception("Usuario nao esta logado");
		}
	}

	@Override
	public void excluir(Individuo Individuo) throws Exception {
		entityManager.getTransaction().begin();
		Individuo = achar(Individuo);
		entityManager.remove(Individuo);
		entityManager.getTransaction().commit();

	}
	
	@Override
	public Individuo achar(Individuo Individuo) throws Exception {
		try {
			Query q = entityManager
					.createNativeQuery("SELECT idIndividuo FROM cadastrocliente.individuo WHERE nomeIndividuo = '"
							+ Individuo.getNome()+"' and cpfIndividuo = '"+Individuo.getCpf()+"' and emailIndividuo = '"
							+ Individuo.getEmail() + "' and senhaIndividuo = '" + Individuo.getSenha() + "' and tipoIndividuo = '"
							+ Individuo.getTipo()+"'");
			List l = q.getResultList();
			int id = (int) l.get(0);
			return entityManager.find(Individuo.class, id);
		} catch (Exception e) {
			throw new Exception("Individuo nao foi encontrado \nErro: "+e.getMessage());
		}
	}

	public void logar(String email, String senha) throws Exception {

		try {
			Query q = entityManager
					.createNativeQuery("SELECT idIndividuo FROM cadastrocliente.individuo WHERE emailIndividuo = '"
							+ email + "' and senhaIndividuo = '" + senha + "'");
			List l = q.getResultList();
			int id = (int) l.get(0);
			IndividuoLogado = entityManager.find(Individuo.class, id);
			logado = true;
		} catch (Exception e) {
			throw new Exception("Dados digitados podem estar errados \nErro: "+e.getMessage());
		}

	}

	public String exibir() {
		return IndividuoLogado.toString();
	}

}
