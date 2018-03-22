package gui.swing;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

class Window13 extends JFrame{
//	��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
//	�������� Component�� Frame�� ���� ��ġ�߾��µ� �̷��� ����ȿ���� ��������
//	Panel�� ���� Component�� ��ġ�� �� �ֵ��� ������ �� �ִ�(ContentPane)
	
//	Swing������ Panel�� Canvas ����� �ִ�
	private BufferedImage img;
	private JPanel mainPanel = new JPanel() {
		protected void paintComponent(java.awt.Graphics g) {
			if(img != null)
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		};
	};
	
	private JMenuBar bar = new JMenuBar();
	private JMenu menu = new JMenu("���");
	private JMenuItem capture = new JMenuItem("��ũ���� ĸ��");
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window13() {
		this.display();//ȭ�� ���� ���� ó��
		this.event();//�̺�Ʈ ���� ó��
		this.menu();//�޴� ���� ó��
		
		this.setTitle("GUI�׽�Ʈ");
		this.setSize(500, 400);
//		��ġ�� �ü���� �����ϵ��� ����
		this.setLocationByPlatform(true);
//		��ܺκ��� ������ �ʵ��� ����
//		this.setUndecorated(true);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void display() {
		//mainPanel�� �⺻ �гη� ����
		this.setContentPane(mainPanel);
		
		//��� ������Ʈ�� �߰��� mainPanel�� ����
		
	}

	private void event() {
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//���α׷� ����
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//â ����
//		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//â ����

//		���� �͵��� �� ���� ��� Ŀ���� �̺�Ʈ ����
//		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//�⺻ �̺�Ʈ ����
		
//		F5�� menu�� ����Ű�� ����
		KeyStroke f5 = KeyStroke.getKeyStroke(KeyEvent.VK_F5,0);
		capture.setAccelerator(f5);
		
		capture.addActionListener(e->{
			try {
				Robot r = new Robot();
				// Toolkit�� �̿��� ����� ũ�⸦ ���
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//				System.out.println(d);
				Rectangle rect = new Rectangle(0, 0, d.width, d.height);
				img = r.createScreenCapture(rect);
				mainPanel.repaint();
			} catch(Exception err) {
				err.printStackTrace();
			}
		});
		
	}

	private void menu() {
		this.setJMenuBar(bar);
		bar.add(menu);
		menu.add(capture);
	}
}

public class Test13 {
	public static void main(String[] args) {
		// ��Ų ��ġ - ??LookAndFeel Ŭ������ Swing ��ü�� �����ϵ��� �ڵ� ����
		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
		Window13 window = new Window13();
	}
}
