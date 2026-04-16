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
public class EstudanteController {

    @Autowired
    private EstudanteRepo EstudanteRepo;

    public EstudanteController() {
    }

    @GetMapping("/fci/api/estudantes")
    public Iterable<Estudante> getEstudantes() {
        return EstudanteRepo.findAll();
    }

    @GetMapping("/fci/api/estudantes/{id}")
    public Optional<Estudante> getEstudante(@PathVariable long id) {
        return EstudanteRepo.findById(id);
    }

    @PostMapping("/fci/api/estudantes")
    public Estudante createEstudante(@RequestBody Estudante novoEstudante) {
        return EstudanteRepo.save(novoEstudante);
    }

    @PutMapping("/fci/api/estudantes/{estudanteId}")
    public Optional<Estudante> updateEstudante(
            @RequestBody Estudante estudanteRequest,
            @PathVariable long estudanteId) {
        return EstudanteRepo.findById(estudanteId)
                .map(estudante -> {
                    estudante.setNome(estudanteRequest.getNome());
                    estudante.setEmail(estudanteRequest.getEmail());
                    estudante.setNascimento(estudanteRequest.getNascimento());
                    estudante.setAnoIngresso(estudanteRequest.getAnoIngresso());
                    return EstudanteRepo.save(estudante);
                });
    }

    @DeleteMapping("/fci/api/estudantes/{id}")
    public void deleteEstudante(@PathVariable long id) {
        EstudanteRepo.deleteById(id);
    }
}
