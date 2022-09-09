package telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import arquivos.EscreverLerArquivos;
import classes.Cliente;
import classes.Massas;
import classes.Pedido;
import janelas.JanelaCanelloni;
import janelas.JanelaCapeletti;
import janelas.JanelaCliente;
import janelas.JanelaRaviolli;
import janelas.JanelaRondelli;
import janelas.JanelaTalharim;
import paineis.PainelConsultar;

public class TelaNovoPedido extends JFrame {
	private Font fonteTitulo, fonteSubtitulo, fonteBotao, fonteTotal, fonteCaixaTexto, fonteDadosClientes;
	private ImageIcon fundo;
	private Icon iconCarrinho, iconSalvar, iconLimpar, iconUsuario, iconeLogo, iconeSenai;
	private JMenuBar jmbBarra;
	private JMenu jmPedido, jmInicio, jmSobre, jmAjuda;
	private JMenuItem jmiNovoPedido, jmiConsultarPedido, jmiTelaInicial, jmiSair, jmiSobre, jmiCredito, jmiTutorial, jmiContato;
	private Container contentPane;
	private JLabel jlNovoPedido, jlMassas, jlFundo, jlUsuario, jlTotal;
	private JButton jbCanelloni, jbCapeletti, jbRaviolli, jbRondelli, jbTalharim, jbCarrinho, jbSalvar, jbLimpar;
	private JTextArea jtaMostrar, jtaTotal, jtaDadosClientes;
	private List<Massas> massas = new ArrayList<>();
	private List<Cliente> clientes;
	private List<Pedido> pedidos;
	private EscreverLerArquivos arquivo = new EscreverLerArquivos();

	public TelaNovoPedido(List<Cliente> clientes, List<Pedido> pedidos, String title) throws HeadlessException {
		super(title);
		this.clientes = clientes;
		this.pedidos = pedidos;
		setSize(900, 740);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		URL caminhoIcone = getClass().getResource("/imagens/pasta.png");
		Image icone = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
		this.setIconImage(icone);
		setLocationRelativeTo(null);
		componentes();
		eventos();
	}

	private void componentes() {
		jmbBarra = new JMenuBar();
		setJMenuBar(jmbBarra);
		jmInicio = new JMenu("Início");
		jmiTelaInicial = new JMenuItem("Tela Inicial");
		jmiSair = new JMenuItem("Sair");
		jmPedido = new JMenu("Pedido");
		jmiNovoPedido = new JMenuItem("Novo");
		jmiConsultarPedido = new JMenuItem("Consultar");
		jmSobre = new JMenu("Sobre");
		jmiSobre = new JMenuItem("Quem somos");
		jmiCredito = new JMenuItem("Créditos");
		jmAjuda = new JMenu("Ajuda");
		jmiTutorial = new JMenuItem("Como usar");
		jmiContato = new JMenuItem("Contato");

		jmbBarra.add(jmInicio);
		jmbBarra.add(jmPedido);
		jmbBarra.add(jmSobre);
		jmbBarra.add(jmAjuda);
		
		jmInicio.add(jmiTelaInicial);
		jmInicio.add(jmiSair);

		jmPedido.add(jmiNovoPedido);
		jmPedido.add(jmiConsultarPedido);
		
		jmSobre.add(jmiSobre);
		jmSobre.add(jmiCredito);
		
		jmAjuda.add(jmiTutorial);
		jmAjuda.add(jmiContato);
				
		iconCarrinho = new ImageIcon(getClass().getResource("/imagens/carrinho.png"));
		iconSalvar = new ImageIcon(getClass().getResource("/imagens/salvar.png"));
		iconLimpar = new ImageIcon(getClass().getResource("/imagens/limpar.png"));
		iconUsuario = new ImageIcon(getClass().getResource("/imagens/user.png"));
		fundo = new ImageIcon(getClass().getResource("/imagens/background.jpg"));
		iconeLogo = new ImageIcon(getClass().getResource("/imagens/logotipo.png"));
		iconeSenai = new ImageIcon(getClass().getResource("/imagens/logoSenai.png"));
		fonteTitulo = new Font("Lucida Calligraphy", Font.BOLD, 40);
		fonteSubtitulo = new Font("Lucida Calligraphy", Font.ITALIC, 25);
		fonteTotal = new Font("Constantia", Font.ITALIC, 20);
		fonteCaixaTexto = new Font("Arial", Font.BOLD, 25);
		fonteBotao = new Font("Monotype Corsiva", Font.BOLD, 30);
		fonteDadosClientes = new Font("Sans Serif", Font.PLAIN, 15);
		Border bordaPreta = BorderFactory.createLineBorder(Color.black, 1);		
		
		contentPane = getContentPane();
		jlFundo = new JLabel(fundo);
		jlNovoPedido = new JLabel("Novo Pedido");
		jlNovoPedido.setFont(fonteTitulo);
		jlUsuario = new JLabel(iconUsuario);
		jlMassas = new JLabel("Massas");
		jlMassas.setFont(fonteSubtitulo);
		jbCanelloni = new JButton("Canelloni");
		jbCanelloni.setFont(fonteBotao);
		jbCapeletti = new JButton("Capeletti");
		jbCapeletti.setFont(fonteBotao);
		jbRaviolli = new JButton("Raviolli");
		jbRaviolli.setFont(fonteBotao);
		jbRondelli = new JButton("Rondelli");
		jbRondelli.setFont(fonteBotao);
		jbTalharim = new JButton("Talharim");
		jbTalharim.setFont(fonteBotao);
		jbCarrinho = new JButton("  Carrinho", iconCarrinho);
		jtaMostrar = new JTextArea();
		jtaMostrar.setBorder(bordaPreta);
		jtaMostrar.setEditable(false);
		jlTotal = new JLabel("Total");
		jlTotal.setFont(fonteTotal);
		jtaTotal = new JTextArea();
		jtaTotal.setBorder(bordaPreta);
		jtaTotal.setEditable(false);
		jtaDadosClientes = new JTextArea();
		jtaDadosClientes.setBorder(bordaPreta);
		jtaDadosClientes.setEditable(false);
		jtaDadosClientes.setFont(fonteDadosClientes);
		jbSalvar = new JButton(" Salvar", iconSalvar);
		jbSalvar.setFont(fonteCaixaTexto);
		jbLimpar = new JButton("Limpar", iconLimpar);
		jbLimpar.setFont(fonteCaixaTexto);
		jtaTotal.setFont(fonteCaixaTexto);

		add(jlNovoPedido);
		add(jlUsuario);
		add(jtaDadosClientes);
		add(jlMassas);
		add(jbCanelloni);
		add(jbCapeletti);
		add(jbRaviolli);
		add(jbRondelli);
		add(jbTalharim);
		add(jbCarrinho);
		add(jtaMostrar);
		add(jlTotal);
		add(jtaTotal);
		add(jbSalvar);
		add(jbLimpar);
		add(jlFundo);

		jlNovoPedido.setBounds(300, 20, 300, 40);
		jlUsuario.setBounds(115, 100, 128, 128);
		jtaDadosClientes.setBounds(325, 100, 330, 160);
		jlMassas.setBounds(125, 290, 100, 25);
		jbCanelloni.setBounds(75, 330, 200, 50);
		jbCapeletti.setBounds(75, 400, 200, 50);
		jbRaviolli.setBounds(75, 470, 200, 50);
		jbRondelli.setBounds(75, 540, 200, 50);
		jbTalharim.setBounds(75, 610, 200, 50);
		jbCarrinho.setBounds(325, 290, 120, 25);
		jlTotal.setBounds(575, 270, 100, 25);
		jtaTotal.setBounds(545, 290, 110, 30);
		jtaMostrar.setBounds(325, 330, 330, 330);
		jbSalvar.setBounds(700, 415, 150, 50);
		jbLimpar.setBounds(700, 490, 150, 50);
		jlFundo.setBounds(0, 0, 900, 700);		

		
		for (Cliente cliente : clientes) {
			jtaDadosClientes.append(cliente.mostrarDados());
		}						

	}

	private void eventos() {

		jbCarrinho.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtaMostrar.setText("");
				for (Massas massa : massas) {
					jtaMostrar.append(massa.mostrarPedido());
					jtaMostrar.append("\nTotal: R$ " + massa.calcularTotal() + "0" + "\n\n");

					if (massas.size() == 1) {
						jtaTotal.setText("");
						jtaTotal.append("R$" + (massas.get(0).calcularTotal()) + "0");
					} else if (massas.size() == 2) {
						jtaTotal.setText("");
						jtaTotal.append(
								"R$" + ((massas.get(0).calcularTotal()) + (massas.get(1).calcularTotal())) + "0");
					} else if (massas.size() == 3) {
						jtaTotal.setText("");
						jtaTotal.append("R$" + ((massas.get(0).calcularTotal()) + (massas.get(1).calcularTotal())
								+ (massas.get(2).calcularTotal())) + "0");
					}
				}
			}
		});
		
		jbSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String cliente, pedido, total;
				int numeroPedido;
				;

				cliente = jtaDadosClientes.getText();
				pedido = jtaMostrar.getText();
				total = jtaTotal.getText();
				numeroPedido = (int) (Math.random() * 100);	
				
				if (!jtaMostrar.getText().isEmpty()) {
					int resposta = JOptionPane.showConfirmDialog(null, "Deseja finalizar o pedido?",
							"Ma Che Sapore - Massas Artesanais", JOptionPane.YES_NO_OPTION);
					if (resposta == JOptionPane.YES_OPTION) {
						pedidos.add(new Pedido(cliente, pedido, total, numeroPedido));
						arquivo.EscreverArquivo(pedidos);
						JOptionPane.showMessageDialog(null, "Pedido Nº: " + numeroPedido + " gerado com sucesso.");
						
						jtaDadosClientes.setText("");
						jtaMostrar.setText("");
						jtaTotal.setText("");
						
						clientes.clear();
						dispose();
						TelaMassas inicio = new TelaMassas(clientes, getTitle());
						inicio.setVisible(true);
					} 							
				} else {
					JOptionPane.showMessageDialog(null, "Insira os itens clicando no carrinho, e então salve o pedido");
				}
				
				
			}
		});
		
		jbLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtaMostrar.setText("");
				jtaTotal.setText("");

			}
		});

		jbCanelloni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (massas.size() <= 2) {
					JanelaCanelloni canelloni = new JanelaCanelloni(massas, null, "Canelloni");
					canelloni.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Limite de produtos excedidos", "Novo Pedido",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		jbCapeletti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (massas.size() <= 2) {
					JanelaCapeletti capeletti = new JanelaCapeletti(massas, null, "Capeletti");
					capeletti.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Limite de produtos excedidos", "Novo Pedido",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		jbRaviolli.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (massas.size() <= 2) {
					JanelaRaviolli raviolli = new JanelaRaviolli(massas, null, "Raviolli");
					raviolli.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Limite de produtos excedidos", "Novo Pedido",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		jbRondelli.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (massas.size() <= 2) {
					JanelaRondelli rondelli = new JanelaRondelli(massas, null, "Rondelli");
					rondelli.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Limite de produtos excedidos", "Novo Pedido",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		jbTalharim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (massas.size() <= 2) {
					JanelaTalharim talharim = new JanelaTalharim(massas, null, "Talharim");
					talharim.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Limite de produtos excedidos", "Novo Pedido",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		jmiNovoPedido.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JanelaCliente cliente = new JanelaCliente(clientes, pedidos, null, "Cadastro cliente");
				cliente.setVisible(true);
				
				clientes.clear();
				
				dispose();
			}
		});

		jmiConsultarPedido.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {								
				PainelConsultar consultar = new PainelConsultar(pedidos);
				contentPane.removeAll();
				contentPane.add(consultar);
				contentPane.validate();
	
				jtaDadosClientes.setText("");
				jtaMostrar.setText("");
				jtaTotal.setText("");				
			}					
		});
		
		jmiTelaInicial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaMassas inicio = new TelaMassas(clientes, getTitle());
				dispose();
				inicio.setVisible(true);
			}
		});
		
		jmiSobre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "A Ma Che Sapore tem como seu carro chefe a fabricação e venda de massas artesanais congeladas,"
						+ "\nassim você pode manter aquele estoque no seu freezer, para te salvar nos momentos em que precisa\nser ágil e surpreender."
						+ "\nO fundador dessa ideia ousada é o Fernando, a cada dia foi aprimorando as receitas, melhorandos os \ningredientes e as medidas,"
						+ "e buscando produtos com cada vez mais qualidade, atê chegar no ponto \nperfeito da massa que conhecemos hoje.", "Ma Che Sapore - Massas Artesanais", JOptionPane.INFORMATION_MESSAGE, iconeLogo);
				
			}
		});
		
		jmiCredito.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Escola SENAI Prof. Dr. Euryclides de Jesus Zerbini\n"
						+ "Curso Desenvolvimento de Sistemas\n"
						+ "Turma: 1DS-A\n"
						+ "Alunos: Joseph Santos Pereira\n"
						+ "               Jayron Damasceno Tavares\n"
						+ "               Gabriel Ferreira da Silva\n"
						+ "               Alice Michelli da Silva", "Créditos", JOptionPane.INFORMATION_MESSAGE, iconeSenai);
				
			}
		});
		
		jmiTutorial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "1 - Adicionar Pedido\n"
						+ "  - Clicar na opção de Pedido, Novo.\n"
						+ "  - Cadastrar os dados do cliente.\n"
						+ "  - Selecionar a massa desejada e preencher com os itens do pedido.\n"
						+ "  - Clicar em carrinho adicionar os produtos.\n"
						+ "  - Clicar em salvar, confirmar a operação.\n"
						+ "  - Pronto, pedido gerado.\n\n"
						+ "2 - Consultar Pedido\n"
						+ "  - Clicar na opção de Pedido, Consultar.\n"
						+ "  - Digitar no campo o número do pedido gerado.\n"
						+ "  - Pronto, consulta realizada.", "Ajuda", JOptionPane.INFORMATION_MESSAGE);				
			}
		});
		
		jmiContato.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Para mais dúvidas, sugestões.\n\n"
						+ "Telefone: (19) 98146-0222\n"
						+ "E-mail: josephsantos742@gmail.com", "Contato" , JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		jmiSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});

	}

}
