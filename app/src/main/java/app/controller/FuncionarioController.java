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

import app.entity.Funcionario;
import app.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;
    
    //Método POST
    //URL: POST http://localhost:8080/api/funcionario/save
    //Método para salvar um novo funcionário
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Funcionario funcionario) {
        try {
            String mensagem = funcionarioService.save(funcionario);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao salvar o funcionário: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método PUT
    //URL: http://localhost:8080/api/funcionario/update/{id}
    //Método para atualizar um funcionário existente pelo id
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody Funcionario funcionario) {
        try {
            String mensagem = funcionarioService.update(id, funcionario);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar o funcionário: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método GET
    //URL: http://localhost:8080/api/funcionario/listAll
    //Método para listar todos os funcionários
    @GetMapping("/listAll")
    public ResponseEntity<List<Funcionario>> listAll() {
        try {
            List<Funcionario> funcionarios = funcionarioService.listAll();
            return new ResponseEntity<>(funcionarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método GET
    //URL: http://localhost:8080/api/funcionario/findById/{id}
    //Método para encontrar funcionários por id
    @GetMapping("/findById/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable long id) {
        try {
            Funcionario funcionario = funcionarioService.findById(id);
            return funcionario != null ? new ResponseEntity<>(funcionario, HttpStatus.OK) 
                                       : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    //Metódo DELETE
    //URL: http://localhost:8080/api/funcionario/delete/{id}
    //Método para excluir um funcionário por id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        try {
            String mensagem = funcionarioService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao deletar o funcionário: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método GET
    //URL: http://localhost:8080/api/funcionario/findByNome/{nome}
    //Método para encontrar funcionários por nome
    @GetMapping("/findByNome/{nome}")
    public ResponseEntity<List<Funcionario>> findByNome(@PathVariable String nome) {
        try {
            List<Funcionario> funcionarios = funcionarioService.findByNome(nome);
            return new ResponseEntity<>(funcionarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método GET
    //URL: http://localhost:8080/api/funcionario/findByIdade/{idade}
    //Método para encontrar funcionários por idade
    @GetMapping("/findByIdade/{idade}")
    public ResponseEntity<List<Funcionario>> findByIdade(@PathVariable int idade) {
        try {
            List<Funcionario> funcionarios = funcionarioService.findByIdade(idade);
            return new ResponseEntity<>(funcionarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    //Método GET
    //URL: http://localhost:8080/api/funcionario/findByMatriculaNumeroAcima/{matricula}
    //Método para encontrar funcionários cuja matrícula tem número acima do especificado
    @GetMapping("/findByMatriculaNumeroAcima/{matricula}")
    public ResponseEntity<List<Funcionario>> findByMatriculaNumeroAcima(@PathVariable String matricula) {
        try {
            List<Funcionario> funcionarios = funcionarioService.findByMatriculaNumeroAcima(matricula);
            return new ResponseEntity<>(funcionarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}

//Ass: Josué Antonio Gardasz Obadovski