package gui.event;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class Window04 extends Frame{
	//��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window04() {
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
		
	}

	private void event() {
		// â(Frame)�� �̺�Ʈ�� ����
		WindowListener listener = new WindowAdapter() {
			
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
		};
		this.addWindowListener(listener);
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
