package gui.graphic;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

class Window02 extends Frame{
	//��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
	private Image img = Toolkit.getDefaultToolkit().createImage("image/sea.jpg");
	private int x = 20;
	private int y = 20;
	
	private Canvas canvas = new Canvas() {
		public void paint(Graphics g) {
			g.drawImage(img, x, y, 100, 60, this);
			
		}
	};
	private Button bt = new Button("�̵�");
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window02() {
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
		
		this.add(canvas); // Center
		this.add(bt,BorderLayout.SOUTH);
	}

	private void event() {
		// ��ư�� ActionEvent ó�� ��ü�� ����(���ε�)
		bt.addActionListener(e->{
			// canvas���� ��ǥ�� �ٲ۵� �ٽ� �׸����� ����		repaint();
			x += (int)(Math.random()*20);
			y += (int)(Math.random()*20);
			canvas.repaint(); // �ٽ� paint()�� �ڵ����� ����
		});
		
	}

	private void menu() {
		
	}
}

public class Test02 {
	public static void main(String[] args) {
		//â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
		Window02 window = new Window02();
	}
}
