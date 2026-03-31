package castelo.gabriel.CadastroNinjas.Missoes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("missoes/ui")
public class MissaoControllerUI {

    MissaoService missaoService;

    public MissaoControllerUI(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping("adicionar")
    public String mostrarFormularioAdicionarMissao(Model model){
        model.addAttribute("missao", new MissaoDTO());
        return "missao/adicionarMissao";
    }

    @GetMapping("listar")
    public String listarMissoes(Model model){
        List<MissaoDTO> missoes = missaoService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "missao/listarMissoes";
    }

    @GetMapping("detalhar/{id}")
    public String detalharMissao(@PathVariable Long id, Model model){
        MissaoDTO missao = missaoService.listarMissaoPorId(id);
        if (missao != null){
            model.addAttribute("missao", missao);
            return "missao/detalhesMissao";
        }
        else {
            model.addAttribute("mensagem", "Missão Não Encontrada!");
            return "missao/listarMissoes";
        }
    }

    @GetMapping("alterar/{id}")
    public String atualizarMissao(@PathVariable Long id, Model model){
        MissaoDTO missao = missaoService.listarMissaoPorId(id);
        if (missao != null){
            model.addAttribute("missaoPatch", missao);
            return "missao/alterarMissao";
        }
        else {
            model.addAttribute("mensagem", "Missão Não Encontrada!");
            return "missao/listarMissoes";
        }
    }

    @PostMapping("/patch")
    public String NinjaPatch(@ModelAttribute MissaoDTO missao, RedirectAttributes redirectAttributes){
        missaoService.alterarMissao(missao.getId(), missao);
        redirectAttributes.addFlashAttribute("mensagem", "Missão cadastrada com sucesso!");
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        missaoService.deletarMissaoPorId(id);
        redirectAttributes.addFlashAttribute("mensagem", "Missão deletada com sucesso!");
        return "redirect:/missoes/ui/listar";
    }

}
