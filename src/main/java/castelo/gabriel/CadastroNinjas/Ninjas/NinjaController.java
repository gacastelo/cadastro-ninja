package castelo.gabriel.CadastroNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja Criado";
    }

    @GetMapping("/todos")
    public String mostrarTodosNinjas() {
        return "Todos os Ninjas";
    }

    @GetMapping("/todosID")
    public String mostraNinjaPorID() {
        return "Ninja por Id";
    }

    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Alterar Ninja por ID";
    }

    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Deletar Ninja por ID";
    }
}
