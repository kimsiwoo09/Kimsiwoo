package gui.swing;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

class Window03 extends JFrame{
//	��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
//	�������� Component�� Frame�� ���� ��ġ�߾��µ� �̷��� ����ȿ���� ��������
//	Panel�� ���� Component�� ��ġ�� �� �ֵ��� ������ �� �ִ�(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JLabel lb1 = new JLabel("��1",JLabel.CENTER);
	private JLabel lb2 = new JLabel("��2",JLabel.CENTER);
	private JLabel lb3 = new JLabel("��3",JLabel.CENTER);
	private JLabel lb4 = new JLabel("��4",JLabel.CENTER);
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window03() {
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
		mainPanel.setLayout(new GridLayout(2,2));
		
		mainPanel.add(lb1);
		mainPanel.add(lb2);
		mainPanel.add(lb3);
		mainPanel.add(lb4);
		
//		Border�� ���� Swing Component�� ����
//		LineBorder line = new LineBorder(Color.BLACK, 1, true); // ���� ����
		Border line = BorderFactory.createLineBorder(Color.BLACK, 3, true);
		lb1.setBorder(line);
		
//		Border title = BorderFactory.createTitledBorder("���� ����");
		Border title = BorderFactory.createTitledBorder(line, "���� �� ��");
		lb2.setBorder(title);
		
		Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		lb3.setBorder(empty);
		lb3.setOpaque(true); // ������ȭ ����
		lb3.setBackground(Color.YELLOW);
		
		Border dual = BorderFactory.createCompoundBorder(empty, line);
		lb4.setBorder(dual);
		
	}

	private void event() {
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//���α׷� ����
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//â ����
//		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//â ����

//		���� �͵��� �� ���� ��� Ŀ���� �̺�Ʈ ����
//		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//�⺻ �̺�Ʈ ����
		
	}

	private void menu() {
		
	}
}

public class Test03 {
	public static void main(String[] args) {
		//â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
		Window03 window = new Window03();
	}
}
