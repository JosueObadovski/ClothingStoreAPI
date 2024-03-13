package app.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Cliente;
import app.entity.Funcionario;
import app.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    
	
    public List<Venda> findByCliente(Cliente cliente);
    
    public List<Venda> findByFuncionario(Funcionario funcionario);
    
    @Query("FROM Venda v WHERE v.valorTotal > :valorTotal")
    public List<Venda> buscarVendasComValorAcima(double valor);
}
