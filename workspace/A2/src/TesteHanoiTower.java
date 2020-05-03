import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TesteHanoiTower {

	// Para armazenar a resolucao da maquina
	public static Toolkit toolkit = Toolkit.getDefaultToolkit();
	public static Dimension dimension = toolkit.getScreenSize();
	public static int x;
	public static int y;

	// Para mostrar o cursor do mouse diferente para clicar nas coisas
	static Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	// Para arredondar as bordas dos JPanels
	static LineBorder line1 = new LineBorder(Color.YELLOW, 50, true);
	static LineBorder line2 = new LineBorder(Color.ORANGE, 50, true);
	static LineBorder line3 = new LineBorder(Color.RED, 50, true);

	// Variaveis para controlar o click dos botoes
	static boolean clickA = false;
	static boolean clickB = false;
	static boolean clickC = false;

	// Componentes gráficos
	static JPanel t1, t2, t3;
	static JPanel baseA, baseB, baseC;
	static JButton btnA, btnB, btnC;

	public static void main(String[] args) {

		// Para armazenar a resolucao da maquina
		x = dimension.width;
		y = dimension.height;

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Mostrar Botão de Fechar do Sistema
		frame.setExtendedState(6); // Deixa a janela em tela cheia
		frame.setTitle("Hanoi Tower");
		frame.setLayout(null);

		// TOWERS -----------------

		t1 = new JPanel();
		t1.setBorder(line1);
		t1.setOpaque(false);

		t2 = new JPanel();
		t2.setBorder(line2);
		t2.setOpaque(false);

		t3 = new JPanel();
		t3.setBorder(line3);
		t3.setOpaque(false);

		t1.setBounds(x / 2 - (250 + 55), y - (450 - 20), 110, 60);
		t2.setBounds(x / 2 - (250 + 65), y - (450 - 80), 130, 60);
		t3.setBounds(x / 2 - (250 + 75), y - (450 - 140), 150, 60);

		// t1.setBounds(x / 2 - (0 + 55), y - (450 - 20), 110, 60);
		// t2.setBounds(x / 2 - (0 + 65), y - (450 - 80), 130, 60);
		// t3.setBounds(x / 2 - (0 + 75), y - (450 - 140), 150, 60);

		// t1.setBounds(x / 2 + (260 - 55), y - (450 - 20), 110, 60);
		// t2.setBounds(x / 2 + (260 - 65), y - (450 - 80), 130, 60);
		// t3.setBounds(x / 2 + (260 - 75), y - (450 - 140), 150, 60);

		frame.add(t1);
		frame.add(t2);
		frame.add(t3);

		// BASE A -----------------

		baseA = new JPanel();
		baseA.setBackground(Color.BLACK);
		baseA.setBounds(x / 2 - (250 + 5), y - 450, 10, 200);
		frame.add(baseA);

		btnA = new JButton();
		btnA.setBackground(Color.WHITE);
		btnA.setCursor(cursor);
		btnA.setBounds(x / 2 - (250 + 80), y - 240, 160, 50);
		btnA.setFont(new Font("Felix Titling", Font.PLAIN, 15));
		btnA.setText("A - MOVE");
		frame.add(btnA);

		// BASE B -----------------

		baseB = new JPanel();
		baseB.setBackground(Color.BLACK);
		baseB.setBounds(x / 2 - (0 + 5), y - 450, 10, 200);
		frame.add(baseB);

		btnB = new JButton();
		btnB.setBackground(Color.WHITE);
		btnB.setCursor(cursor);
		btnB.setBounds(x / 2 - (0 + 80), y - 240, 160, 50);
		btnB.setFont(new Font("Felix Titling", Font.PLAIN, 15));
		btnB.setText("B - MOVE");
		frame.add(btnB);

		// BASE C -----------------

		baseC = new JPanel();
		baseC.setBackground(Color.BLACK);
		baseC.setBounds(x / 2 + (250 + 5), y - 450, 10, 200);
		frame.add(baseC);

		btnC = new JButton();
		btnC.setBackground(Color.WHITE);
		btnC.setCursor(cursor);
		btnC.setBounds(x / 2 + (250 - 70), y - 240, 160, 50);
		btnC.setFont(new Font("Felix Titling", Font.PLAIN, 15));
		btnC.setText("C - MOVE");
		frame.add(btnC);

		// Controle dos clicks
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!clickA) {
					btnA.setText("Cancelar");
					clickA = true;

					if (clickB) {
						// Move("B", "A");
					} else if (clickC) {
						// Move("C", "A");
					}

				} else {
					btnA.setText("Move A");
					clickA = false;
				}
			}
		});

		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!clickB) {
					btnB.setText("Cancelar");
					clickB = true;

					if (clickA) {
						// Move("A", "B");
					} else if (clickC) {
						// Move("C", "B");
					}

				} else {
					btnB.setText("Move B");
					clickB = false;
				}
			}
		});

		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!clickC) {
					btnC.setText("Cancelar");
					clickC = true;

					if (clickA) {
						// Move("A", "C");
					} else if (clickB) {
						// Move("B", "C");
					}

				} else {
					btnC.setText("Move C");
					clickC = false;
				}
			}
		});

		Atualizar();

		frame.setVisible(true); // Tornar Painel visível
	}

	// Reseta o conteúdo dos botões após mover um Disco
	private static void ZerarBotoes() {

		btnA.setText("Move A");
		clickA = false;
		btnB.setText("Move B");
		clickB = false;
		btnC.setText("Move C");
		clickC = false;

	}

	// Identifica quais Discos devem aparecer no Pino A
	private static void FillPinA() {

		HanoiTower hanoiTower = new HanoiTower();
		String pin = hanoiTower.printPinA();

		// Identificando o Disco 1 (que ficará em baixo) ---

		if (pin.charAt(0) == '1') {
			t1.setBounds(x / 2 - (250 + 55), y - (450 - 20), 110, 60);
		} else if (pin.charAt(0) == '2') {
			t2.setBounds(x / 2 - (250 + 65), y - (450 - 20), 130, 60);
		} else if (pin.charAt(0) == '3') {
			t3.setBounds(x / 2 - (250 + 75), y - (450 - 20), 150, 60);
		}

		// Identificando o Disco 2 (que ficará no meio) ---

		if (pin.charAt(1) == '1') {
			t1.setBounds(x / 2 - (250 + 55), y - (450 - 80), 110, 60);
		} else if (pin.charAt(1) == '2') {
			t2.setBounds(x / 2 - (250 + 65), y - (450 - 80), 130, 60);
		} else if (pin.charAt(1) == '3') {
			t3.setBounds(x / 2 - (250 + 75), y - (450 - 80), 150, 60);
		}

		// Identificando o Disco 3 (que ficará no topo) ---
		if (pin.charAt(2) == '1') {
			t1.setBounds(x / 2 - (250 + 55), y - (450 - 140), 110, 60);
		} else if (pin.charAt(2) == '2') {
			t2.setBounds(x / 2 - (250 + 65), y - (450 - 140), 130, 60);
		} else if (pin.charAt(2) == '3') {
			t3.setBounds(x / 2 - (250 + 75), y - (450 - 140), 150, 60);
		}

	}

	// Identifica quais Discos devem aparecer no Pino B
	private static void FillPinB() {

		HanoiTower hanoiTower = new HanoiTower();
		String pin = hanoiTower.printPinB();

		// Identificando o Disco 1 (que ficará em baixo) ---

		if (pin.charAt(0) == '1') {
			t1.setBounds(x / 2 - (0 + 55), y - (450 - 20), 110, 60);
		} else if (pin.charAt(0) == '2') {
			t2.setBounds(x / 2 - (0 + 65), y - (450 - 20), 130, 60);
		} else if (pin.charAt(0) == '3') {
			t3.setBounds(x / 2 - (0 + 75), y - (450 - 20), 150, 60);
		}

		// Identificando o Disco 2 (que ficará no meio) ---

		if (pin.charAt(1) == '1') {
			t1.setBounds(x / 2 - (0 + 55), y - (450 - 80), 110, 60);
		} else if (pin.charAt(1) == '2') {
			t2.setBounds(x / 2 - (0 + 65), y - (450 - 80), 130, 60);
		} else if (pin.charAt(1) == '3') {
			t3.setBounds(x / 2 - (0 + 75), y - (450 - 80), 150, 60);
		}

		// Identificando o Disco 3 (que ficará no topo) ---

		if (pin.charAt(2) == '1') {
			t1.setBounds(x / 2 - (0 + 55), y - (450 - 140), 110, 60);
		} else if (pin.charAt(2) == '2') {
			t2.setBounds(x / 2 - (0 + 65), y - (450 - 140), 130, 60);
		} else if (pin.charAt(2) == '3') {
			t3.setBounds(x / 2 - (0 + 75), y - (450 - 140), 150, 60);
		}

	}

	// Identifica quais Discos devem aparecer no Pino C
	private static void FillPinC() {

		HanoiTower hanoiTower = new HanoiTower();
		String pin = hanoiTower.printPinC();

		// Identificando o Disco 1 (que ficará em baixo) ---

		if (pin.charAt(0) == '1') {
			t1.setBounds(x / 2 + (260 - 55), y - (450 - 20), 110, 60);
		} else if (pin.charAt(0) == '2') {
			t2.setBounds(x / 2 + (260 - 65), y - (450 - 20), 130, 60);
		} else if (pin.charAt(0) == '3') {
			t3.setBounds(x / 2 + (260 - 75), y - (450 - 20), 150, 60);
		}

		// Identificando o Disco 2 (que ficará no meio) ---

		if (pin.charAt(1) == '1') {
			t1.setBounds(x / 2 + (260 - 55), y - (450 - 80), 110, 60);
		} else if (pin.charAt(1) == '2') {
			t2.setBounds(x / 2 + (260 - 65), y - (450 - 80), 130, 60);
		} else if (pin.charAt(1) == '3') {
			t3.setBounds(x / 2 + (260 - 75), y - (450 - 80), 150, 60);
		}

		// Identificando o Disco 3 (que ficará no topo) ---

		if (pin.charAt(2) == '1') {
			t1.setBounds(x / 2 + (260 - 55), y - (450 - 140), 110, 60);
		} else if (pin.charAt(2) == '2') {
			t2.setBounds(x / 2 + (260 - 65), y - (450 - 140), 130, 60);
		} else if (pin.charAt(2) == '3') {
			t3.setBounds(x / 2 + (260 - 75), y - (450 - 140), 150, 60);
		}

	}

	// Atualiza a posição dos Discos em cada Pino, de acordo com a Pilha
	public static void Atualizar() {

		FillPinA();
		FillPinB();
		FillPinC();
		ZerarBotoes();

	}

}
