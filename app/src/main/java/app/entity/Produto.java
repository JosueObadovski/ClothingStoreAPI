package app.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //Identificador único do produto, gerado automaticamente.
    
    @NotNull(message = "Nome não pode ser nulo")
    private String nome; //Nome do produto, não pode ser nulo.
    
    @NotNull(message = "Valor não pode ser nulo")
    private double valor; //Valor do produto, não pode ser nulo.
    
    //Lista de vendas que contêm este produto. Relação muitos-para-muitos.
    @ManyToMany(mappedBy = "produtos", cascade = CascadeType.ALL)
    private List<Venda> vendas;
}

//Ass: Josué Antonio Gardasz Obadovski