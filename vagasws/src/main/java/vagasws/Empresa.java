package vagasws;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Empresa {
    @Id @GeneratedValue
    private long id;
    private String nome;
    private String cnpj;
    private String email;

    public Empresa(String nome, String cnpj, String email) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
    }
}