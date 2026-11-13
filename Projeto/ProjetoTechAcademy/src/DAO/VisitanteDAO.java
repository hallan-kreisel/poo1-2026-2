package DAO;

import Dominio.Visitante;
import FakeDB.VisitanteFakeDB;

public class VisitanteDAO 
    extends BaseGenericaDAO<Visitante> {

    @Override
    public Visitante create(Visitante novo) {
        int codigoAtual = this.repositorio.getLast().getCodigo();
        int codigoNovo = codigoAtual + 1;
        novo.setCodigo(codigoNovo);
        this.repositorio.add(novo);
        return novo;
    }

    @Override
    public Visitante readOne(int codigo) {
        for (Visitante item : this.repositorio) {
            if (item.getCodigo() == codigo){
                return item;
            }
        }
        return null;
    }

    @Override
    public Visitante update(Visitante alterado) {
        int codigoProcurado = alterado.getCodigo();
        if (this.readOne(codigoProcurado) != null){
            int index = this.repositorio.indexOf(alterado);
            this.repositorio.set(index, alterado);
            return alterado;
        }
        return null;
    }

    @Override
    public Visitante delete(Visitante apagado) {
        int codigoProcurado = apagado.getCodigo();
        if (this.readOne(codigoProcurado) != null){
            this.repositorio.remove(apagado);
            return apagado;
        }
        return null;
    }

    @Override
    public Visitante deletePorID(int codigo) {
        Visitante apagado = this.readOne(codigo);
        if (apagado != null){
            this.repositorio.remove(apagado);
            return apagado;
        }
        return null;
    }

    public VisitanteDAO(){
        this.fonteDados = new VisitanteFakeDB();
        this.repositorio = this.fonteDados.getDados();
    }
}
