package vagasws;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VagaController {
    private List<Vaga> vagas = new ArrayList<>();

    public VagaController() {
        vagas.add(new Vaga(1, "Desenvolvedor Java", "Atuacao em projetos backend com Java e Spring. Experiencia desejada em APIs REST.", "2025-10-01", true, 1));
        vagas.add(new Vaga(2, "Analista de Suporte Tecnico", "Suporte a clientes, resolucao de chamados e participacao em treinamentos internos.", "2025-09-27", true, 2));
        vagas.add(new Vaga(3, "Engenheiro de Software", "Desenvolvimento de solucoes para sistemas corporativos, integracao e automacao.", "2025-10-03", false, 3));
        vagas.add(new Vaga(4, "Analista de Dados", "Manipulacao e analise de grandes volumes de dados. Conhecimentos de SQL e Python.", "2025-09-18", true, 4));
        vagas.add(new Vaga(5, "Designer Digital", "Criacao de materiais graficos, UX/UI e participacao em campanhas de marketing.", "2025-09-30", false, 5));
        vagas.add(new Vaga(6, "Consultor de Projetos", "Elaboracao e acompanhamento de projetos empresariais e treinamentos.", "2025-10-06", true, 1));
        vagas.add(new Vaga(7, "Programador Full Stack", "Desenvolvimento de aplicacoes web frontend e backend com foco em automacao.", "2025-10-04", true, 2));
    }

    @GetMapping("/fci/api/vagas")
    public Iterable<Vaga> getVagas() {
        return vagas;
    }

    @GetMapping("/fci/api/vagas/{id}")
    public Optional<Vaga> getVaga(@PathVariable long id) {
        for (Vaga v : vagas) {
            if (v.getId() == id) {
                return Optional.of(v);
            }
        }
        return Optional.empty();
    }

    @PostMapping("/fci/api/vagas")
    public Vaga createVaga(@RequestBody Vaga novaVaga) {
        long maiorId = 1;
        for (Vaga v : vagas) {
            if (v.getId() > maiorId) {
                maiorId = v.getId();
            }
        }
        long novoId = maiorId + 1;
        novaVaga.setId(novoId);
        vagas.add(novaVaga);
        return novaVaga;
    }

    @PutMapping("/fci/api/vagas/{vagaId}")
    public Optional<Vaga> updateVaga(
            @RequestBody Vaga vagaRequest,
            @PathVariable long vagaId) {

        Optional<Vaga> opt = this.getVaga(vagaId);
        if (opt.isPresent()) {
            Vaga vaga = opt.get();
            vaga.setTitulo(vagaRequest.getTitulo());
            vaga.setDescricao(vagaRequest.getDescricao());
            vaga.setPublicacao(vagaRequest.getPublicacao());
            vaga.setAtivo(vagaRequest.isAtivo());
            vaga.setIdEmpresa(vagaRequest.getIdEmpresa());
        }
        return opt;
    }

    @DeleteMapping("/fci/api/vagas/{id}")
    public void deleteVaga(@PathVariable long id) {
        vagas.removeIf(v -> v.getId() == id);
    }
}
