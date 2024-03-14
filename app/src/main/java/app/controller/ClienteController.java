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

import app.entity.Cliente;
import app.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    //Método POST
    //URL: http://localhost:8080/api/cliente/save
    //Método para salvar um novo cliente
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Cliente cliente) {
        try {
            String mensagem = clienteService.save(cliente);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao salvar o cliente: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método PUT
    //URL: http://localhost:8080/api/cliente/update/{id}
    //Método para atualizar um cliente existente pelo id
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody Cliente cliente) {
        try {
            String mensagem = clienteService.update(id, cliente);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar o cliente: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método GET
    //URL: http://localhost:8080/api/cliente/listAll
    //Método para listar todos os clientes
    @GetMapping("/listAll")
    public ResponseEntity<List<Cliente>> listAll() {
        try {
            List<Cliente> clientes = clienteService.listAll();
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método GET
    //URL: http://localhost:8080/api/cliente/findById/{id}
    //Método para encontrar um cliente por id
    @GetMapping("/findById/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable long id) {
        try {
            Cliente cliente = clienteService.findById(id);
            return cliente != null ? new ResponseEntity<>(cliente, HttpStatus.OK) 
                                  : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método DELETE
    //URL: http://localhost:8080/api/cliente/delete/{id}
    //Método para excluir um cliente por id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        try {
            String mensagem = clienteService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao deletar o cliente: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método GET
    //URL: http://localhost:8080/api/cliente/findByNome/{nome}
    //Método para encontrar clientes por nome
    @GetMapping("/findByNome/{nome}")
    public ResponseEntity<List<Cliente>> findByNome(@PathVariable String nome) {
        try {
            List<Cliente> clientes = clienteService.findByNome(nome);
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método GET
    //URL: http://localhost:8080/api/cliente/findByIdade/{idade}
    //Método para encontrar clientes por idade
    @GetMapping("/findByIdade/{idade}")
    public ResponseEntity<List<Cliente>> findByIdade(@PathVariable int idade) {
        try {
            List<Cliente> clientes = clienteService.findByIdade(idade);
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método GET
    //URL: http://localhost:8080/api/cliente/findByCpf/{cpf}
    //Método para encontrar clientes por cpf
    @GetMapping("/findByCpf/{cpf}")
    public ResponseEntity<List<Cliente>> findByCpf(@PathVariable String cpf) {
        try {
            List<Cliente> clientes = clienteService.findByCpf(cpf);
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}

//Ass: Josué Antonio Gardasz Obadovski