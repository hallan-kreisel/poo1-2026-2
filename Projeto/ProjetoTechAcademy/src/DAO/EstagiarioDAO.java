package DAO;

import Dominio.Estagiario;
import FakeDB.EstagiarioFakeDB;

public class EstagiarioDAO 
    extends BaseGenericaDAO<Estagiario> {

    @Override
    public Estagiario create(Estagiario novo) {
        int codigoAtual = this.repositorio.getLast().getCodigo();
        int codigoNovo = codigoAtual + 1;
        novo.setCodigo(codigoNovo);
        this.repositorio.add(novo);
        return novo;
    }

    @Override
    public Estagiario readOne(int codigo) {
        for (Estagiario item : this.repositorio) {
            if (item.getCodigo() == codigo){
                return item;
            }
        }
        return null;
    }

    @Override
    public Estagiario update(Estagiario alterado) {
        int codigoProcurado = alterado.getCodigo();
        if (this.readOne(codigoProcurado) != null){
            int index = this.repositorio.indexOf(alterado);
            this.repositorio.set(index, alterado);
            return alterado;
        }
        return null;
    }

    @Override
    public Estagiario delete(Estagiario apagado) {
        int codigoProcurado = apagado.getCodigo();
        if (this.readOne(codigoProcurado) != null){
            this.repositorio.remove(apagado);
            return apagado;
        }
        return null;
    }

    @Override
    public Estagiario deletePorID(int codigo) {
        Estagiario apagado = this.readOne(codigo);
        if (apagado != null){
            this.repositorio.remove(apagado);
            return apagado;
        }
        return null;
    }

    public EstagiarioDAO(){
        this.fonteDados = new EstagiarioFakeDB();
        this.repositorio = this.fonteDados.getDados();
    }
}
