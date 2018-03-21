package gui.graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

class Window01 extends Frame{
	//��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
	//������Ʈ : ĵ����
	
	//Canvas		��ȭ�� ������ ������Ʈ
	//					�׸��� �׸��� �޼ҵ�(paint)�� ������ �ִ�
	//					�츮�� �� �޼ҵ带 "������"�Ͽ� ���
	
	//Image
	private Image img = Toolkit.getDefaultToolkit().createImage("image/sea.jpg");
	
	private Canvas canvas = new Canvas() {
		@Override
		public void paint(Graphics pen) {
			//pen�� �̿��Ͽ� canvas�� �׸��� �׸��� �ȴ�
			super.paint(pen);
			
//			System.out.println("paint�� ����Ǿ����ϴ�");
			
			pen.drawLine(50, 50, 150, 150);//��(��� -> ����)
			
			pen.drawRect(50, 50, 100, 100);//���� �� �簢��
			pen.fillRect(200, 50, 100, 100);//���� ä���� �簢��
			
			pen.setColor(Color.red);
			
			pen.drawOval(50, 50, 100, 100); // ���� �� ��
			
			pen.setFont(new Font("",Font.ITALIC,50)); // �۲� ����
			
			pen.drawString("�ȳ� �׷���", 100, 300); // ����
			
			pen.drawImage(img, 50, 50, 300, 200, this); // this=canvas
			
		}
	};
	
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
		this.add(canvas);
	}

	private void event() {
		
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
