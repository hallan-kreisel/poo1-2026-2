package Visao;

import java.util.Scanner;

import Dominio.Estagiario;
import Servico.EstagiarioSRV;

public class EstagiarioMenu extends BaseMenu implements IMenu{

    private EstagiarioSRV servico;

    private Estagiario estagSelecionado;

    public void iniciar(){
        this.exibirMenuPrincipal();
    }

    private void exibirMenuPrincipal(){
        this.scan = new Scanner(System.in);
        int opcao = 0;
        while(opcao != 9){
            opcao = this.exibirMenuPai("ESTAGIARIO");
            switch (opcao) {
                case 1:
                    this.listarTodos();
                    break;
                case 2:
                    this.pesquisarPorCodigo();
                    break;
                case 3:
                    this.incluir();
                    break;
                case 4:
                    this.alterar();
                    break;
                case 5:
                    this.excluir();
                    break;
                case 9:
                    System.out.println("TCHAU");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    this.pausar();
                    break;
            }
        }        
    }

    @Override 
    public void listarTodos(){
        System.out.println("\n\n");
        System.out.println("***** LISTAR TODOS *****");
        for (Estagiario item : this.servico.listar()) {
            item.exibir();
        }        
    }

    @Override 
    public void pesquisarPorCodigo(){
        System.out.println("\n\n");
        System.out.println("***** PESQUISAR POR CÓDIGO *****");
        System.out.print("Informe o código: ");
        int codigo = this.scan.nextInt();
        this.scan.nextLine();
        this.estagSelecionado = this.servico.buscar(codigo);
        if(this.estagSelecionado == null){
            System.out.println("ERRO - Código inválido");
            this.pausar();
            return;
        }
        else{
            this.estagSelecionado.exibir();
        }
    }

    @Override 
    public void incluir(){
        System.out.println("\n\n");
        System.out.println("***** INCLUIR *****");
        System.out.print("Informe o nome: ");
        String nome = this.scan.nextLine();
        System.out.print("Informe o CPF: ");
        String cpf = this.scan.nextLine();
        System.out.print("Informe o email: ");
        String email = this.scan.nextLine();
        System.out.print("Informe o telefone: ");
        String telefone = this.scan.nextLine();
        System.out.print("Informe o endereço: ");
        String endereco = this.scan.nextLine();
        System.out.print("Informe o valor da bolsa: ");
        double valorBolsa = this.scan.nextDouble();
        this.scan.nextLine();
        System.out.print("Informe a carga horária semanal: ");
        int cargaHoraria = this.scan.nextInt();
        this.scan.nextLine();
        System.out.print("Informe a área de estágio: ");
        String areaEstagio = this.scan.nextLine();
        Estagiario novo = new Estagiario(0, nome, cpf, email, telefone, 
            endereco, valorBolsa, cargaHoraria, areaEstagio);
        novo = this.servico.criar(novo);
        novo.exibir();
    }

    @Override 
    public void alterar(){
        System.out.println("\n\n");
        System.out.println("***** ALTERAR *****");
        this.pesquisarPorCodigo();
        if(this.estagSelecionado != null){
            int escolha = 0;
            while(escolha != 9){
                System.out.println("##### CAMPOS DISPONÍVEIS #####");
                System.out.println("1 - Nome");
                System.out.println("2 - CPF");
                System.out.println("3 - Email");
                System.out.println("4 - Telefone");
                System.out.println("5 - Endereço");
                System.out.println("6 - Valor da bolsa");
                System.out.println("7 - Carga horária semanal");
                System.out.println("8 - Área de estágio");
                System.out.println("9 - Salvar");
                System.out.print("Escolha uma opção para alterar:");
                escolha = this.scan.nextInt();
                this.scan.nextLine();
                String nome, cpf, email, telefone, endereco, areaEstagio;
                double valorBolsa;
                int cargaHoraria;
                switch (escolha) {
                    case 1:
                        System.out.print("Nome: ");
                        nome = this.scan.nextLine();
                        this.estagSelecionado.setNome(nome);
                        break;
                    case 2:
                        System.out.print("CPF: ");
                        cpf = this.scan.nextLine();
                        this.estagSelecionado.setCpf(cpf);
                        break;
                    case 3:
                        System.out.print("Email: ");
                        email = this.scan.nextLine();
                        this.estagSelecionado.setEmail(email);
                        break;
                    case 4:
                        System.out.print("Telefone: ");
                        telefone = this.scan.nextLine();
                        this.estagSelecionado.setTelefone(telefone);
                        break;
                    case 5:
                        System.out.print("Endereço: ");
                        endereco = this.scan.nextLine();
                        this.estagSelecionado.setEndereco(endereco);
                        break;
                    case 6:
                        System.out.print("Valor da bolsa: ");
                        valorBolsa = this.scan.nextDouble();
                        this.scan.nextLine();
                        this.estagSelecionado.setValorBolsa(valorBolsa);
                        break;
                    case 7:
                        System.out.print("Carga horária semanal: ");
                        cargaHoraria = this.scan.nextInt();
                        this.scan.nextLine();
                        this.estagSelecionado.setCargaHorariaSemanal(cargaHoraria);
                        break;
                    case 8:
                        System.out.print("Área de estágio: ");
                        areaEstagio = this.scan.nextLine();
                        this.estagSelecionado.setAreaEstagio(areaEstagio);
                        break;
                    case 9:
                        this.estagSelecionado = 
                            this.servico.alterar(this.estagSelecionado);
                        this.estagSelecionado.exibir();
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override 
    public void excluir(){
        System.out.println("\n\n");
        System.out.println("***** EXCLUIR *****");
        this.pesquisarPorCodigo();
        if(this.estagSelecionado != null){
            int codigo = this.estagSelecionado.getCodigo();
            this.estagSelecionado = this.servico.excluirPorID(codigo);
            // this.estagSelecionado.exibir();
        }
    }

    public EstagiarioMenu(){
        this.servico = new EstagiarioSRV();
    }
}
