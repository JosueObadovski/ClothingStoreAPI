package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Cliente;
import app.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //Salva uma entidade Cliente no banco de dados e retorna uma mensagem de sucesso.
    public String save(Cliente cliente) {
        this.clienteRepository.save(cliente);
        return cliente.getNome() + " salvo com sucesso";
    }
    
    //Atualiza uma entidade Cliente existente, definindo seu ID e salvando, retornando uma mensagem de sucesso.
    public String update(long id, Cliente cliente) {
        cliente.setId(id);
        this.clienteRepository.save(cliente);
        return cliente.getNome() + " atualizado com sucesso";
    }
    
    //Retorna uma lista de todas as entidades Cliente do banco de dados.
    public List<Cliente> listAll(){
        return this.clienteRepository.findAll();
    }
    
    //Encontra uma única entidade Cliente pelo seu ID. Caso não encontrado, pode lançar uma NoSuchElementException.
    public Cliente findById(long idCliente) {
        Cliente cliente = this.clienteRepository.findById(idCliente).get();
        return cliente;
    }
    
    //Exclui uma entidade Cliente pelo seu ID.
    public String delete(long idCliente) {
        this.clienteRepository.deleteById(idCliente);
        return "Cliente deletado com sucesso!";
    }
    
    //Encontra entidades Cliente pelo seu nome.
    public List<Cliente> findByNome(String nome) {
        return this.clienteRepository.findByNome(nome);
    }
    
    //Encontra entidades Cliente pela sua idade.
    public List<Cliente> findByIdade(int idade) {
        return this.clienteRepository.findByIdade(idade);
    }
    
    //Encontra entidades Cliente pelo seu CPF.
    public List<Cliente> findByCpf(String cpf) {
        return this.clienteRepository.findByCpf(cpf);
    }

}

//Ass: Josué Antonio Gardasz Obadovski