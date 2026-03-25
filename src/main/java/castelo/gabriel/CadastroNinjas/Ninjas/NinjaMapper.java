package castelo.gabriel.CadastroNinjas.Ninjas;

import castelo.gabriel.CadastroNinjas.Missoes.MissaoModel;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());

        return ninjaDTO;
    }

    public NinjaModel patchMap(NinjaModel ninjaModel, NinjaDTO ninjaDTO){

        Long newId = (ninjaDTO.getId() != null) ? ninjaDTO.getId() : ninjaModel.getId();
        String newNome = (ninjaDTO.getNome() != null) ? ninjaDTO.getNome() : ninjaModel.getNome();
        String newEmail = (ninjaDTO.getEmail() != null) ? ninjaDTO.getEmail() : ninjaModel.getEmail();
        int newIdade = (ninjaDTO.getIdade() != 0) ? ninjaDTO.getIdade() : ninjaModel.getIdade();
        String newRank = (ninjaDTO.getRank() != null) ? ninjaDTO.getRank() : ninjaModel.getRank();
        MissaoModel newMissoes = (ninjaDTO.getMissoes() != null) ? ninjaDTO.getMissoes() : ninjaModel.getMissoes();

        ninjaModel.setId(newId);
        ninjaModel.setNome(newNome);
        ninjaModel.setEmail(newEmail);
        ninjaModel.setIdade(newIdade);
        ninjaModel.setRank(newRank);
        ninjaModel.setMissoes(newMissoes);
        return ninjaModel;
    }
}
