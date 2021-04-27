package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	private long id;		
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	private  String email;
	
	@NotBlank
	@CPF
	private  String cpf;
	
	@NotBlank
	private String dataDeNascimento;
	
	
	
	public Usuario(long id, String nome, String email, String cpf, String dataDeNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getDataDeNascimento() {
		return dataDeNascimento;
	}



	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}



	public String getEmail() {
		return email;
	}



	public String getCpf() {
		return cpf;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
