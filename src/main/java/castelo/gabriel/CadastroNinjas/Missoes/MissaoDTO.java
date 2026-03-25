package castelo.gabriel.CadastroNinjas.Missoes;

import castelo.gabriel.CadastroNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MissaoDTO {
    private Long id;
    private MissaoRank rank;
    private String nome;
    private List<NinjaModel> ninjas;
}
