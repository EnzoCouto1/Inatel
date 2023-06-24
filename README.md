# Inatel
ProjetoPOO
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Criando um arquivo
        Arquivo arq = new Arquivo();

        // Criando um Prato
        Pratos pratos = new Pratos();
        // Entrada de dados
        Lagosta lagosta = new Lagosta();

        Caviar caviar = new Caviar();

        CarneDeOuro carnedeouro = new CarneDeOuro();
        Scanner sc = new Scanner(System.in);
        // Flag de controle do while
        boolean flag = true;

        while (flag) {
            // ArrayList auxiliar com os pratos - retorno a partir do método de leitura
            ArrayList<Pratos> pratoss = arq.ler();

            System.out.println("BEM VINDO AO MENU");
            System.out.println("1- Cadastrar Prato");
            System.out.println("2- Listar Pratos");
            System.out.println("3- Escolher Pratos");
            System.out.println("4- Sair");
            System.out.println("Entre com a sua opção: ");

            int opcao = sc.nextInt(); // Entrada de opção do usuário
            sc.nextLine(); // Limpando o buffer

            if (pratoss.size() == 0) {
                System.out.println("Não existem pratos cadastrados ainda");
            }
            switch (opcao) {
                case 1 -> {
                    System.out.println(" ADICIONANDO UM PRATO ....");
                    try {
                        System.out.println("Nome: ");
                        pratos.setNomePrato(sc.nextLine());
                        // Verificando o digitado para os Pratos
                        if (!(pratos.getNomePrato().equalsIgnoreCase("Caviar")
                                || pratos.getNomePrato().equalsIgnoreCase("Lagosta") ||
                                pratos.getNomePrato().equalsIgnoreCase("Carne de Ouro"))) {
                            throw new InfoInvalidaException("SELECIONE UM DOS TRÊS PRATOS\n Caviar - Carne de Ouro - Lagosta"); // Lançando a exceção
                        }
                        System.out.println("Preço: ");
                        pratos.setPreco(sc.nextDouble());

                        if ((pratos.getNomePrato().equalsIgnoreCase("Lagosta"))) {
                            lagosta.setAdicional("Molho");
                            lagosta.setModoDeServir("Sem casca no prato");
                        } else if ((pratos.getNomePrato().equalsIgnoreCase("Caviar"))) {
                            caviar.setAdicional("Pão branco e manteiga");
                            caviar.setModoDeServir("Pequenas porções");
                        } else if ((pratos.getNomePrato().equalsIgnoreCase("Carne de Ouro"))) {
                            carnedeouro.setModelCorte("Tamanho Médio");

                        }

                    } catch (InfoInvalidaException info) {
                        System.out.println(info);


                        break; // Para a execução e não permite o cadastro do Prato
                    }
                    arq.escrever(pratos); // Salvando no arquivo o livro
                }
                case 2 -> {
                    // Percorrendo o arrayList de livros e mostrando as informações
                    for (Pratos value : pratoss) {
                        value.mostraInfo();
                    }
                }
                case 3 ->{
                    // Selecionando pratos
                    System.out.println("Digite o nome do prato");
                    if((pratos.getNomePrato().equalsIgnoreCase("Lagosta"))) {
                        System.out.println("Opçao escolhida: Lagosta");
                        System.out.println("preco: " + pratos.getPreco());
                    }
                    if ((pratos.getNomePrato().equalsIgnoreCase("Caviar"))) {
                        System.out.println("Opçao escolhida: Caviar");
                        System.out.println("preco: " + pratos.getPreco());
                        System.out.println("Bom apetite");
                    }
                    if((pratos.getNomePrato().equalsIgnoreCase("CarneDeOuro"))){
                        System.out.println("opçao escolhida: Carne de Ouro");
                        System.out.println("preco: "+pratos.getPreco());
                        System.out.println("modelo de corte:");

                    }
                }
                case 4 -> flag = false;
                default -> System.out.println("Opção Invalida");
            }
        }
        sc.close();
    }
}
