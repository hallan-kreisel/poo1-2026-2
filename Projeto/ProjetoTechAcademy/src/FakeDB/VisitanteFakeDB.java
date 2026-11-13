package FakeDB;

import java.util.ArrayList;

import Dominio.Visitante;

public class VisitanteFakeDB 
    extends BaseGenericaFakeDB<Visitante>{

    @Override 
    protected  void autoPreencher(){
        this.dados.add(new Visitante(101, "Carlos Pereira", "45601", "carlos@email.com", "67999990001", "Rua A, 10", "Reuniao comercial", 1, "Comercial"));
        this.dados.add(new Visitante(102, "Ana Lima", "45602", "ana@email.com", "67999990002", "Rua B, 20", "Entrevista", 2, "RH"));
        this.dados.add(new Visitante(103, "Joao Ramos", "45603", "joao@email.com", "67999990003", "Rua C, 30", "Manutencao", 3, "TI"));
        this.dados.add(new Visitante(104, "Fernanda Dias", "45604", "fernanda@email.com", "67999990004", "Rua D, 40", "Entrega", 4, "Almoxarifado"));
        this.dados.add(new Visitante(105, "Rafael Costa", "45605", "rafael@email.com", "67999990005", "Rua E, 50", "Auditoria", 5, "Financeiro"));
    }

    public VisitanteFakeDB(){
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }
}
