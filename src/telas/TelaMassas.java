package telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import arquivos.EscreverLerArquivos;
import classes.Cliente;
import classes.Pedido;
import janelas.JanelaCliente;
import paineis.PainelConsultar;

public class TelaMassas extends JFrame {
	private JMenuBar jmbBarra;
	private ImageIcon ImagemFundo;
	private Icon iconeLogo, iconeSenai;
	private JLabel jlFundo;
	private JMenu jmInicio, jmPedido, jmSobre, jmAjuda;
	private JMenuItem jmiTelaInicial, jmiSair, jmiNovoPedido, jmiConsultarPedido, jmiSobre, jmiCredito, jmiTutorial, jmiContato;
	private Container contentPane;
	private List<Cliente> clientes = new ArrayList<>();
	private List<Pedido> pedidos = new ArrayList<>();
	private EscreverLerArquivos arquivo = new EscreverLerArquivos();

	public TelaMassas(List<Cliente> clientes, String title) throws HeadlessException {
		super(title);
		setSize(900, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		URL caminhoIcone = getClass().getResource("/imagens/pasta.png");
		Image icone = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
		this.setIconImage(icone);
		getContentPane().setBackground(Color.white);
		componentes();
		eventos();
		lerArquivo();
	}

	private void lerArquivo() {
		if (arquivo.lerArquivo() != null) {
			pedidos = arquivo.lerArquivo();
		}

	}

	private void componentes() {
		ImagemFundo = new ImageIcon(getClass().getResource("/imagens/fundoPrincipal.png"));
		iconeLogo = new ImageIcon(getClass().getResource("/imagens/logotipo.png"));
		iconeSenai = new ImageIcon(getClass().getResource("/imagens/logoSenai.png"));
		jlFundo = new JLabel(ImagemFundo);
		contentPane = getContentPane();
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

		add(jlFundo);

		jlFundo.setBounds(0, 0, 900, 700);

	}

	private void eventos() {
		
		jmiTelaInicial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaMassas inicio = new TelaMassas(clientes, getTitle());
				dispose();
				inicio.setVisible(true);
			}
		});

		jmiNovoPedido.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JanelaCliente cliente = new JanelaCliente(clientes, pedidos, null, "Cadastro cliente");
				cliente.setVisible(true);
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
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja salvar os dados antes de sair?",
						"Ma Che Sapore - Massas Artesanais", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					arquivo.EscreverArquivo(pedidos);
				}
				System.exit(0);
			}
		});

	}

}
