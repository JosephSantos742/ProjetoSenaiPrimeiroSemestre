package janelas;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import classes.Cliente;
import classes.Pedido;
import telas.TelaMassas;
import telas.TelaNovoPedido;

public class JanelaCliente extends JDialog {
	private Icon iconConfirmar, iconCancelar;
	private JLabel jlNome, jlEndereco, jlNumeroEndereco, jlBairro, jlComplemento, jlTelefone, jlDataEntrega;
	private JTextField jtfNome, jtfEndereco, jtfNumeroEndereco, jtfBairro, jtfComplemento;
	private JFormattedTextField jftDataEntrega, jftTelefone;
	private JButton jbIniciar, jbCancelar;
	private List<Cliente> clientes;
	private List<Pedido> pedidos;
	

	public JanelaCliente(List<Cliente> clientes, List<Pedido> pedidos, Frame owner, String title) {
		super(owner, title);
		this.clientes = clientes;
		this.pedidos = pedidos;
		setSize(400, 275);
		setLayout(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		URL caminhoIcone = getClass().getResource("/imagens/pasta.png");
		Image icone = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
		this.setIconImage(icone);
		setLocationRelativeTo(null);
		componentes();
		eventos();
	}

	private void componentes() {
		iconConfirmar = new ImageIcon(getClass().getResource("/imagens/confirmar.png"));
		iconCancelar = new ImageIcon(getClass().getResource("/imagens/cancelar.png"));
		
		MaskFormatter mascaraData = null;
		MaskFormatter mascaraTelefone = null;
		
		try {
			mascaraData = new MaskFormatter("##/##/####");
			mascaraTelefone = new MaskFormatter("(##)#####-####");
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro na formatação");
		}
		 				
		jlNome = new JLabel("Nome: ");
		jlEndereco = new JLabel("Endereço: ");
		jlNumeroEndereco = new JLabel("Nº: ");
		jlBairro = new JLabel("Bairro: ");
		jlComplemento = new JLabel("Complemento: ");
		jlTelefone = new JLabel("Telefone: ");
		jlDataEntrega = new JLabel("Data de Entrega: ");
		jtfNome = new JTextField();
		jtfEndereco = new JTextField();
		jtfNumeroEndereco = new JTextField();
		jtfBairro = new JTextField();
		jtfComplemento = new JTextField();
		jftTelefone = new JFormattedTextField(mascaraTelefone);
		jftDataEntrega = new JFormattedTextField(mascaraData);
		jbIniciar = new JButton("Iniciar", iconConfirmar);
		jbCancelar = new JButton("Cancelar", iconCancelar);
		
			
		add(jlNome);
		add(jtfNome);
		add(jlEndereco);
		add(jtfEndereco);
		add(jlNumeroEndereco);
		add(jtfNumeroEndereco);
		add(jlBairro);
		add(jtfBairro);
		add(jlComplemento);
		add(jtfComplemento);
		add(jlTelefone);
		add(jftTelefone);
		add(jlDataEntrega);
		add(jftDataEntrega);
		add(jbIniciar);
		add(jbCancelar);
		
		jlNome.setBounds(10, 20, 60, 20);
		jtfNome.setBounds(50, 20, 300, 20);
		jlEndereco.setBounds(10, 50, 60, 20);
		jtfEndereco.setBounds(70, 50, 200, 20);
		jlNumeroEndereco.setBounds(280, 50, 50, 20);
		jtfNumeroEndereco.setBounds(300, 50, 50, 20);
		jlBairro.setBounds(10, 80, 50, 20);
		jtfBairro.setBounds(55, 80, 215, 20);
		jlComplemento.setBounds(10, 110, 100, 20);
		jtfComplemento.setBounds(100, 110, 170, 20);
		jlTelefone.setBounds(10, 140, 60, 20);
		jftTelefone.setBounds(70, 140, 100, 20);
		jlDataEntrega.setBounds(180, 140, 100, 20);
		jftDataEntrega.setBounds(280, 140, 70, 20);
		jbIniciar.setBounds(60, 180, 115, 25);
		jbCancelar.setBounds(200, 180, 115, 25);
		
	}

	private void eventos() {
		jbIniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if (!jtfNome.getText().isEmpty() &&
					!jtfEndereco.getText().isEmpty() &&
					!jtfNumeroEndereco.getText().isEmpty() &&
					!jtfBairro.getText().isEmpty() &&
					!jftTelefone.getText().isEmpty() &&
					!jftDataEntrega.getText().isEmpty()) {
					
					String nome, endereco, bairro, complemento, telefone, dataEntrega;
					int numeroEndereco = 0;
					
					nome = jtfNome.getText();
					endereco = jtfEndereco.getText();
					
					try {
						numeroEndereco = Integer.parseInt(jtfNumeroEndereco.getText());	
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Preencha somente com números.","Cadastro",JOptionPane.ERROR_MESSAGE);}
					
					bairro = jtfBairro.getText();
					complemento = jtfComplemento.getText();
					telefone = jftTelefone.getText();
					dataEntrega = jftDataEntrega.getText();
					
					new Cliente(nome, endereco, numeroEndereco, bairro, complemento, telefone, dataEntrega);
					
					clientes.add(new Cliente(nome, endereco, numeroEndereco, bairro, complemento, telefone, dataEntrega));
					
					TelaNovoPedido pedido = new TelaNovoPedido(clientes, pedidos, "Ma Che Sapore - Novo Pedido");
					pedido.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios.", "Cadastro", JOptionPane.ERROR_MESSAGE);
				}								
			}
		});
		
		jbCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaMassas inicio = new TelaMassas(clientes, getTitle());
				inicio.setVisible(true);
				dispose();
			}
		});
	}
	
}
