package vagasws;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VagaController {
    @Autowired
    private VagaRepo VagaRepo;

    public VagaController() {
    }

    @GetMapping("/fci/api/vagas")
    public Iterable<Vaga> getVagas() {
        return VagaRepo.findAll();
    }

    @GetMapping("/fci/api/vagas/{id}")
    public Optional<Vaga> getVaga(@PathVariable long id) {
        return VagaRepo.findById(id);
    }

    @PostMapping("/fci/api/vagas")
    public Vaga createVaga(@RequestBody Vaga novaVaga) {
        return VagaRepo.save(novaVaga);
    }

    @PutMapping("/fci/api/vagas/{vagaId}")
    public Optional<Vaga> updateVaga(
            @RequestBody Vaga vagaRequest,
            @PathVariable long vagaId) {
        return VagaRepo.findById(vagaId)
                .map(vaga -> {
                    vaga.setTitulo(vagaRequest.getTitulo());
                    vaga.setDescricao(vagaRequest.getDescricao());
                    vaga.setPublicacao(vagaRequest.getPublicacao());
                    vaga.setAtivo(vagaRequest.isAtivo());
                    vaga.setIdEmpresa(vagaRequest.getIdEmpresa());
                    return VagaRepo.save(vaga);
                });
    }

    @DeleteMapping("/fci/api/vagas/{id}")
    public void deleteVaga(@PathVariable long id) {
        VagaRepo.deleteById(id);
    }
}
