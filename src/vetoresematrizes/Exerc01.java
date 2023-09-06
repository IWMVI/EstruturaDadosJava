package vetoresematrizes;

import java.util.Random;

/*	Criar uma matriz com 5 linhas e 10 colunas e pesquisar se o valor 201 existe.	
 * 	Se encontrar, escrever a posição (Linha e Coluna).
 */

public class Exerc01 {
	public static void main(String[] args) {

//		int mat[][] = { { 4, 5, 6, 9, 201, 5, 0, 201 }, { 201, 6, 8, 9, 4, 201, 6, 201 } }; // ------ TESTE

		Random rand = new Random();

		int mat[][] = new int[5][10];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = rand.nextInt(250);
			}
		}

		encontrarValores(mat, 0, 0);
	}

	public static void encontrarValores(int[][] mat, int linha, int coluna) {
		if (linha >= mat.length) {
			return; // Todas as linhas foram verificadas
		}

		if (coluna >= mat[linha].length) {
			encontrarValores(mat, linha + 1, 0); // Avançar para a próxima linha
			return;
		}

		if (mat[linha][coluna] == 201) {
			System.out.println("Valor 201 encontrado na posição: Linha " + linha + ", Coluna " + coluna);
		}

		encontrarValores(mat, linha, coluna + 1); // Procurar na próxima coluna
	}
}
