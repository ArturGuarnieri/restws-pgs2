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
public class EmpresaController {
    private List<Empresa> empresas = new ArrayList<>();

    public EmpresaController() {
        empresas.add(new Empresa(1, "Empresa Alfa LTDA", "12.345.678/0001-90", "contato@empresa-alfa.com"));
        empresas.add(new Empresa(2, "Beta Comercio ME", "98.765.432/0001-10", "beta@comercio.com"));
        empresas.add(new Empresa(3, "Gamma Servicos S.A.", "11.222.333/0001-44", "servicos@gamma.com"));
        empresas.add(new Empresa(4, "Delta Engenharia", "22.333.444/0001-55", "contato@deltaeng.com"));
        empresas.add(new Empresa(5, "Epsilon Digital", "33.444.555/0001-66", "email@epsilondigital.com"));
    }

    @GetMapping("/fci/api/empresas")
    public Iterable<Empresa> getEmpresas() {
        return empresas;
    }

    @GetMapping("/fci/api/empresas/{id}")
    public Optional<Empresa> getEmpresa(@PathVariable long id) {
        for (Empresa e : empresas) {
            if (e.getId() == id) {
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }

    @PostMapping("/fci/api/empresas")
    public Empresa createEmpresa(@RequestBody Empresa novaEmpresa) {
        long maiorId = 1;
        for (Empresa e : empresas) {
            if (e.getId() > maiorId) {
                maiorId = e.getId();
            }
        }
        long novoId = maiorId + 1;
        novaEmpresa.setId(novoId);
        empresas.add(novaEmpresa);
        return novaEmpresa;
    }

    @PutMapping("/fci/api/empresas/{empresaId}")
    public Optional<Empresa> updateEmpresa(
            @RequestBody Empresa empresaRequest,
            @PathVariable long empresaId) {

        Optional<Empresa> opt = this.getEmpresa(empresaId);
        if (opt.isPresent()) {
            Empresa empresa = opt.get();
            empresa.setNome(empresaRequest.getNome());
            empresa.setCnpj(empresaRequest.getCnpj());
            empresa.setEmail(empresaRequest.getEmail());
        }
        return opt;
    }

    @DeleteMapping("/fci/api/empresas/{id}")
    public void deleteEmpresa(@PathVariable long id) {
        empresas.removeIf(e -> e.getId() == id);
    }
}
