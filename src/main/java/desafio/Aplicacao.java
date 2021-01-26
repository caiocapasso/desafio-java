package desafio;

import desafio.enums.TipoConta;
import desafio.model.Conta;
import desafio.model.Usuario;
import desafio.service.UsuarioService;

public class Aplicacao {
    public static void main(String[] args) {

        UsuarioService s = new UsuarioService();

        Usuario u1 = new Usuario("aaa", "12345", "aaa aaa", "33333333333", "5511999999999", new Conta("0001", 100.0, TipoConta.CORRENTE));
        s.incluir(u1);
        Usuario u2 = new Usuario("bbb", "23456", "bbb bbb", "44444444444", "5511988888888", new Conta("0002", 200.0, TipoConta.SALARIO));
        s.incluir(u2);

        Conta poupanca = new Conta("0003", 50.0, TipoConta.POUPANCA);
        u1.addConta(poupanca);

        //Usuario u = new Usuario();
        //u.setLogin("caio.capasso");
        //u.setSenha("12345");
        //u.setNome("caio capasso");
        //u.setCpf("333333333-33");
        //u.setTel("5511999999999");
        //Conta c = new Conta("0001", 100.0, TipoConta.CORRENTE);
        //u.addConta(c);
        //s.incluir(u);


    }
}
