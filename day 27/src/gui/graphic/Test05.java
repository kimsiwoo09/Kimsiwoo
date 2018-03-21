package gui.graphic;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

class Window05 extends Frame{
	//��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
	private class CanvasEx extends Canvas{
		private Image img;
		private BufferedImage[] slice;
		
		public void setImage(int index) {
			img = slice[index];
		}
		
		public CanvasEx() {
//			img = Toolkit.getDefaultToolkit().getImage("image/run.png");
			
//			������ �̹����� BufferedImage ���·� �ҷ�����, ImageIO��� Ŭ������ ����Ѵ�
			BufferedImage origin = ImageManager.load("image/run.png");
			
			slice = ImageManager.slice(origin, 6);
			img=slice[0];
		}
		@Override
		public void paint(Graphics g) {
			if(img != null) {
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		}
		
	}
	private CanvasEx canvas = new CanvasEx();
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window05() {
		this.display();//ȭ�� ���� ���� ó��
		this.event();//�̺�Ʈ ���� ó��
		this.menu();//�޴� ���� ó��
		
		this.setTitle("GUI�׽�Ʈ");
		this.setSize(500, 400);
		this.setLocation(100, 100);
		this.setResizable(false);
		this.setVisible(true);
		
		// ȭ�� ǥ�õ� �ں��� �̹����� ������������ �����ؼ� �ٽ� �׷��ش�.. �������
		Thread t = new Thread() {
			@Override
			public void run() {
				int index = 0;
				while(true) {
					canvas.setImage(index);
					canvas.repaint();
					index++;
					index %= 6;
					
					try {
						Thread.sleep(1000/60);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		t.setDaemon(true);
		t.start();
	}

	private void display() {
		this.add(canvas);
	}

	private void event() {
		
	}

	private void menu() {
		
	}
}

public class Test05 {
	public static void main(String[] args) {
		//â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
		Window05 window = new Window05();
	}
}
