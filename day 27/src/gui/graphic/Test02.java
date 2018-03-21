package gui.graphic;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

class Window02 extends Frame{
	//배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
	private Image img = Toolkit.getDefaultToolkit().createImage("image/sea.jpg");
	private int x = 20;
	private int y = 20;
	
	private Canvas canvas = new Canvas() {
		public void paint(Graphics g) {
			g.drawImage(img, x, y, 100, 60, this);
			
		}
	};
	private Button bt = new Button("이동");
	
	//main에 하던 설정들을 생성자에서 진행
	public Window02() {
		this.display();//화면 구성 관련 처리
		this.event();//이벤트 관련 처리
		this.menu();//메뉴 관련 처리
		
		this.setTitle("GUI테스트");
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
		// 버튼에 ActionEvent 처리 객체를 연결(바인딩)
		bt.addActionListener(e->{
			// canvas에게 좌표를 바꾼뒤 다시 그리도록 지시		repaint();
			x += (int)(Math.random()*20);
			y += (int)(Math.random()*20);
			canvas.repaint(); // 다시 paint()를 자동으로 실행
		});
		
	}

	private void menu() {
		
	}
}

public class Test02 {
	public static void main(String[] args) {
		//창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
		Window02 window = new Window02();
	}
}
