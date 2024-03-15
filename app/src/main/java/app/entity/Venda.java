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
    private long id; //Identificador único da venda, gerado automaticamente.
    
    private String enderecoEntrega; //Endereço de entrega da venda, pode ser nulo.
    
    @NotNull(message = "Valor total não pode ser nulo")
    private double valorTotal; //Valor total da venda, não pode ser nulo.
    
    //Cliente associado a esta venda. Relação muitos-para-um.
    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("vendas")
    private Cliente cliente;
    
    //Funcionário responsável pela venda. Relação muitos-para-um.
    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("vendas")
    private Funcionario funcionario;
    
    //Produtos incluídos na venda. Relação muitos-para-muitos.
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="venda_produto", //Tabela de associação
               joinColumns = @JoinColumn(name="venda_id"), //Coluna que armazena o id das vendas
               inverseJoinColumns = @JoinColumn(name="produto_id"))//Coluna que guarda os identificadores dos produtos incluidos em cada venda
    private List<Produto> produtos;
}

//Ass: Josué Antonio Gardasz Obadovski
