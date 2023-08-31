package pilha;

import java.util.Scanner;

public class PilhaInteiros {

	public static void main(String[] args) throws Exception {

		Pilha p = new Pilha();

		Scanner scanner = new Scanner(System.in);
		int escolha;

		do {
			System.out.println("---- MENU ----\n");
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Empilhar valor");
			System.out.println("2 - Desempilhar valor");
			System.out.println("3 - Mostrar último elemento");
			System.out.println("4 - Mostrar tamanho da pilha");
			System.out.println("5 - Sair");
			System.out.print("Opção: ");
			escolha = scanner.nextInt();
			System.out.println("\n--------------\n");

			switch (escolha) {

			case 1:
				System.out.print("Informe o valor: ");
				int valor = scanner.nextInt();
				p.push(valor);
				System.out.println("\n--------------\n");

				break;

			case 2:

				try {
					int valorDesempilhado = p.pop();
					System.out.println("Valor desempilhado: " + valorDesempilhado);
				} catch (Exception e) {
					System.out.println("A pilha está vazia.");
				}
				System.out.println("\n--------------\n");
				break;

			case 3:
				if (!p.isEmpty()) {
					System.out.println("Último elemento na pilha: " + p.top());
				} else {
					System.out.println("A pilha está vazia.");
				}
				System.out.println("\n--------------\n");
				break;

			case 4:
				System.out.println("Tamanho da pilha: " + p.size());
				System.out.println("\n--------------\n");
				break;

			case 5:
				System.out.println("Saindo do programa.");
				System.out.println("\n--------------\n");
				break;

			default:
				System.out.println("Opção inválida. Escolha novamente.");
				System.out.println("\n--------------\n");
				break;
			}
		} while (escolha != 5);

		scanner.close();
	}
}
