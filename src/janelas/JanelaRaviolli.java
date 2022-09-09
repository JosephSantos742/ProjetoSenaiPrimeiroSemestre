package janelas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import classes.Capeletti;
import classes.Massas;
import classes.Raviolli;

public class JanelaRaviolli extends JDialog {
	private Font fTitulo;
	private Color corFundo;
	private Icon iconSalvar, iconCancelar;
	private ImageIcon logo;
	private List<Massas> massas;
	private JLabel jlTipoMassa, jlSaborMassa, jlPeso, jlTipoRecheio, jlMolho, jlLogo;
	private String [] saborMassa = {"Tradicional", "Espinafre", "Integral"};
	private String [] peso = {"500gr", "1kg"};
	private String [] tipoRecheio = {"Três Queijos", "Frango", "Ricota com Nozes", 
			"Carne", "Funghi", "Mussarela de Búfala e Raspas de Limão",
			"Brie e Damasco", "Queijo Emmental com Abacaxi Caramelizado"};
	private String [] molho = {"Sem Molho","Bechamel", "Sugo", "Ragú de Linguiça","Gorgonzola","Bolonhesa","Pesto"};
	private JComboBox<String> jcbSaborMassa, jcbPeso, jcbTipoRecheio, jcbMolho;
	private JButton jbSalvar, jbCancelar;
	
	public JanelaRaviolli(List<Massas> massas, Frame owner, String title) {
		super(owner, title);
		this.massas = massas;
		setSize(600, 350);
		setLayout(null);
		URL caminhoIcone = getClass().getResource("/imagens/pasta.png");
		Image icone = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
		this.setIconImage(icone);
		corFundo = new Color(248,243,233);
		getContentPane().setBackground(corFundo);
		setLocationRelativeTo(null);
		componentes();
		eventos();
	}

	private void componentes() {
		iconSalvar = new ImageIcon(getClass().getResource("/imagens/salvar.png"));
		iconCancelar = new ImageIcon(getClass().getResource("/imagens/cancelar.png"));
		logo = new ImageIcon(getClass().getResource("/imagens/logotipo.png"));
		jlLogo = new JLabel(logo);
		fTitulo = new Font("Lucida Calligraphy", Font.BOLD, 30);
		jlTipoMassa = new JLabel("Raviolli");
		jlTipoMassa.setFont(fTitulo);
		jlSaborMassa = new JLabel("Sabor da Massa: ");
		jcbSaborMassa = new JComboBox<String>(saborMassa);
		jcbSaborMassa.setBackground(Color.white);
		jlPeso = new JLabel("Peso: ");
		jcbPeso = new JComboBox<String>(peso);
		jcbPeso.setBackground(Color.white);
		jlTipoRecheio = new JLabel("Recheio: ");
		jcbTipoRecheio = new JComboBox<String>(tipoRecheio);
		jcbTipoRecheio.setBackground(Color.white);
		jlMolho = new JLabel("Molho: ");
		jcbMolho = new JComboBox<String>(molho);
		jcbMolho.setBackground(Color.white);
		jbSalvar = new JButton("Salvar", iconSalvar);
		jbSalvar.setBackground(Color.white);
		jbCancelar = new JButton("Cancelar", iconCancelar);
		jbCancelar.setBackground(Color.white);
				
		add(jlTipoMassa);
		add(jlSaborMassa);
		add(jcbSaborMassa);
		add(jlPeso);
		add(jcbPeso);
		add(jlTipoRecheio);
		add(jcbTipoRecheio);
		add(jlMolho);
		add(jcbMolho);
		add(jbSalvar);
		add(jbCancelar);
		add(jlLogo);
		
		jlTipoMassa.setBounds(150, 20, 200, 30);
		jlSaborMassa.setBounds(10, 80, 100, 20);
		jcbSaborMassa.setBounds(110, 80, 120, 20);
		jlPeso.setBounds(40, 110, 100, 20);
		jcbPeso.setBounds(110, 110, 120, 20);
		jlMolho.setBounds(30, 140, 100, 20);
		jcbMolho.setBounds(110, 140, 120, 20);
		jlTipoRecheio.setBounds(40, 170, 100, 20);
		jcbTipoRecheio.setBounds(110, 170, 260, 20);
		jbSalvar.setBounds(30, 220, 125, 30);
		jbCancelar.setBounds(175, 220, 125, 30);
		jlLogo.setBounds(350, 55, 225, 225);
		
	}

	private void eventos() {
		jbCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		jbSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

					String tipoMassa, saborMassa, molho, peso, tipoRecheio;
					
					tipoMassa = jlTipoMassa.getText();
					saborMassa = (String) jcbSaborMassa.getSelectedItem();
					peso = (String) jcbPeso.getSelectedItem();
					molho = (String) jcbMolho.getSelectedItem();
					tipoRecheio = (String) jcbTipoRecheio.getSelectedItem();
					
					new Raviolli(tipoMassa, saborMassa, peso, molho, tipoRecheio);
									
					massas.add(new Raviolli(tipoMassa, saborMassa, peso, molho, tipoRecheio));
					dispose();
			}
		});
	}		
}
