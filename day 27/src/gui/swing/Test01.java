package gui.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Window01 extends JFrame{
	//��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
//	 �������� Component�� Frame�� ���� ��ġ�߾��µ� �̷��� ����ȿ���� ��������
//	Panel�� ���� Component�� ��ġ�� �� �ֵ��� ������ �� �ִ�(ContentPane)
	JPanel mainPanel = new JPanel();
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window01() {
		this.display();//ȭ�� ���� ���� ó��
		this.event();//�̺�Ʈ ���� ó��
		this.menu();//�޴� ���� ó��
		
		this.setTitle("GUI�׽�Ʈ");
		this.setSize(500, 400);
//		this.setLocation(100, 100);
//		��ġ�� �ü���� �����ϵ��� ����
		this.setLocationByPlatform(true); // ��ġ���ʰ�...
//		��ܺκ��� ������ �ʵ��� ����
		this.setUndecorated(true);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void display() {
		//mainPanel�� �⺻ �гη� ����
		this.setContentPane(mainPanel);
		
		//��� ������Ʈ�� �߰��� mainPanel�� ����
		
	}

	private void event() {
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // ���α׷� ����
//		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // â ����
//		this.setDefaultCloseOperation(HIDE_ON_CLOSE); // â ����
//		���� �͵��� �� ���� ��� Ŀ���� �̺�Ʈ ����
//		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // �⺻ �̺�Ʈ ����
	}

	private void menu() {
		
	}
}

public class Test01 {
	public static void main(String[] args) {
		//â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
		Window01 window = new Window01();
	}
}
