package hash;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hash hashAlfabetica = new HashAlfabetica(26, 26);
        Hash hashNomes = new Hash(50, 50);
        Hash hashLista = new Hash(100, 100);

        int opcao;
        do {
            exibirMenu();

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    tratarHash(hashAlfabetica, scanner);
                    break;
                case 2:
                    tratarHash(hashNomes, scanner);
                    break;
                case 3:
                    tratarHash(hashLista, scanner);
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Tratar Hash Alfabética");
        System.out.println("2. Tratar Hash Nomes");
        System.out.println("3. Tratar Hash Lista");
        System.out.println("0. Sair");
    }

    private static void tratarHash(Hash hash, Scanner scanner) {
        int opcao;
        do {
            exibirMenuHash(hash);

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarPessoa(hash, scanner);
                    break;
                case 2:
                    pesquisarPessoa(hash, scanner);
                    break;
                case 3:
                    removerPessoa(hash, scanner);
                    break;
                case 4:
                    verificarCheio(hash);
                    break;
                case 5:
                    hash.print();
                    break;
                case 6:
                    if (hash instanceof HashAlfabetica) {
                        ((HashAlfabetica) hash).print();
                    } else {
                        System.out.println("Essa operação só é válida para a Hash Alfabética.");
                    }
                    break;
                case 7:
                    if (hash instanceof HashAlfabetica) {
                        pesquisarPessoa((HashAlfabetica) hash, scanner);
                    } else {
                        System.out.println("Essa operação só é válida para a Hash Alfabética.");
                    }
                    break;
                case 8:
                    if (hash instanceof HashAlfabetica) {
                        verificarOrdemAlfabetica((HashAlfabetica) hash);
                    } else {
                        System.out.println("Essa operação só é válida para a Hash Alfabética.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo do tratamento da Hash.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    private static void exibirMenuHash(Hash hash) {
        System.out.println("\nMenu da Hash:");
        System.out.println("1. Adicionar Pessoa");
        System.out.println("2. Pesquisar Pessoa");
        System.out.println("3. Remover Pessoa");
        System.out.println("4. Verificar se está cheio");
        System.out.println("5. Imprimir");

        if (hash instanceof HashAlfabetica) {
            System.out.println("6. Imprimir em Ordem Alfabética");
            System.out.println("7. Pesquisar por Letra");
            System.out.println("8. Verificar Ordem Alfabética");
        }

        System.out.println("0. Sair do tratamento da Hash");
    }

    private static void adicionarPessoa(Hash hash, Scanner scanner) {
        System.out.print("Digite o ID da pessoa: ");
        int id = scanner.nextInt();
        System.out.print("Digite o nome da pessoa: ");
        scanner.nextLine(); // Limpar o buffer
        String nome = scanner.nextLine();

        Pessoa pessoa = new Pessoa(id, nome);
        hash.push(pessoa);
        System.out.println("Pessoa adicionada com sucesso!");
    }

    private static void pesquisarPessoa(Hash hash, Scanner scanner) {
        System.out.print("Digite o ID da pessoa a ser pesquisada: ");
        int id = scanner.nextInt();
    
        Pessoa pessoaEncontrada = hash.search(id);
    
        if (pessoaEncontrada != null) {
            System.out.println("Pessoa encontrada: " + pessoaEncontrada.getNome());
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }
    

    private static void removerPessoa(Hash hash, Scanner scanner) {
        System.out.print("Digite o ID da pessoa a ser removida: ");
        int id = scanner.nextInt();

        Pessoa pessoaRemover = new Pessoa(id, "");
        hash.pop(pessoaRemover);
        System.out.println("Pessoa removida com sucesso!");
    }

    private static void verificarCheio(Hash hash) {
        if (hash.isFull()) {
            System.out.println("A estrutura está cheia.");
        } else {
            System.out.println("A estrutura não está cheia.");
        }
    }

   /* private static void pesquisarPorLetra(HashAlfabetica hash, Scanner scanner) {
        System.out.print("Digite a letra para pesquisar: ");
        char letra = scanner.next().charAt(0);

        boolean[] busca = new boolean[1];
        hash.searchPorLetra(letra, busca);
        if (busca[0]) {
            System.out.println("Pelo menos uma pessoa encontrada com a letra " + letra);
        } else {
            System.out.println("Nenhuma pessoa encontrada com a letra " + letra);
        }
    } */

    private static void verificarOrdemAlfabetica(HashAlfabetica hash) {
        hash.verificarOrdemAlfabetica();
    }
}
