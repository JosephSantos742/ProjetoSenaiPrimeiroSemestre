package arquivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JOptionPane;

import classes.Pedido;

public class EscreverLerArquivos {

	public void EscreverArquivo(List<Pedido> pedidos) {
		FileOutputStream saida;

		try {
			saida = new FileOutputStream("Pedido.bin");
			ObjectOutputStream objeto = new ObjectOutputStream(saida);
			objeto.writeObject(pedidos); 
			JOptionPane.showMessageDialog(null, "Gravado com sucesso.");
			objeto.close(); 
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrato.", "Ma Che Sapore - Massas Artesanais",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo corrompido.", "Ma Che Sapore - Massas Artesanais",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public List<Pedido> lerArquivo() {
		List<Pedido> pedidos = null;

		try {
			FileInputStream entrada = new FileInputStream("Pedido.bin");
			ObjectInputStream objeto = new ObjectInputStream(entrada);
			pedidos = (List<Pedido>) objeto.readObject();
			objeto.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrato.", "Ma Che Sapore - Massas Artesanais",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo corrompido.", "Ma Che Sapore - Massas Artesanais",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Classe nãoo encontrada.", "Ma Che Sapore - Massas Artesanais",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return pedidos;

	}
}
