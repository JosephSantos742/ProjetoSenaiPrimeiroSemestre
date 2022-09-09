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

public class JanelaCapeletti extends JDialog {
	private Font fTitulo;
	private Color corFundo;
	private Icon iconSalvar, iconCancelar;
	private ImageIcon logo;
	private List<Massas> massas;
	private JLabel jlTipoMassa, jlSaborMassa, jlPeso, jlTipoRecheio, jlMolho, jlLogo;
	private String [] saborMassa = {"Tradicional", "Espinafre", "Integral"};
	private String [] peso = {"500gr", "1kg"};
	private String [] tipoRecheio = {"Três Queijos", "Carne"};
	private String [] molho = {"Sem Molho","Bechamel", "Sugo", "Ragú de Linguiça","Gorgonzola","Bolonhesa","Pesto"};
	private JComboBox<String> jcbSaborMassa, jcbPeso, jcbTipoRecheio, jcbMolho;
	private JButton jbSalvar, jbCancelar;
	
	public JanelaCapeletti(List<Massas> massas, Frame owner, String title) {
		super(owner, title);
		this.massas = massas;
		setSize(550, 375);
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
		jlTipoMassa = new JLabel("Capeletti");
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
		jcbTipoRecheio.setBounds(110, 170, 150, 20);
		jbSalvar.setBounds(30, 220, 125, 30);
		jbCancelar.setBounds(175, 220, 125, 30);
		jlLogo.setBounds(300, 55, 225, 225);
		
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
					
					new Capeletti(tipoMassa, saborMassa, peso, molho, tipoRecheio);
									
					massas.add(new Capeletti(tipoMassa, saborMassa, peso, molho, tipoRecheio));
					dispose();
			}
		});
	}		
}
