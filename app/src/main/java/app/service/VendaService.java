package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Venda;
import app.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    
    //Salva uma entidade Venda no banco de dados e retorna uma mensagem de sucesso.
    public String save(Venda venda) {
        this.vendaRepository.save(venda);
        return "Venda realizada com sucesso";
    }
    
    //Atualiza uma entidade Venda existente, definindo seu ID e salvando, retornando uma mensagem de sucesso.
    public String update(long id, Venda venda) {
        venda.setId(id);
        this.vendaRepository.save(venda);
        return "Venda atualizada com sucesso";
    }
    
    //Retorna uma lista de todas as entidades Venda do banco de dados.
    public List<Venda> listAll() {
        return this.vendaRepository.findAll();
    }
    
    //Encontra uma única entidade Venda pelo seu ID. Caso não encontrado, pode lançar uma NoSuchElementException.
    public Venda findById(long id) {
        return this.vendaRepository.findById(id).get();
    }
    
    //Exclui uma entidade Venda pelo seu ID.
    public String delete(long id) {
        this.vendaRepository.deleteById(id);
        return "Venda deletada com sucesso!";
    }
    
    //Busca vendas com valor acima de um determinado valor.
    public List<Venda> buscarVendasComValorAcima(double valor) {
        return this.vendaRepository.buscarVendasComValorAcima(valor);
    }

}

//Ass: Josué Antonio Gardasz Obadovski