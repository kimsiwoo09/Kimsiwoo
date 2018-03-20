package gui.event;

import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

class Window03 extends Frame{
	//��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	private TextArea ta = new TextArea();
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window03() {
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
		this.add(ta);
		ta.setFont(new Font("", Font.PLAIN, 30));
	}

	private void event() {
		// KeyEvent�� ó���� �� �ִ� ��ü�� ����� ta�� ����
		// - KeyListener , KeyAdapter
		// - �����ڵ带 �����ϰ� �ĺ��� �� �ִ� �޼ҵ尡 keyType(��� ���Ű ���� �Ұ�)
		KeyListener listener = new KeyListener() {
			
			public void keyTyped(KeyEvent event) {
//				System.out.println("Ÿ����");
			}
			
			public void keyReleased(KeyEvent event) {
//				System.out.println("��");
			}
			
			public void keyPressed(KeyEvent event) {
//				System.out.println("����");
				
				// �� ���������� event ��ü�� �ִ�
//				System.out.println(event.getKeyCode());
//				System.out.println(event.getKeyChar()); // ���Ű ���� �Ұ�
				
				// Ű�� ���� ó���� �Ϲ������� �Ʒ��� ���� ����
				switch(event.getKeyCode()) {
				case KeyEvent.VK_F5 : //F5Ű
					Date d = new Date();
					Format f = new SimpleDateFormat("a h:mm y-MM-dd");
					String time = f.format(d);
//					ta.setText(time);
					ta.append(time); // append�� �ڿ� �ٿ�����...
					break;
				case KeyEvent.VK_ESCAPE:
					dispose();
					break;
					
				}
				// ����Ű ó��(Alt + F4 , Ctrl + A)
				// event.getModifiersEx()
				System.out.println(event.getModifiersEx());
				
				// Ctrl Ű�� �����ٸ� ... �� �������� ����
				if(event.getModifiersEx() == KeyEvent.CTRL_DOWN_MASK) {
					System.out.println("��Ʈ�� ����Ű...");
				}
				
				// ���� ��� ��Ʈ�� + ��Ʈ�� .. or ������ ���� ���
				System.out.println(KeyEvent.CTRL_DOWN_MASK | KeyEvent.ALT_DOWN_MASK);
			}
		};
		ta.addKeyListener(listener);
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
