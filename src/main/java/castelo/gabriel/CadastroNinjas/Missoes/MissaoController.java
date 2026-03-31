package castelo.gabriel.CadastroNinjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(
            summary = "Cria uma nova missão",
            description = "Cria uma nova missão e salva no banco de dados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso",
                    content = @Content(schema = @Schema(implementation = MissaoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao criar missão")
    })
    public ResponseEntity<MissaoDTO> criarMissao(@RequestBody MissaoDTO missaoDTO){
        MissaoDTO missao = missaoService.criarMissao(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(missao);
    }

    @GetMapping("/listar")
    @Operation(
            summary = "Lista todas as missões",
            description = "Retorna uma lista com todas as missões cadastradas"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de missões retornada com sucesso",
                    content = @Content(schema = @Schema(implementation = MissaoDTO.class))),
            @ApiResponse(responseCode = "204", description = "Nenhuma missão encontrada")
    })
    public ResponseEntity<List<MissaoDTO>> listarMissoes(){
        return ResponseEntity.ok(missaoService.listarMissoes());
    }

    @GetMapping("/listar/{id}")
    @Operation(
            summary = "Busca missão por ID",
            description = "Retorna uma missão específica com base no ID informado"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão encontrada com sucesso",
                    content = @Content(schema = @Schema(implementation = MissaoDTO.class))),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<MissaoDTO> listarMissaoPorId(@PathVariable Long id){
        MissaoDTO missaoDTO = missaoService.listarMissaoPorId(id);
        return (missaoDTO != null) ? ResponseEntity.ok(missaoDTO) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/alterar/{id}")
    @Operation(
            summary = "Atualiza uma missão",
            description = "Atualiza os dados de uma missão existente pelo ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão atualizada com sucesso",
                    content = @Content(schema = @Schema(implementation = MissaoDTO.class))),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada"),
            @ApiResponse(responseCode = "400", description = "Erro ao atualizar missão")
    })
    public ResponseEntity<MissaoDTO> alterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO){
        MissaoDTO missao = missaoService.alterarMissao(id, missaoDTO);
        return (missao != null) ? ResponseEntity.ok(missao) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(
            summary = "Deleta uma missão",
            description = "Remove uma missão do sistema com base no ID informado"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if (missaoService.listarMissaoPorId(id) != null){
            missaoService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missão com o ID " + id + " deletada com sucesso!");
        }
        return ResponseEntity.notFound().build();
    }
}