package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String enderecoEntrega;
    
    @NotNull(message = "Valor total não pode ser nulo")
    private double valorTotal;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("vendas")
    private Cliente cliente;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("vendas")
    private Funcionario funcionario;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="venda_produto",
               joinColumns = @JoinColumn(name="venda_id"),
               inverseJoinColumns = @JoinColumn(name="produto_id"))
    private List<Produto> produtos;
}
