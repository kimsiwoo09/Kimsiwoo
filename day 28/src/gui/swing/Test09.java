package gui.swing;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;

class Window09 extends JFrame{
//	��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
//	�������� Component�� Frame�� ���� ��ġ�߾��µ� �̷��� ����ȿ���� ��������
//	Panel�� ���� Component�� ��ġ�� �� �ֵ��� ������ �� �ִ�(ContentPane)
	private JPanel mainPanel = new JPanel();
	
//	 ToolBar(����) - �̵��� �޴�
	private JToolBar toolBar = new JToolBar();
	
//	���ٿ� �߰��� ������Ʈ
	private JButton jajang = new JButton("�����");
	private JButton jjam = new JButton("«��");
	private JButton bock = new JButton("������");
	private JButton random = new JButton("�ƹ��ų�");
	
//	�̹���
	private ImageIcon img1 = new ImageIcon("lib/jajang.jpg");
	private ImageIcon img2 = new ImageIcon("lib/jjam.jpg");
	private ImageIcon img3 = new ImageIcon("lib/bock.jpg");
	
//	�̹��� ǥ�ÿ� ��
	private JLabel display = new JLabel();
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window09() {
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
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(toolBar,BorderLayout.NORTH);
		
		toolBar.add(jajang);
		toolBar.add(jjam);
		toolBar.add(bock);
		toolBar.add(random);
		
		mainPanel.add(display);
	}

	private void event() {
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//���α׷� ����
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//â ����
//		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//â ����

//		���� �͵��� �� ���� ��� Ŀ���� �̺�Ʈ ����
//		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//�⺻ �̺�Ʈ ����
//		jajang.addActionListener(l);
		
//		��ư�� ������ �ش��ϴ� �޴��� ǥ�õǵ��� ����
		jajang.addActionListener(e->{
			display.setIcon(img1);
		});
		jjam.addActionListener(e->{
			display.setIcon(img2);
		});
		bock.addActionListener(e->{
			display.setIcon(img3);
		});
		random.addActionListener(e->{
			int num=(int)(Math.random()*3);
			switch(num) {
			case 0:
				display.setIcon(img1);
				break;
			case 1:
				display.setIcon(img2);
				break;
			case 2:
				display.setIcon(img3);
				break;
			}
		});
		
	}

	private void menu() {
		
	}
}

public class Test09 {
	public static void main(String[] args) {
		// ��Ų ��ġ - ??LookAndFeel Ŭ������ Swing ��ü�� �����ϵ��� �ڵ� ����
		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
		Window09 window = new Window09();
	}
}
