/* 114210211 - Tainah Emmanuele Silva: LAB 3 - Turma 3 */
package Lab3;

//criacao da classe produto
public class Produto {
	private String nome = "";
	private double preco = 0;
	private String tipo = "";
	private int qtd = 0;

	public Produto(String nome, double preco, String tipo, int qtd) {
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
		this.qtd = qtd;
	}

	// criacao de get para auxiliar a impressao
	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public String getTipo() {
		return tipo;
	}

	public int getQtd() {
		return qtd;
	}

	// criacao do toString
	public String toString() {
		return getNome() + ", " + getPreco() + ", " + getTipo() + ","
				+ getQtd() + ".";
	}

	// metodo para alterar quantidade no array
	public void alteraQuantidade(int valor) {
		this.qtd = valor;

	}

}
