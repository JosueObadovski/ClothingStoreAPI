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

    public String save(Funcionario funcionario) {
        this.funcionarioRepository.save(funcionario);
        return funcionario.getNome() + " salvo com sucesso";
    }

    public String update(long id, Funcionario funcionario) {
        funcionario.setId(id);
        this.funcionarioRepository.save(funcionario);
        return funcionario.getNome() + " atualizado com sucesso";
    }

    public List<Funcionario> listAll() {
        return this.funcionarioRepository.findAll();
    }

    public Funcionario findById(long id) {
        return this.funcionarioRepository.findById(id).get();
    }

    public String delete(long id) {
        this.funcionarioRepository.deleteById(id);
        return "Funcionário deletado com sucesso!";
    }
}
