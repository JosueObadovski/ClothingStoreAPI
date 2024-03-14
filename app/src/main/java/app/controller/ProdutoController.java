package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Produto;
import app.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    
    //Método POST
    //URL: http://localhost:8080/api/produto/save
    //Método para salvar um novo produto
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Produto produto) {
        try {
            String mensagem = produtoService.save(produto);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao salvar o produto: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método PUT
    //URL: http://localhost:8080/api/produto/update/{id}
    //Método para atualizar um produto existente pelo id
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody Produto produto) {
        try {
            String mensagem = produtoService.update(id, produto);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar o produto: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Método GET
    //URL: http://localhost:8080/api/produto/listAll
    //Método para listar todos os produtos
    @GetMapping("/listAll")
    public ResponseEntity<List<Produto>> listAll() {
        try {
            List<Produto> produtos = produtoService.listAll();
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método GET
    //URL: http://localhost:8080/api/produto/findById/{id}
    //Método para encontrar um produto por id
    @GetMapping("/findById/{id}")
    public ResponseEntity<Produto> findById(@PathVariable long id) {
        try {
            Produto produto = produtoService.findById(id);
            return produto != null ? new ResponseEntity<>(produto, HttpStatus.OK) 
                                   : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método DELETE
    //URL: http://localhost:8080/api/produto/delete/{id}
    //Método para excluir um produto por id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        try {
            String mensagem = produtoService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao deletar o produto: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método GET
    //URL: http://localhost:8080/api/produto/findByNome/{nome}
    //Método para encontrar produtos por nome 
    @GetMapping("/findByNome/{nome}")
    public ResponseEntity<List<Produto>> findByNome(@PathVariable String nome) {
        try {
            List<Produto> produtos = produtoService.findByNome(nome);
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método GET
    //URL: http://localhost:8080/api/produto/findByValorAbaixoIgual/{valor}
    //Método para encontrar produtos cujo o valor é abaixo ou igual ao especificado
    @GetMapping("/findByValorAbaixoIgual/{valor}")
    public ResponseEntity<List<Produto>> findByValorAbaixoIgual(@PathVariable double valor) {
        try {
            List<Produto> produtos = produtoService.findByValorAbaixoIgual(valor);
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método GET
    //URL: http://localhost:8080/api/produto/buscarProdutosComValorAcima/{valor}
    //Método para encontrar produtos cujo o valor é acima do especificado
    @GetMapping("/buscarProdutosComValorAcima/{valor}")
    public ResponseEntity<List<Produto>> buscarProdutosComValorAcima(@PathVariable double valor) {
        try {
            List<Produto> produtos = produtoService.buscarProdutosComValorAcima(valor);
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}

//Ass: Josué Antonio Gardasz Obadovski