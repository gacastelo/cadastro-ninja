package castelo.gabriel.CadastroNinjas.UI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {
    @GetMapping
    public String inicio(){
        return "index";
    }

    @GetMapping("/ninjas")
    public String exibirUINinja(){
        return "ninja/ninjas";
    }

    @GetMapping("/missoes")
    public String exibirUIMissao(){
        return "missao/missoes";
    }

}
