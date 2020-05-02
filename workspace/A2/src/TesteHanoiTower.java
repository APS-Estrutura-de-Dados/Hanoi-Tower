import javax.swing.JFrame;
import javax.swing.JPanel;

public class TesteHanoiTower {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Mostrar Botão de Fechar do Sistema
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Tamanho da Janela

		JPanel panel = new JPanel();

		frame.add(panel);

		frame.setVisible(true); // Tornar Painel visível
	}

}
