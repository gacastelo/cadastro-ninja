package castelo.gabriel.CadastroNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao Criada";
    }
    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missoes listadas";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao Alterada";
    }
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao Deletadada";
    }
}
