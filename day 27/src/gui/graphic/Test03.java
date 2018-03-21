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
	//배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
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
	private Button bt1 = new Button("최소");
	private Button bt2 = new Button("축소");
	private Button bt3 = new Button("확대");
	private Button bt4 = new Button("최대");
	
	//main에 하던 설정들을 생성자에서 진행
	public Window03() {
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
		
		this.add(canvas,BorderLayout.CENTER); // Center
		this.add(panel,BorderLayout.SOUTH);
		panel.add(bt1);
		panel.add(bt2);
		panel.add(bt3);
		panel.add(bt4);
	}

	private void event() {
		// 버튼에 ActionEvent 처리 객체를 연결(바인딩)
		bt1.addActionListener(e->{
			// canvas에게 좌표를 바꾼뒤 다시 그리도록 지시		repaint();
			a = 100;
			b = 100;
			canvas.repaint(); // 다시 paint()를 자동으로 실행
		});
		bt2.addActionListener(e->{
			// canvas에게 좌표를 바꾼뒤 다시 그리도록 지시		repaint();
			if(a > 100 ||  b>100) {
				a -= 20;
				b -= 20;
			}
			canvas.repaint(); // 다시 paint()를 자동으로 실행
		});
		bt3.addActionListener(e->{
			// canvas에게 좌표를 바꾼뒤 다시 그리도록 지시		repaint();
			if(a < 300 || b<300) {
				a += 20;
				b += 20;
			}
			canvas.repaint(); // 다시 paint()를 자동으로 실행
		});
		bt4.addActionListener(e->{
			// canvas에게 좌표를 바꾼뒤 다시 그리도록 지시		repaint();
			a = 300;
			b = 300;
			canvas.repaint(); // 다시 paint()를 자동으로 실행
		});
		
	}

	private void menu() {
		
	}
}

public class Test03 {
	public static void main(String[] args) {
		//창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
		Window03 window = new Window03();
	}
}
