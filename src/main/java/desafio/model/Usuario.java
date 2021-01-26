package desafio.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tab_usuario", uniqueConstraints = @UniqueConstraint(columnNames = {"user"}, name = "uk_user"))
public class Usuario {
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "proprietario")
    private final List<Conta> contas = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user", length = 20)
    private String login;
    @Column(name = "pass", length = 100)
    private String senha;
    @Column(length = 50)
    private String nome;
    @Column(length = 11)
    private String cpf;
    @Column(length = 15)
    private String tel;


    public Usuario(String login, String senha, String nome, String cpf, String tel, Conta conta) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
        addConta(conta);
    }

    public void addConta(Conta conta) {
        conta.setProprietario(this);
        this.contas.add(conta);
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
