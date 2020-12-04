package br.furb.JPATutorial.modelo;

import javax.persistence.*;

@Entity
@Table(name = "Materias")
public class Materias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMateria")
	private Integer id;
	
	@Column(name = "nomeMateria")
	private String nome;
	
	@Column(name = "duracaoMateria")
	private String duracao;
	
	@Column(name = "professorMateria")
	private String professor;
	
	public Materias() {}
	
	public Materias(String nome) {
		setNome(nome);
	}

	public Materias(String nome,String duracao,String professor) {
		setNome(nome);
		setDuracao(duracao);
		setProfessor(professor);
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String prefessor) {
		this.professor = prefessor;
	}
	
	public String toString() {
		return "Id - "+id+"\nMateria - "+nome;
	}

}