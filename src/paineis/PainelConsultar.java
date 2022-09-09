package paineis;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import classes.Pedido;

public class PainelConsultar extends JPanel {
	private ImageIcon fundo;
	private List<Pedido> pedidos;
	private JLabel jlFundo, jlPesquisar, jlPedido;;
	private JTextField jtfPedido;
	private JButton jbPesquisar, jbTodos;
	private JTextArea jtaPesquisa;
	private JScrollPane jspPesquisa;
	private Font fonteTitulo, fonteSubtitulo, fonteBotao;

	public PainelConsultar(List<Pedido> pedidos) {
		super();
		this.pedidos = pedidos;
		setSize(900, 700);
		setLayout(null);
		componentes();
		eventos();
	}

	private void componentes() {
		fundo = new ImageIcon(getClass().getResource("/imagens/background.jpg"));
		jlFundo = new JLabel(fundo);
		fonteTitulo = new Font("Lucida Calligraphy", Font.BOLD, 40);
		fonteSubtitulo = new Font("Constantia", Font.BOLD, 15);
		fonteBotao = new Font("Monotype Corsiva", Font.BOLD, 30);
		jlPesquisar = new JLabel("Pesquisar");
		jlPesquisar.setFont(fonteTitulo);
		jlPedido = new JLabel("Digite o numero do pedido");
		jlPedido.setFont(fonteSubtitulo);
		jtfPedido = new JTextField();
		jbPesquisar = new JButton("Pesquisar");
		jbPesquisar.setFont(fonteBotao);
		jbTodos = new JButton("Exibir todos");
		jtaPesquisa = new JTextArea();
		jtaPesquisa.setEditable(false);
		jspPesquisa = new JScrollPane(jtaPesquisa);

		add(jlPesquisar);
		add(jlPedido);
		add(jtfPedido);
		add(jbPesquisar);
		add(jbTodos);
		add(jspPesquisa);
		add(jlFundo);

		jlPesquisar.setBounds(325, 10, 250, 40);
		jlPedido.setBounds(345, 60, 250, 20);
		jtfPedido.setBounds(400, 90, 75, 25);
		jbPesquisar.setBounds(350, 130, 175, 40);
		jbTodos.setBounds(675, 170, 125, 20);
		jspPesquisa.setBounds(100, 200, 700, 425);
		jlFundo.setBounds(0, 0, 900, 700);
	}

	private void eventos() {
		jbPesquisar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/**/
				boolean achou = false;
				for (Pedido pedido : pedidos) {
					if (pedido.getNumeroPedido() == Integer.parseInt(jtfPedido.getText())) {
						jtfPedido.setText("");
						jtaPesquisa.setText("");
						jtaPesquisa.append(pedido.mostrarPedido());												
						achou = true;
						break;
					} 					
				}
				
				if (!achou) {
					JOptionPane.showMessageDialog(null, "Pedido não encontrato", "Pesquisa", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
		
		jbTodos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtaPesquisa.setText("\t************PEDIDOS************\n");
				for (Pedido pedido: pedidos) {					
					jtaPesquisa.append(pedido.mostrarPedido());
				}				
			}
		});
	}

}
