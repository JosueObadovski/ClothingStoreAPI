package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Produto;
import app.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    //Salva uma entidade Produto no banco de dados e retorna uma mensagem de sucesso.
    public String save(Produto produto) {
        this.produtoRepository.save(produto);
        return produto.getNome() + " salvo com sucesso";
    }
    
    //Atualiza uma entidade Produto existente, definindo seu ID e salvando, retornando uma mensagem de sucesso.
    public String update(long id, Produto produto) {
        produto.setId(id);
        this.produtoRepository.save(produto);
        return produto.getNome() + " atualizado com sucesso";
    }
    
    //Retorna uma lista de todas as entidades Produto do banco de dados.
    public List<Produto> listAll() {
        return this.produtoRepository.findAll();
    }
    
    //Encontra uma única entidade Produto pelo seu ID. Caso não encontrado, pode lançar uma NoSuchElementException.
    public Produto findById(long id) {
        return this.produtoRepository.findById(id).get();
    }
    
    //Exclui uma entidade Produto pelo seu ID.
    public String delete(long id) {
        this.produtoRepository.deleteById(id);
        return "Produto deletado com sucesso!";
    }
    
    //Encontra entidades Produto pelo seu nome.
    public List<Produto> findByNome(String nome) {
        return this.produtoRepository.findByNome(nome);
    }
    
    //Encontra entidades Produto com valor abaixo ou igual a um certo valor.
    public List<Produto> findByValorAbaixoIgual(double valor) {
        return this.produtoRepository.findByValorAbaixoIgual(valor);
    }
    
    //Busca produtos com valor acima de um determinado valor.
    public List<Produto> buscarProdutosComValorAcima(double valor) {
        return this.produtoRepository.buscarProdutosComValorAcima(valor);
    }

}

//Ass: Josué Antonio Gardasz Obadovski