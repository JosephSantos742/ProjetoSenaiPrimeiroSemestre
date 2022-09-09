package classes;

public class Cliente{
	private String nome;
	private String endereco;
	private int numeroEndereco;
	private String bairro;
	private String complemento;
	private String telefone;
	private String dataEntrega;

	public Cliente(String nome, String endereco, int numeroEndereco, String bairro, String complemento, String telefone,
			String dataEntrega) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.numeroEndereco = numeroEndereco;
		this.bairro = bairro;
		this.complemento = complemento;
		this.telefone = telefone;
		this.dataEntrega = dataEntrega;
	}	

	public String mostrarDados() {
		return  "Nome: " + this.nome +
				"\nEndereço: " + this.endereco + 
				"\nNº: " + this.numeroEndereco + 
				"\nBairro: " + this.bairro +
				"\nComplemento: " + this.complemento +
				"\nTelefone: " + this.telefone + 
				"\nData de Entrega: " + this.dataEntrega;
	}
}
