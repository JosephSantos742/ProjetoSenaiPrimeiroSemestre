package classes;

import java.io.Serializable;

public class Pedido  implements Serializable {
	private String dadosClientes;
	private String produtos;
	private String total;
	private int numeroPedido;

	public Pedido(String dadosClientes, String produtos, String total, int numeroPedido) {
		super();
		this.dadosClientes = dadosClientes;
		this.produtos = produtos;
		this.total = total;
		this.numeroPedido = numeroPedido;
	}

	public String mostrarPedido() {
		return  "\nPedido Nº: " + this.numeroPedido + "\n\n" + 
				this.dadosClientes + "\n\n" + 
				this.produtos + "\n" +
				"TOTAL DO PEDIDO: " + this.total + "\n" +
				"----------------------------------------------------------------";
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}
	
}
