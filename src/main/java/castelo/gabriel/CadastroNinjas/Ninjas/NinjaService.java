package castelo.gabriel.CadastroNinjas.Ninjas;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    @Transactional
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.map(ninjaMapper::map).orElse(null);
    }

    @Transactional
    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    /*
    // Can be used in Put later
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        if (ninjaPorId.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaAtualizado);
        }
        return null;
    }
    */

    @Transactional
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        if (ninjaPorId.isPresent()){
            NinjaModel ninja = ninjaMapper.patchMap(ninjaPorId.get(), ninjaDTO);
            ninjaRepository.save(ninja);
            return ninjaMapper.map(ninja);
        }
        else {
            return null;
        }
    }
}
