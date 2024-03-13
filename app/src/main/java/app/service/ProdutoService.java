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

    public String save(Produto produto) {
        this.produtoRepository.save(produto);
        return produto.getNome() + " salvo com sucesso";
    }

    public String update(long id, Produto produto) {
        produto.setId(id);
        this.produtoRepository.save(produto);
        return produto.getNome() + " atualizado com sucesso";
    }

    public List<Produto> listAll() {
        return this.produtoRepository.findAll();
    }

    public Produto findById(long id) {
        return this.produtoRepository.findById(id).get();
    }

    public String delete(long id) {
        this.produtoRepository.deleteById(id);
        return "Produto deletado com sucesso!";
    }
}
