package OrangeTalent.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@IdClass(CadastroId.class)
public class Usuario {
	
	@Id
	@NotBlank
	@Email
	private  String email;		
	
	@Id
	@NotBlank
	@CPF
	private  String cpf;
	
	@NotBlank
	private String nome;
	
	
	
	
	@NotBlank
	private String dataDeNascimento;
	
	
	
	public Usuario() {
		super();
		
	}



	public Usuario(String nome, String dataDeNascimento) {
		super();
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
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
