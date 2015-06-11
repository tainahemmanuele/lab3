/* 114210211 - Tainah Emmanuele Silva: LAB 3 - Turma 3 */
package Lab3;

import java.util.Scanner;

public class MenuDeEntrada {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int opcao = 0;
		Supermercado venda = new Supermercado();

		do {

			System.out.println("= = = = Bem-vindo(a) ao Economiza P2 = = = =");
			System.out.println("Digita a opcao desejada:");
			System.out.println("1 - Cadastrar um Produto");
			System.out.println("2 - Vender um Produto");
			System.out.println("3 - Imprimir Balanco");
			System.out.println("4 - Sair");

			System.out.print("Opcao:");
			opcao = ler.nextInt();
			ler.nextLine();

			switch (opcao) {
			case 1:
				// chame metodo cadastraProduto
				venda.cadastraProdutos(ler);
				break;
			case 2:
				// chame metodo vendaProduto
				venda.vendaProdutos(ler);
				break;

			case 3:
				// chame metodo balanco
				venda.balanco();
				break;

			case 4:
				// saia do programa
				break;

			default:
				System.out.println("Opcao Invalida. Tente Novamente");

			}

		} while (opcao != 4);

	}
}
