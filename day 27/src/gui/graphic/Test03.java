package gui.graphic;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

class Window03 extends Frame{
	//��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
	private Image img = Toolkit.getDefaultToolkit().createImage("image/sea.jpg");
	private int x = 30;
	private int y = 30;
	private int a = 200;
	private int b = 200;
	
	private Panel panel = new Panel(new GridLayout(1,4));
	private Canvas canvas = new Canvas() {
		public void paint(Graphics g) {
			g.drawImage(img, x, y, a, b, this);
			
		}
	};
	private Button bt1 = new Button("�ּ�");
	private Button bt2 = new Button("���");
	private Button bt3 = new Button("Ȯ��");
	private Button bt4 = new Button("�ִ�");
	
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
		this.setLayout(new BorderLayout());
		
		this.add(canvas,BorderLayout.CENTER); // Center
		this.add(panel,BorderLayout.SOUTH);
		panel.add(bt1);
		panel.add(bt2);
		panel.add(bt3);
		panel.add(bt4);
	}

	private void event() {
		// ��ư�� ActionEvent ó�� ��ü�� ����(���ε�)
		bt1.addActionListener(e->{
			// canvas���� ��ǥ�� �ٲ۵� �ٽ� �׸����� ����		repaint();
			a = 100;
			b = 100;
			canvas.repaint(); // �ٽ� paint()�� �ڵ����� ����
		});
		bt2.addActionListener(e->{
			// canvas���� ��ǥ�� �ٲ۵� �ٽ� �׸����� ����		repaint();
			if(a > 100 ||  b>100) {
				a -= 20;
				b -= 20;
			}
			canvas.repaint(); // �ٽ� paint()�� �ڵ����� ����
		});
		bt3.addActionListener(e->{
			// canvas���� ��ǥ�� �ٲ۵� �ٽ� �׸����� ����		repaint();
			if(a < 300 || b<300) {
				a += 20;
				b += 20;
			}
			canvas.repaint(); // �ٽ� paint()�� �ڵ����� ����
		});
		bt4.addActionListener(e->{
			// canvas���� ��ǥ�� �ٲ۵� �ٽ� �׸����� ����		repaint();
			a = 300;
			b = 300;
			canvas.repaint(); // �ٽ� paint()�� �ڵ����� ����
		});
		
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
