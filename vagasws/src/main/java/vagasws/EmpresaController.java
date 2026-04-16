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
public class EmpresaController {

    @Autowired
    private EmpresaRepo EmpresaRepo;

    public EmpresaController() {
    }

    @GetMapping("/fci/api/empresas")
    public Iterable<Empresa> getEmpresas() {
        Iterable<Empresa> empresas = EmpresaRepo.findAll();
        return empresas;
    }

    @GetMapping("/fci/api/empresas/{id}")
    public Optional<Empresa> getEmpresa(@PathVariable long id) {
        return EmpresaRepo.findById(id);
    }

    @PostMapping("/fci/api/empresas")
    public Empresa createEmpresa(@RequestBody Empresa novaEmpresa) {
        return EmpresaRepo.save(novaEmpresa);
    }

    @PutMapping("/fci/api/empresas/{empresaId}")
    public Optional<Empresa> updateEmpresa(
            @RequestBody Empresa empresaRequest,
            @PathVariable long empresaId) {
        return EmpresaRepo.findById(empresaId)
                .map(empresa -> {
                    empresa.setNome(empresaRequest.getNome());
                    empresa.setCnpj(empresaRequest.getCnpj());
                    empresa.setEmail(empresaRequest.getEmail());
                    return EmpresaRepo.save(empresa);
                });
    }

    @DeleteMapping("/fci/api/empresas/{id}")
    public void deleteEmpresa(@PathVariable long id) {
        EmpresaRepo.deleteById(id);
    }
}


