package DAO;

import Dominio.Egresso;
import FakeDB.EgressoFakeDB;

public class EgressoDAO 
    extends BaseGenericaDAO<Egresso> {

    @Override
    public Egresso create(Egresso novo) {
        int codigoAtual = this.repositorio.getLast().getCodigo();
        int codigoNovo = codigoAtual + 1;
        novo.setCodigo(codigoNovo);
        this.repositorio.add(novo);
        return novo;
    }

    @Override
    public Egresso readOne(int codigo) {
        for (Egresso item : this.repositorio) {
            if (item.getCodigo() == codigo){
                return item;
            }
        }
        return null;
    }

    @Override
    public Egresso update(Egresso alterado) {
        int codigoProcurado = alterado.getCodigo();
        if (this.readOne(codigoProcurado) != null){
            int index = this.repositorio.indexOf(alterado);
            this.repositorio.set(index, alterado);
            return alterado;
        }
        return null;
    }

    @Override
    public Egresso delete(Egresso apagado) {
        int codigoProcurado = apagado.getCodigo();
        if (this.readOne(codigoProcurado) != null){
            this.repositorio.remove(apagado);
            return apagado;
        }
        return null;
    }

    @Override
    public Egresso deletePorID(int codigo) {
        Egresso apagado = this.readOne(codigo);
        if (apagado != null){
            this.repositorio.remove(apagado);
            return apagado;
        }
        return null;
    }

    public EgressoDAO(){
        this.fonteDados = new EgressoFakeDB();
        this.repositorio = this.fonteDados.getDados();
    }
}
