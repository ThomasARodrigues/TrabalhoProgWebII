package br.furb.JPATutorial.modelo;

import javax.persistence.*;

@Entity
@Table(name = "Individuo")
public class Individuo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idIndividuo")
	private Integer id;
	
	@Column(name = "nomeIndividuo")
	private String nome;
	
	@Column(name = "cpfIndividuo")
	private String cpf;
	
	@Column(name = "emailIndividuo")
	private String email;
	
	@Column(name = "senhaIndividuo")
	private String senha;
	
	@Column(name = "tipoIndividuo")
	private String tipo;
	
	public Individuo() {}
	
	public Individuo(String nome) {
		setNome(nome);
	}

	public Individuo(String nome,String cpf,String email,String senha,String tipo) {
		setNome(nome);
		setCpf(cpf);
		setEmail(email);
		setSenha(senha);
		setTipo(tipo);
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return "Id - "+id+"\nNome - "+nome+"\nCpf - "+cpf+"\nEmail - "+email+"\nSenha - "+senha+"\nTipo - "+tipo;
	}

}
