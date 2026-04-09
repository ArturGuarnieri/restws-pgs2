package vagasws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {
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