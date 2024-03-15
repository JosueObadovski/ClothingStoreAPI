package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //Identificador único do cliente, gerado automaticamente.
    
    @NotNull(message = "Nome não pode ser nulo")
    private String nome; //Nome do cliente, não pode ser nulo.
    
    @NotNull(message = "CPF não pode ser nulo")
    private String cpf; //CPF do cliente, não pode ser nulo.
    
    @NotNull(message = "Idade não pode ser nulo")
    private int idade; //Idade do cliente, não pode ser nulo.
    
    private String telefone; //Telefone do cliente, pode ser nulo.
    
    //Lista de vendas associadas a este cliente. Relação um-para-muitos.
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Venda> vendas;
}

//Ass: Josué Antonio Gardasz Obadovski