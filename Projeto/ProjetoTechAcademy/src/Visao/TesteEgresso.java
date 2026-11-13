package Visao;

import Dominio.Egresso;
import Servico.EgressoSRV;

public class TesteEgresso {
    
    private Egresso obj;

    private EgressoSRV srv;

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
        for(Egresso item : srv.listar()){
            item.exibir();
        }
    }

    private void criar(){
        System.out.println("\n\n\n\n\n");
        System.out.println("***** CRIANDO REGISTRO *****");
        this.obj = new Egresso(0, "Egresso Teste", "99903", 2025, "Curso Teste", "Area Teste");
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

    public TesteEgresso(){
        this.srv = new EgressoSRV();
    }
    
}
