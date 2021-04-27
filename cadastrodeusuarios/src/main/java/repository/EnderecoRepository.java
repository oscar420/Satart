package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
