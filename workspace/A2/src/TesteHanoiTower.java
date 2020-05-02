import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TesteHanoiTower {

	// Para armazenar a resolucao da maquina
	public static Toolkit toolkit = Toolkit.getDefaultToolkit();
	public static Dimension dimension = toolkit.getScreenSize();

	// Para mostrar o cursor do mouse diferente para clicar nas coisas
	static Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	public static void main(String[] args) {

		// Para armazenar a resolucao da maquina
		int x = dimension.width;
		int y = dimension.height;

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Mostrar Botão de Fechar do Sistema
		frame.setExtendedState(6); // Deixa a janela em tela cheia
		frame.setLayout(null);

		// TOWERS -----------------

		JPanel t1 = new JPanel();
		t1.setBackground(Color.YELLOW);
		t1.setBounds(50, 0, 100, 100);
		// frame.add(t1);

		JPanel t3 = new JPanel();
		t3.setBackground(Color.RED);
		t3.setBounds(250, 0, 100, 100);
		// frame.add(t3);

		JPanel t2 = new JPanel();
		t2.setBackground(Color.ORANGE);
		t2.setBounds(150, 0, 100, 100);
		// frame.add(t2);

		// BASE A -----------------

		JPanel baseA = new JPanel();
		baseA.setBackground(Color.BLACK);
		baseA.setBounds(x / 2 - (250 + 5), y - 450, 10, 200);
		frame.add(baseA);

		JButton btnA = new JButton();
		btnA.setBackground(Color.WHITE);
		btnA.setCursor(cursor);
		btnA.setBounds(x / 2 - (250 + 80), y - 240, 160, 50);
		btnA.setFont(new Font("Felix Titling", Font.PLAIN, 15));
		btnA.setText("MOVE");
		frame.add(btnA);

		// BASE B -----------------

		JPanel baseB = new JPanel();
		baseB.setBackground(Color.BLACK);
		baseB.setBounds(x / 2 - (0 + 5), y - 450, 10, 200);
		frame.add(baseB);

		JButton btnB = new JButton();
		btnB.setBackground(Color.WHITE);
		btnB.setCursor(cursor);
		btnB.setBounds(x / 2 - (0 + 80), y - 240, 160, 50);
		btnB.setFont(new Font("Felix Titling", Font.PLAIN, 15));
		btnB.setText("MOVE");
		frame.add(btnB);

		// BASE C -----------------

		JPanel baseC = new JPanel();
		baseC.setBackground(Color.BLACK);
		baseC.setBounds(x / 2 + (250 + 5), y - 450, 10, 200);
		frame.add(baseC);

		JButton btnC = new JButton();
		btnC.setBackground(Color.WHITE);
		btnC.setCursor(cursor);
		btnC.setBounds(x / 2 + (250 - 70), y - 240, 160, 50);
		btnC.setFont(new Font("Felix Titling", Font.PLAIN, 15));
		btnC.setText("MOVE");
		frame.add(btnC);

		frame.setVisible(true); // Tornar Painel visível
	}

}
