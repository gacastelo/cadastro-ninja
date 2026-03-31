package castelo.gabriel.CadastroNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    @Operation(
            summary = "Criar ninja",
            description = "Cria um novo ninja e salva no banco de dados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso",
                    content = @Content(schema = @Schema(implementation = NinjaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao criar ninja")
    })
    public ResponseEntity<NinjaDTO> criarNinja(
            @Parameter(description = "Dados do ninja a ser criado")
            @RequestBody NinjaDTO ninjaDTO) {

        NinjaDTO ninja = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(201).body(ninja);
    }

    @GetMapping("/listar")
    @Operation(
            summary = "Listar todos os ninjas",
            description = "Retorna uma lista com todos os ninjas cadastrados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(schema = @Schema(implementation = NinjaDTO.class)))
    })
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    @Operation(
            summary = "Buscar ninja por ID",
            description = "Retorna um ninja específico baseado no ID informado"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado",
                    content = @Content(schema = @Schema(implementation = NinjaDTO.class))),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<NinjaDTO> listarNinjaPorID(
            @Parameter(description = "ID do ninja", example = "1")
            @PathVariable Long id) {

        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        return (ninja != null) ? ResponseEntity.ok(ninja) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/alterar/{id}")
    @Operation(
            summary = "Atualizar ninja",
            description = "Atualiza parcialmente os dados de um ninja pelo ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja atualizado com sucesso",
                    content = @Content(schema = @Schema(implementation = NinjaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao atualizar ninja"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<NinjaDTO> alterarNinja(
            @Parameter(description = "ID do ninja a ser atualizado", example = "1")
            @PathVariable Long id,

            @Parameter(description = "Dados atualizados do ninja")
            @RequestBody NinjaDTO ninja) {

        NinjaDTO ninjaDTO = ninjaService.atualizarNinja(id, ninja);
        return (ninjaDTO != null) ? ResponseEntity.ok(ninjaDTO) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(
            summary = "Deletar ninja",
            description = "Remove um ninja do sistema pelo ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<String> deletarNinjaPorId(
            @Parameter(description = "ID do ninja a ser deletado", example = "1")
            @PathVariable Long id) {

        if (ninjaService.listarNinjaPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com id " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}