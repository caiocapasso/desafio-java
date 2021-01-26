package desafio.model;

import desafio.enums.TipoConta;

import javax.persistence.*;

@Entity
@Table(name = "tab_conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 6)
    private String numero;

    @Column
    private Double saldo;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoConta tipo;

    @OneToOne
    @JoinColumn(name = "cd_usuario", referencedColumnName = "id")
    private Usuario proprietario;

    public Conta() {

    }

    public Conta(String numero, Double saldo, TipoConta tipo) {
        super();
        this.numero = numero;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    public Usuario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Usuario proprietario) {
        this.proprietario = proprietario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}
