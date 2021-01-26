package desafio.model;

import desafio.enums.TipoPlanoDeConta;

import javax.persistence.*;

@Entity
@Table(name = "tab_plano_conta")
public class PlanoDeConta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 6)
    private Conta conta;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoPlanoDeConta tipo;
}
