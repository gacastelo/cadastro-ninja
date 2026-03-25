package castelo.gabriel.CadastroNinjas.Missoes;

import castelo.gabriel.CadastroNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MissaoMapper {

    public MissaoDTO map(MissaoModel missaoModel){
        MissaoDTO missaoDTO = new MissaoDTO();
        missaoDTO.setId(missaoModel.getId());
        missaoDTO.setRank(missaoModel.getRank());
        missaoDTO.setNome(missaoModel.getNome());
        missaoDTO.setNinjas(missaoModel.getNinjas());
        return missaoDTO;
    }

    public MissaoModel map(MissaoDTO missaoDTO){
        MissaoModel missaoModel = new MissaoModel();
        missaoModel.setId(missaoDTO.getId());
        missaoModel.setRank(missaoDTO.getRank());
        missaoModel.setNome(missaoDTO.getNome());
        missaoModel.setNinjas(missaoDTO.getNinjas());
        return missaoModel;
    }

    public MissaoModel patchMap(MissaoModel missaoModel, MissaoDTO missaoDTO){
        Long newId = (missaoDTO.getId() != null) ? missaoDTO.getId() : missaoModel.getId();
        MissaoRank newRank = (missaoDTO.getRank() != null) ? missaoDTO.getRank() : missaoModel.getRank();
        String newNome = (missaoDTO.getNome() != null) ? missaoDTO.getNome() : missaoModel.getNome();
        List<NinjaModel> newNinjas =(missaoDTO.getNinjas() != null) ? missaoDTO.getNinjas() : missaoModel.getNinjas();

        missaoModel.setId(newId);
        missaoModel.setRank(newRank);
        missaoModel.setNome(newNome);
        missaoModel.setNinjas(newNinjas);

        return missaoModel;
    }
}
