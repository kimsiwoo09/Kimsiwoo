package gui.event;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Window01 extends Frame{
	//��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	private Button bt = new Button("���콺�� �÷�������!");
	
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window01() {
		this.display();//ȭ�� ���� ���� ó��
		this.event();//�̺�Ʈ ���� ó��
		this.menu();//�޴� ���� ó��
		
		this.setTitle("GUI�׽�Ʈ");
		this.setSize(500, 400);
		this.setLocation(100, 100);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void display() {
		this.add(bt);
	}

	private void event() {
		// ���콺 �̺�Ʈ�� ó���� �� �ִ� ��ü�� ����� ��ư�� ����
		// - > MouseListener
		MouseListener listener = new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
//				System.out.println("���콺 ��");
			}
			
			public void mousePressed(MouseEvent arg0) {
//				System.out.println("���콺 ����!");
			}
			
			public void mouseExited(MouseEvent arg0) {
//				System.out.println("���콺 Ż��!");
			}
			
			public void mouseEntered(MouseEvent arg0) {
//				System.out.println("���콺 ����");
			}
			
			public void mouseClicked(MouseEvent event) {
				System.out.println("���콺 Ŭ��!");
//				System.out.println(event.get); get....
			}
		};
		bt.addMouseListener(listener);
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
