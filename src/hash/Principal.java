package hash;

import java.util.Scanner;

public class Principal {
    private static final int SAIR = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashAlfabetica hashAlfabetica = new HashAlfabetica(26, 26);
        Hash hashNomes = new Hash(50, 50);
        Hash hashLista = new Hash(100, 100);

        int opcao;
        do {
            exibirMenu();

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1, 2, 3:
                    tratarHash(getHash(opcao, hashAlfabetica, hashNomes, hashLista), scanner);
                    break;
                case SAIR:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != SAIR);
    }

    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Tratar Hash Alfabética");
        System.out.println("2. Tratar Hash Nomes");
        System.out.println("3. Tratar Hash Lista");
        System.out.println("0. Sair");
        System.out.println();
    }

    private static Hash getHash(int opcao, Hash hashAlfabetica, Hash hashNomes, Hash hashLista) {
        switch (opcao) {
            case 1:
                return hashAlfabetica;
            case 2:
                return hashNomes;
            case 3:
                return hashLista;
            default:
                throw new IllegalArgumentException("Opção inválida para obtenção de Hash.");
        }
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
                case 6, 7, 8:
                    tratarOpcoesHashAlfabetica((HashAlfabetica) hash, opcao, scanner);
                    break;
                case SAIR:
                    System.out.println("Saindo do tratamento da Hash.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != SAIR);
    }

    private static void exibirMenuHash(Hash hash) {
        System.out.println("\nMenu da Hash:");
        System.out.println("1. Adicionar Pessoa");
        System.out.println("2. Pesquisar Pessoa");
        System.out.println("3. Remover Pessoa");
        System.out.println("4. Verificar se está cheio");
        System.out.println("5. Imprimir");

        if (hash instanceof HashAlfabetica) {
            System.out.println("6. Pesquisar por Letra");
            System.out.println("7. Verificar Ordem Alfabética");
        }

        System.out.println("0. Sair do tratamento da Hash");
        System.out.println();
    }

    private static void tratarOpcoesHashAlfabetica(HashAlfabetica hashAlfabetica, int opcao, Scanner scanner) {
        switch (opcao) {
            case 6:
                pesquisarPorLetra(hashAlfabetica, scanner);
                break;
            case 7:
                verificarOrdemAlfabetica(hashAlfabetica);
                break;
            default:
                System.out.println("Opção inválida para Hash Alfabética. Tente novamente.");
        }
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

    private static void pesquisarPorLetra(HashAlfabetica hashAlfabetica, Scanner scanner) {
        System.out.print("Digite a letra para pesquisar: ");
        char letra = scanner.next().charAt(0);
        hashAlfabetica.pesquisarPorLetra(letra);
    }

    private static void verificarOrdemAlfabetica(HashAlfabetica hashAlfabetica) {
        hashAlfabetica.verificarOrdemAlfabetica();
    }
}
