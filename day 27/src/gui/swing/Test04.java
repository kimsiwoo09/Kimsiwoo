package gui.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

class Window04 extends JFrame{
//	��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
//	�������� Component�� Frame�� ���� ��ġ�߾��µ� �̷��� ����ȿ���� ��������
//	Panel�� ���� Component�� ��ġ�� �� �ֵ��� ������ �� �ִ�(ContentPane)
	private JPanel mainPanel = new JPanel();
	
//	TextArea -> JTextArea
	private JTextArea jta = new JTextArea();
	
//	JScrollPane
	private JScrollPane scroll = new JScrollPane(jta);
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window04() {
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
		
//		mainPanel.add(jta); // ��ũ�� �Ұ�
		mainPanel.add(scroll);
		
//		��ũ�ѹ� ����
//		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
	}

	private void event() {
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//���α׷� ����
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//â ����
//		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//â ����

//		���� �͵��� �� ���� ��� Ŀ���� �̺�Ʈ ����
//		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//�⺻ �̺�Ʈ ����
		
//		�츮�� �˴� �̺�Ʈ �ܿ� Swing������ "���� ����Ű"�� ������ �� �ִ�
//		����Ű ��ü�� ������ �Ѵ� - KeyStroke
//		KeyStroke enter = KeyStroke.getKeyStroke(����Ű,�Է�Ű);
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0);
		KeyStroke ctrlEnter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);
		
		Action enterAction = new AbstractAction() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("������!");
			}
		};
		Action ctrlEnterAction = new AbstractAction() {

			public void actionPerformed(ActionEvent arg0) {
				System.out.println("�����ٷ� �̵�!");
			}
		};
		
		//jta�� �����ϴ� InputMap�� ActionMap�� ����Ű + ��Ī / ��Ī + �׼��� ���
		jta.getInputMap().put(enter, "����");
		jta.getActionMap().put("����", enterAction);
		
		jta.getInputMap().put(ctrlEnter,"������");
		jta.getActionMap().put("������", ctrlEnterAction);
	}

	private void menu() {
		
	}
}

public class Test04 {
	public static void main(String[] args) {
		//â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
		Window04 window = new Window04();
	}
}
