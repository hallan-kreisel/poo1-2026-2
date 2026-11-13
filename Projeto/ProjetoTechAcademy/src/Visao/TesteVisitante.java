package Visao;

import Dominio.Visitante;
import Servico.VisitanteSRV;

public class TesteVisitante {
    
    private Visitante obj;

    private VisitanteSRV srv;

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
        for(Visitante item : srv.listar()){
            item.exibir();
        }
    }

    private void criar(){
        System.out.println("\n\n\n\n\n");
        System.out.println("***** CRIANDO REGISTRO *****");
        this.obj = new Visitante(0, "Visitante Teste", "99901", "teste@email.com", "67900000000", "Rua Teste, 1", "Teste", 99, "TI");
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

    public TesteVisitante(){
        this.srv = new VisitanteSRV();
    }
    
}
