package Dominio;

public class Visitante extends BasePrestador {
    private String motivoVisita;
    private int crachaNumero;
    private String setorVisita;

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    public int getCrachaNumero() {
        return crachaNumero;
    }

    public void setCrachaNumero(int crachaNumero) {
        this.crachaNumero = crachaNumero;
    }

    public String getSetorVisita() {
        return setorVisita;
    }

    public void setSetorVisita(String setorVisita) {
        this.setorVisita = setorVisita;
    }

    @Override
    public void exibir(){
        System.out.println("\n[VISITANTE] Codigo: " + this.codigo);
        System.out.print("Nome: " + this.nome);
        System.out.print(" | CPF: " + this.cpf);
        System.out.print(" | Email: " + this.email);
        System.out.print(" | Telefone: " + this.telefone);
        System.out.println(" | Endereco: " + this.endereco);
        System.out.print("Motivo: " + this.motivoVisita);
        System.out.print(" | Cracha: " + this.crachaNumero);
        System.out.println(" | Setor: " + this.setorVisita);
    }

    public Visitante(){}

    public Visitante(int codigo,
        String nome,
        String cpf,
        String email,
        String telefone,
        String endereco,
        String motivoVisita,
        int crachaNumero,
        String setorVisita){
        super(codigo, nome, cpf, email, telefone, endereco);
        this.motivoVisita = motivoVisita;
        this.crachaNumero = crachaNumero;
        this.setorVisita = setorVisita;
    }

}
