package Visao;

import Dominio.Estagiario;
import Servico.EstagiarioSRV;

public class TesteEstagiario {
    
    private Estagiario obj;

    private EstagiarioSRV srv;

    public void executar(){
        this.listar();
        this.criar();
        this.listar();
        this.alterar();
        this.listar();
        this.excluir();
        this.listar();
    }

    private void listar(){
        System.out.println("\n\n\n\n\n");
        System.out.println("***** LISTANDO TUDO *****");
        for(Estagiario item : srv.listar()){
            item.exibir();
        }
    }

    private void criar(){
        System.out.println("\n\n\n\n\n");
        System.out.println("***** CRIANDO REGISTRO *****");
        this.obj = new Estagiario(0, "Estagiario Teste", "99902", "teste@email.com", "67900000000", "Rua Teste, 2", 900.00, 20, "TI");
        srv.criar(this.obj);
        this.obj.exibir();
    }

    private void alterar(){
        System.out.println("\n\n\n\n\n");
        System.out.println("***** ALTERANDO REGISTRO *****");
        this.obj.setNome("Nome Alterado");
        this.obj = this.srv.alterar(this.obj);
        this.obj.exibir();
    }

    private void excluir(){
        System.out.println("\n\n\n\n\n");
        System.out.println("***** EXCLUINDO REGISTRO *****");
        this.obj = srv.excluirPorID(obj.getCodigo());
        this.obj.exibir();
    }

    public TesteEstagiario(){
        this.srv = new EstagiarioSRV();
    }
    
}
