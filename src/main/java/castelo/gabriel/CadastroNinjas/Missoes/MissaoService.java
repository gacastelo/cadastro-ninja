package castelo.gabriel.CadastroNinjas.Missoes;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {
    MissaoRepository missaoRepository;
    MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    @Transactional
    public MissaoDTO criarMissao(MissaoDTO missaoDTO) {
        MissaoModel missao = missaoMapper.map(missaoDTO);
        missaoRepository.save(missao);
        return missaoMapper.map(missao);
    }

    public List<MissaoDTO> listarMissoes() {
        List<MissaoModel> missoes = missaoRepository.findAll();
        return missoes.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());
    }

    public MissaoDTO listarMissaoPorId(Long id) {
        Optional<MissaoModel> missaoModel = missaoRepository.findById(id);
        return missaoModel.map(missaoMapper::map).orElse(null);
    }

    @Transactional
    public MissaoDTO alterarMissao(Long id, MissaoDTO missaoAlterada) {
        Optional<MissaoModel> missaoPorId = missaoRepository.findById(id);
        if (missaoPorId.isPresent()) {
            MissaoModel missao = missaoMapper.patchMap(missaoPorId.get(), missaoAlterada);
            missaoRepository.save(missao);
            return missaoMapper.map(missao);
        } else {
            return null;
        }
    }

    @Transactional
    public void deletarMissaoPorId(Long id) {
        missaoRepository.deleteById(id);
    }

}
