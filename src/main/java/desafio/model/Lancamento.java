package desafio.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tab_lancamento")
public class Lancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(columnDefinition = "DATE")
    LocalDate data;
    @ManyToOne
    @JoinColumn(name = "cd_conta_origem")
    Conta origem;
    @ManyToOne
    @JoinColumn(name = "cd_conta_destino")
    Conta destino;
    @Column
    PlanoDeConta planoDeConta;
    @Column
    Double valor;
    @Column(length = 100)
    String descricao;
}
