package castelo.gabriel.CadastroNinjas.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/boas")
    public String boasVindas(){
      return "Seja bem vindo";
    }
}
