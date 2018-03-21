package gui.graphic;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

class Window05 extends Frame{
	//배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
	private class CanvasEx extends Canvas{
		private Image img;
		private BufferedImage[] slice;
		
		public void setImage(int index) {
			img = slice[index];
		}
		
		public CanvasEx() {
//			img = Toolkit.getDefaultToolkit().getImage("image/run.png");
			
//			편집용 이미지는 BufferedImage 형태로 불러오며, ImageIO라는 클래스를 사용한다
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
	
	//main에 하던 설정들을 생성자에서 진행
	public Window05() {
		this.display();//화면 구성 관련 처리
		this.event();//이벤트 관련 처리
		this.menu();//메뉴 관련 처리
		
		this.setTitle("GUI테스트");
		this.setSize(500, 400);
		this.setLocation(100, 100);
		this.setResizable(false);
		this.setVisible(true);
		
		// 화면 표시된 뒤부터 이미지를 일정간격으로 연속해서 다시 그려준다.. 쓰레드로
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
		//창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
		Window05 window = new Window05();
	}
}
