package OrangeTalent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import OrangeTalent.entity.Usuario;
import OrangeTalent.entity.UsuarioEnderecos;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByCpfOrEmail(String cpf, String email);
	
	@Query(value = "SELECT U.EMAIL, D.BAIRRO, D.CEP, D.COMPLEMENTO, D.ESTADO, D.LOGRADOURO, D.NUMERO FROM USUARIO U LEFT JOIN ENDERECO D ON U.CPF=D.CPF WHERE U.EMAIL = :email OR U.CPF = :cpf", nativeQuery = true)
	List<UsuarioEnderecos> obterEnderecos(String email, String cpf);

}
