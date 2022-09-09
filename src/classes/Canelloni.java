package classes;

public class Canelloni extends Massas {
	private String tipoRecheio;
	private float valorRecheio;

	public Canelloni(String tipoMassa, String saborMassa, String peso, String molho, String tipoRecheio) {
		super(tipoMassa, saborMassa, peso, molho);
		this.tipoRecheio = tipoRecheio;
	}

	@Override
	public float calcularTotal() {
		super.calcularTotal();

		if (this.tipoRecheio.equals("Presunto e Queijo")) {
			this.valorRecheio = 10;
		} else if (this.tipoRecheio.equals("Ricota com Escarola")) {
			this.valorRecheio = 10;
		}

		return this.valorTotal = valorTipoMassa + valorSaborMassa + valorPeso + valorMolho + valorRecheio;
	}

	@Override
	public String mostrarPedido() {
		return super.mostrarPedido() + "\nRecheio: " + this.tipoRecheio;
	}

}
