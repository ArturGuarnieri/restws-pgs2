package vagasws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vaga {
    private long id;
    private String titulo;
    private String descricao;
    private String publicacao;
    private boolean ativo;
    private long idEmpresa;

    public Vaga(String titulo, String descricao, String publicacao, boolean ativo, long idEmpresa) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.publicacao = publicacao;
        this.ativo = ativo;
        this.idEmpresa = idEmpresa;
    }
}
