package classes;

public class Massas {
	protected String tipoMassa;
	protected String saborMassa;
	protected String peso;
	protected String molho;
	protected float valorTipoMassa;
	protected float valorSaborMassa;
	protected float valorPeso;
	protected float valorMolho;
	protected float valorTotal;
	protected String totalPedido;
	
	public Massas(String tipoMassa, String saborMassa, String peso, String molho) {
		super();
		this.tipoMassa = tipoMassa;
		this.saborMassa = saborMassa;
		this.peso = peso;
		this.molho = molho;
	}
	
	public float calcularTotal( ) {
		if (this.tipoMassa.equals("Canelloni")) {
			this.valorTipoMassa = 5;
		} else if (this.tipoMassa.equals("Capeletti")) {
			this.valorTipoMassa = 4;
		} else if (this.tipoMassa.equals("Raviolli")) {
			this.valorTipoMassa = 0;
		} else if (this.tipoMassa.equals("Rondelli")) {
			this.valorTipoMassa = 5;
		} else if (this.tipoMassa.equals("Talharim")) {
			this.valorTipoMassa = 0;
		}
		
		if (this.saborMassa.equals("Tradicional")) {
			this.valorSaborMassa = 10;
		} else if (this.saborMassa.equals("Espinafre")) {
			this.valorSaborMassa = 12;
		} else if (this.saborMassa.equals("Integral")) {
			this.valorSaborMassa = 14;
		}
		
		if (this.peso.equals("500gr")) {
			this.valorPeso = 0;
		} else if (this.peso.equals("1kg")) {
			this.valorPeso = 10;
		}
		
		if (this.molho.equals("Sem Molho")) {
			this.valorMolho = 0;
		} else if (this.molho.equals("Bechamel")) {
			this.valorMolho = 22;
		} else if (this.molho.equals("Sugo")) {
			this.valorMolho = 23;
		} else if (this.molho.equals("Ragú de Linguiça")) {
			this.valorMolho = 26;
		} else if (this.molho.equals("Gorgonzola")) {
			this.valorMolho = 28;
		} else if (this.molho.equals("Bolonhesa")) {
			this.valorMolho = 40;
		} else if (this.molho.equals("Pesto")) {
			this.valorMolho = 50;
		}
		
		return valorTotal = valorTipoMassa + valorSaborMassa + valorPeso + valorMolho;		
	}
	

	
	public String mostrarPedido() {
		return "Tipo de Massa: " + this.tipoMassa +
				"\nPeso: " + this.peso +
				"\nSabor da Massa: " + this.saborMassa +
				"\nMolho: " + this.molho;
	}
}
