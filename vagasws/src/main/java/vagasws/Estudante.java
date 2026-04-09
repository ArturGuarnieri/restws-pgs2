package vagasws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estudante {
    private long id;
    private String nome;
    private String email;
    private String nascimento;
    private int anoIngresso;

    public Estudante(String nome, String email, String nascimento, int anoIngresso) {
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.anoIngresso = anoIngresso;
    }
}
