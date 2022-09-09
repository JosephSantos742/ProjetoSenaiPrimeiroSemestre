package classes;

public class Capeletti extends Massas {
	private String tipoRecheio;
	private float valorRecheio;

	public Capeletti(String tipoMassa, String saborMassa, String peso, String molho, String tipoRecheio) {
		super(tipoMassa, saborMassa, peso, molho);
		this.tipoRecheio = tipoRecheio;
	}

	@Override
	public float calcularTotal() {
		super.calcularTotal();
		
		if (this.tipoRecheio.equals("Três Queijos")) {
			this.valorRecheio = 10;
		} else if (this.tipoRecheio.equals("Carne")) {
			this.valorRecheio = 13;
		}
		
		return this.valorTotal = valorTipoMassa + valorSaborMassa + valorPeso + valorMolho + valorRecheio;
	}

	@Override
	public String mostrarPedido() {
		return super.mostrarPedido() + "\nRecheio: " + this.tipoRecheio;
	}

}
