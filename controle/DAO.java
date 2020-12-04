package br.furb.JPATutorial.controle;

public interface DAO<T> {

	T buscar(int codigo);

	void inserir(T objeto) throws Exception;

	void alterar(T objAntigo, T objNovo) throws Exception;

	void excluir(T obj) throws Exception;
	
	T achar(T obj) throws Exception;
	
}
