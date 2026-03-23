package castelo.gabriel.CadastroNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {
    MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel criarMissao(MissoesModel missao) {
        return missoesRepository.save(missao);
    }

    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }

    public MissoesModel listarMissaoPorId(Long id) {
        return missoesRepository.findById(id).orElse(null);
    }
}
