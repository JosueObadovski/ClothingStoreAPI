package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	//Busca clientes pelo nome.
	public List<Cliente> findByNome(String nome);
	
	//Busca clientes pela idade.
	public List<Cliente> findByIdade(int idade);
	
	//Busca clientes por CPF, onde o CPF é maior que o valor fornecido. 
	@Query("FROM Cliente c WHERE c.cpf > :cpf")
	public List<Cliente> findByCpf(String cpf);
}

//Ass: Josué Antonio Gardasz Obadovski