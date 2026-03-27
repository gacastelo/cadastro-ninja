package castelo.gabriel.CadastroNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissaoController {

    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }


    @PostMapping("/criar")
    public ResponseEntity<MissaoDTO> criarMissao(@RequestBody MissaoDTO missaoDTO){
        MissaoDTO missao = missaoService.criarMissao(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(missao);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissaoDTO>> listarMissoes(){
        return ResponseEntity.ok(missaoService.listarMissoes());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<MissaoDTO> listarMissaoPorId(@PathVariable Long id){
        MissaoDTO missaoDTO = missaoService.listarMissaoPorId(id);
        return (missaoDTO != null) ? ResponseEntity.ok(missaoDTO) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/alterar/{id}")
    public ResponseEntity<MissaoDTO> alterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO){
        MissaoDTO missao = missaoService.alterarMissao(id, missaoDTO);
        return (missao != null) ? ResponseEntity.ok(missao) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if (missaoService.listarMissaoPorId(id) != null){
            missaoService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missão com o ID " + id + " deletada com sucesso!");
        }
        return ResponseEntity.notFound().build();
    }
}
