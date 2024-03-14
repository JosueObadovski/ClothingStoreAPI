package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
	//Busca produtos pelo nome.
    public List<Produto> findByNome(String nome);
    
    //Busca produtos com valor abaixo ou igual ao valor especificado.
    @Query("SELECT p FROM Produto p WHERE p.valor <= :valor")
    public List<Produto> findByValorAbaixoIgual(double valor);
    
    //Busca produtos com valor acima do valor especificado.
    @Query("FROM Produto p WHERE p.valor > :valor")
    public List<Produto> buscarProdutosComValorAcima(double valor);
    
}

//Ass: Josué Antonio Gardasz Obadovski