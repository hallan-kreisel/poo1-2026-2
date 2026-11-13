package FakeDB;

import java.util.ArrayList;

import Dominio.Estagiario;

public class EstagiarioFakeDB 
    extends BaseGenericaFakeDB<Estagiario>{

    @Override 
    protected  void autoPreencher(){
        this.dados.add(new Estagiario(101, "Bruna Martins", "56701", "bruna@email.com", "67988880001", "Av. X, 100", 1200.00, 30, "Desenvolvimento"));
        this.dados.add(new Estagiario(102, "Diego Nunes", "56702", "diego@email.com", "67988880002", "Av. Y, 200", 1100.00, 25, "Suporte"));
        this.dados.add(new Estagiario(103, "Larissa Prado", "56703", "larissa@email.com", "67988880003", "Av. Z, 300", 1300.00, 30, "Marketing"));
        this.dados.add(new Estagiario(104, "Thiago Melo", "56704", "thiago@email.com", "67988880004", "Av. W, 400", 1000.00, 20, "Financeiro"));
        this.dados.add(new Estagiario(105, "Camila Rocha", "56705", "camila@email.com", "67988880005", "Av. V, 500", 1250.50, 30, "RH"));
    }

    public EstagiarioFakeDB(){
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }
}
