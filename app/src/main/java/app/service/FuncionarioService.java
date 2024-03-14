package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Funcionario;
import app.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
    
    //Salva uma entidade Funcionario no banco de dados e retorna uma mensagem de sucesso.
    public String save(Funcionario funcionario) {
        this.funcionarioRepository.save(funcionario);
        return funcionario.getNome() + " salvo com sucesso";
    }

    //Atualiza uma entidade Funcionario existente, definindo seu ID e salvando, retornando uma mensagem de sucesso.
    public String update(long id, Funcionario funcionario) {
        funcionario.setId(id);
        this.funcionarioRepository.save(funcionario);
        return funcionario.getNome() + " atualizado com sucesso";
    }
    
    //Retorna uma lista de todas as entidades Funcionario do banco de dados.
    public List<Funcionario> listAll() {
        return this.funcionarioRepository.findAll();
    }

    //Encontra uma única entidade Funcionario pelo seu ID. Caso não encontrado, pode lançar uma NoSuchElementException.
    public Funcionario findById(long id) {
        return this.funcionarioRepository.findById(id).get();
    }
    
    //Exclui uma entidade Funcionario pelo seu ID.
    public String delete(long id) {
        this.funcionarioRepository.deleteById(id);
        return "Funcionário deletado com sucesso!";
    }
    
    //Encontra entidades Funcionario pelo seu nome.
    public List<Funcionario> findByNome(String nome) {
        return this.funcionarioRepository.findByNome(nome);
    }
    
    //Encontra entidades Funcionario pela sua idade.
    public List<Funcionario> findByIdade(int idade) {
        return this.funcionarioRepository.findByIdade(idade);
    }
    
    //Encontra entidades Funcionario com número de matrícula acima de um certo valor.
    public List<Funcionario> findByMatriculaNumeroAcima(String matricula) {
        return this.funcionarioRepository.findByMatriculaNumeroAcima(matricula);
    }

}

//Ass: Josué Antonio Gardasz Obadovski