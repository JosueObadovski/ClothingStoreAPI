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

    public String save(Venda venda) {
        this.vendaRepository.save(venda);
        return "Venda realizada com sucesso";
    }

    public String update(long id, Venda venda) {
        venda.setId(id);
        this.vendaRepository.save(venda);
        return "Venda atualizada com sucesso";
    }

    public List<Venda> listAll() {
        return this.vendaRepository.findAll();
    }

    public Venda findById(long id) {
        return this.vendaRepository.findById(id).get();
    }

    public String delete(long id) {
        this.vendaRepository.deleteById(id);
        return "Venda deletada com sucesso!";
    }
}
