package gui.swing;

import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

class Window05 extends JFrame{
//	��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
//	�������� Component�� Frame�� ���� ��ġ�߾��µ� �̷��� ����ȿ���� ��������
//	Panel�� ���� Component�� ��ġ�� �� �ֵ��� ������ �� �ִ�(ContentPane)
	private JPanel mainPanel = new JPanel();
	
//	�޴�
//	JMenuBar - JMenu - JMenuItem / JCheckBoxMenuItem / JRadioButtonMenuItem
	private JMenuBar bar = new JMenuBar();
	
	private JMenu file = new JMenu("����");
	
	private JMenuItem exit = new JMenuItem("�����ϱ�");
	
	private JRadioButtonMenuItem r1 = new JRadioButtonMenuItem("�Ϲݿ�");
	private JRadioButtonMenuItem r2 = new JRadioButtonMenuItem("���п�");
	
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window05() {
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
		
//		�޴��� ����Ű ������ ���� KeyStroke�� �̿�
		KeyStroke esc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
		
//		����Ű ���� - ������ �� ����Ű�� ������ ActionEvent�� �߻�
		exit.setAccelerator(esc);
		
		exit.addActionListener(e->{
			System.exit(0);
		});
		
	}

	private void menu() {
		this.setJMenuBar(bar);
		bar.add(file);
		file.add(exit);
		file.add(r1);
		file.add(r2);
		
		// ButtonGroup�� ����� r1, r2�� �������� �˷��ش�
		ButtonGroup group = new ButtonGroup();
		group.add(r1);
		group.add(r2);
		
		r1.setSelected(true); // r1�� �����ϼ���
	}
}

public class Test05 {
	public static void main(String[] args) {
		//â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
		Window05 window = new Window05();
	}
}
