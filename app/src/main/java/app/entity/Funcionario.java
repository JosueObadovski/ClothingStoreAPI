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
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //Identificador único do funcionário, gerado automaticamente.
    
    @NotNull(message = "Nome não pode ser nulo")
    private String nome; //Nome do funcionário, não pode ser nulo.
    
    @NotNull(message = "Idade não pode ser nula")
    private int idade; //Idade do funcionário, não pode ser nulo.
    
    @NotNull(message = "Matrícula não pode ser nula")
    private String matricula; //Número de matrícula do funcionário, não pode ser nulo.
    
    //Lista de vendas realizadas pelo funcionário. Relação um-para-muitos.
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<Venda> vendas;
}

//Ass: Josué Antonio Gardasz Obadovski