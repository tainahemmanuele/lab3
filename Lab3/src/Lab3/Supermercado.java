/* 114210211 - Tainah Emmanuele Silva: LAB 3 - Turma 3 */
package Lab3;

import java.util.Scanner;

public class Supermercado {
	private int contador;
	private int n;
	private Produto[] produtos;
	private double vendaTotal;

	// Construtor
	public Supermercado() {
		contador = 0;
		n = 5;
		produtos = new Produto[n];
	}

	public Produto[] getProdutos() {

		return produtos;
	}

	public void setVendaTotal(double valor) {

		vendaTotal += valor;
	}

	public double getVendaTotal() {
		return vendaTotal;
	}

	// criacao do metodo para o cadastro de produtos
	public void cadastraProdutos(Scanner ler) {

		String escolha = "sim";
		while (escolha.equals("sim")) {
			System.out.println("= = = = Cadastro de Produtos = = = =");
			System.out.print("Digite o nome do produto:");
			String nomeProduto = ler.nextLine();
			System.out.print("Digite o preco unitario do produto:");
			double preco = ler.nextDouble();
			ler.nextLine();
			System.out.print("Digite o tipo do produto:");
			String tipo = ler.nextLine();
			System.out.print("Digite a quantidade no estoque:");
			int qtd = ler.nextInt();
			ler.nextLine();

			System.out.println();
			System.out.println(qtd + " " + nomeProduto
					+ " cadastrado com sucesso");

			// condicao criada para aumentar o tamanho do array
			if (contador == n - 1) {
				n = 2 * n;
				Produto[] novosProdutos = new Produto[n];
				// for criado para copiar os elementos do antigo array para o
				// novo de maior tamanho
				for (int i = 0; i < getProdutos().length; i++) {

					novosProdutos[i] = getProdutos()[i];
				}
				produtos = novosProdutos;
			}

			getProdutos()[contador] = new Produto(nomeProduto, preco, tipo, qtd);
			contador = contador + 1;

			System.out.println();
			System.out.print("Deseja cadastrar outro produto?");
			escolha = ler.nextLine();
		}

	}

	// criacao do metodo para venda de produtos
	public void vendaProdutos(Scanner ler) {
		String escolha = "sim";

		while (escolha.equals("sim")) {
			// contador criado para auxiliar caso o produto nao tenha sido
			// cadastrado. Se ele nao existir, o contador2 deve ser igual ao
			// tamanho do array(variavel contador)
			int contador2 = 0;
			System.out.println("= = = = Venda de Produtos = = = =");
			System.out.print("Digite o nome do produto ");
			String produtoTipo = ler.nextLine();

			// caso não tenha sido cadastrado nenhum produto, essa condicao ira
			// gerar a mensagem informando
			if (contador == 0) {
				System.out.println("==> " + produtoTipo
						+ " nao cadastrado no sistema");

			}

			// for criado para percorrer o array e procurar o produto
			for (int i = 0; i < contador; i++) {
				// variavel criada para auxiliar a procura pelo produto
				boolean key = false;

				if (getProdutos()[i].getNome().equals(produtoTipo)) {

					System.out.println("==> " + getProdutos()[i].getNome()
							+ "(" + getProdutos()[i].getTipo() + ")." + "R$"
							+ getProdutos()[i].getPreco());
					key = true;
					System.out.println();
					System.out.print("Digite a quantidade que deseja vender:");
					int quantidade = (ler.nextInt());
					ler.nextLine();

					// se a quantidade de produtos que se deseja comprar,for
					// menor ou igual a quantidade de produtos cadastradas, a
					// condicao sera executada
					if (quantidade <= getProdutos()[i].getQtd()) {

						int valor = getProdutos()[i].getQtd() - quantidade;
						getProdutos()[i].alteraQuantidade(valor);
						double precoVenda = getProdutos()[i].getPreco()
								* quantidade;
						setVendaTotal(precoVenda);
						System.out.println("==> Total arrecadado: R$"
								+ precoVenda);

					} else {

						System.out.println("Não é possível vender pois não há "
								+ produtoTipo + " suficiente.");

					}

				} else if (key == false) {
					contador2 += 1;
				}

				if (contador == contador2) {
					System.out.println("==> " + produtoTipo
							+ " nao cadastrado no sistema");
					key = true;

				}
			}

			System.out.println();
			System.out.print("Deseja vender outro produto?");
			escolha = ler.nextLine();
		}
	}

	public void balanco() {

		double valorArrecadado = 0;
		double valorTotal = 0;

		System.out.println("= = = = Impressao de Balanco = = = =");
		System.out.println("Produtos cadastrados:");

		for (int i = 0; i < contador; i++) {
			// calculo do valor total de cada produto
			valorTotal = getProdutos()[i].getPreco()
					* getProdutos()[i].getQtd();
			// calculo do valor arrecadado de todos os produtos do array
			valorArrecadado = valorArrecadado + valorTotal;

			System.out.println("  " + (i + 1) + " ) "
					+ getProdutos()[i].getNome() + "("
					+ getProdutos()[i].getTipo() + ")." + "R$"
					+ getProdutos()[i].getPreco() + " Restante:"
					+ getProdutos()[i].getQtd());

		}

		System.out.println();
		System.out.println("Total arrecadado em vendas: R$ " + getVendaTotal());
		System.out.println("Total que pode ser arrecadado: R$ "
				+ valorArrecadado);
	}

}
