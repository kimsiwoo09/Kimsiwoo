package gui.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

class Window07 extends JFrame{
//	��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
//	�������� Component�� Frame�� ���� ��ġ�߾��µ� �̷��� ����ȿ���� ��������
//	Panel�� ���� Component�� ��ġ�� �� �ֵ��� ������ �� �ִ�(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JButton bt1 = new JButton("1��");
	private JButton bt2 = new JButton("2��");
	private JButton bt3 = new JButton("3��");
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window07() {
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
		
		// ���̾ƿ� ����
		mainPanel.setLayout(null);
		
		// ���̾ƿ��� ������ ��ǥ�� ����������Ѵ�
//		bt1.setLocation(50, 50);
//		bt1.setSize(200, 100);
		bt1.setBounds(50, 50, 200, 100);
		bt2.setBounds(300, 100, 80, 40);
		bt3.setBounds(100, 300,60, 50);
		
		//��� ������Ʈ�� �߰��� mainPanel�� ����
		mainPanel.add(bt1);
		mainPanel.add(bt2);
		mainPanel.add(bt3);
		
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

public class Test07 {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
		Window07 window = new Window07();
	}
}
