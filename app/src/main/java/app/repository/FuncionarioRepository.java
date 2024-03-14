package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	//Busca funcionários pelo nome.
	public List<Funcionario> findByNome (String nome);
	
	//Busca funcionários pela idade.
	public List<Funcionario> findByIdade (int idade);
	
	//Busca funcionários onde o número da matrícula é maior que o valor especificado. 
	@Query("FROM Funcionario f WHERE f.matricula > :matricula")
	public List<Funcionario> findByMatriculaNumeroAcima(String matricula);
}

//Ass: Josué Antonio Gardasz Obadovski