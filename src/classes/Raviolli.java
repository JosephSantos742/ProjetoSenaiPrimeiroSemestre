package classes;

public class Raviolli extends Massas {
	private String tipoRecheio;
	private float valorRecheio;

	public Raviolli(String tipoMassa, String saborMassa, String peso, String molho, String tipoRecheio) {
		super(tipoMassa, saborMassa, peso, molho);
		this.tipoRecheio = tipoRecheio;
	}

	@Override
	public float calcularTotal() {
		super.calcularTotal();

		if (this.tipoRecheio.equals("Três Queijos")) {
			this.valorRecheio = 10;
		} else if (this.tipoRecheio.equals("Frango")) {
			this.valorRecheio = 10;
		} else if (this.tipoRecheio.equals("Ricota com Nozes")) {
			this.valorRecheio = 15;
		} else if (this.tipoRecheio.equals("Carne")) {
			this.valorRecheio = 17;
		} else if (this.tipoRecheio.equals("Funghi")) {
			this.valorRecheio = 17;
		} else if (this.tipoRecheio.equals("Mussarela de Búfala e Raspas de Limão")) {
			this.valorRecheio = 19;
		} else if (this.tipoRecheio.equals("Brie e Damasco")) {
			this.valorRecheio = 19;
		} else if (this.tipoRecheio.equals("Queijo Emmental com Abacaxi Caramelizado")) {
			this.valorRecheio = 33;
		}

		return this.valorTotal = valorTipoMassa + valorSaborMassa + valorPeso + valorMolho + valorRecheio;
	}

	@Override
	public String mostrarPedido() {
		return super.mostrarPedido() + "\nRecheio: " + this.tipoRecheio;
	}

}
