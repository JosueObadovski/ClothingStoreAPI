package app.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Cliente;
import app.entity.Funcionario;
import app.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    
	//Busca vendas associadas a um cliente específico.
    public List<Venda> findByCliente(Cliente cliente);
    
    //Busca vendas realizadas por um funcionário específico.
    public List<Venda> findByFuncionario(Funcionario funcionario);
    
    //Busca vendas onde o valor total é maior que o valor especificado.
    @Query("FROM Venda v WHERE v.valorTotal > :valorTotal")
    public List<Venda> buscarVendasComValorAcima(double valor);
}

//Ass: Josué Antonio Gardasz Obadovski