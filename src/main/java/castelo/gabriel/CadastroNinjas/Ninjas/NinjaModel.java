package castelo.gabriel.CadastroNinjas.Ninjas;

import castelo.gabriel.CadastroNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_ninjas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "missoes")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissaoModel missoes;

    @Column(name= "rank")
    private String rank;


}
