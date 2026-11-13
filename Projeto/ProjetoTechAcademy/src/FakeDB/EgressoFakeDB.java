package FakeDB;

import java.util.ArrayList;

import Dominio.Egresso;

public class EgressoFakeDB 
    extends BaseGenericaFakeDB<Egresso>{

    @Override 
    protected  void autoPreencher(){
        this.dados.add(new Egresso(101, "Gustavo Alves", "67801", 2019, "Sistemas de Informacao", "Desenvolvimento"));
        this.dados.add(new Egresso(102, "Patricia Souza", "67802", 2020, "Administracao", "Gestao"));
        this.dados.add(new Egresso(103, "Henrique Faria", "67803", 2018, "Engenharia", "Projetos"));
        this.dados.add(new Egresso(104, "Juliana Barros", "67804", 2021, "Contabilidade", "Auditoria"));
        this.dados.add(new Egresso(105, "Vitor Matos", "67805", 2022, "Direito", "Consultoria"));
    }

    public EgressoFakeDB(){
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }
}
