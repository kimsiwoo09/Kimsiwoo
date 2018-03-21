package gui.graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

class Window01 extends Frame{
	//배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
	//컴포넌트 : 캔버스
	
	//Canvas		도화지 역할의 컴포넌트
	//					그림을 그리는 메소드(paint)를 가지고 있다
	//					우리는 이 메소드를 "재정의"하여 사용
	
	//Image
	private Image img = Toolkit.getDefaultToolkit().createImage("image/sea.jpg");
	
	private Canvas canvas = new Canvas() {
		@Override
		public void paint(Graphics pen) {
			//pen을 이용하여 canvas에 그림을 그리면 된다
			super.paint(pen);
			
//			System.out.println("paint가 실행되었습니다");
			
			pen.drawLine(50, 50, 150, 150);//선(어디서 -> 어디로)
			
			pen.drawRect(50, 50, 100, 100);//속이 빈 사각형
			pen.fillRect(200, 50, 100, 100);//속이 채워진 사각형
			
			pen.setColor(Color.red);
			
			pen.drawOval(50, 50, 100, 100); // 속이 빈 원
			
			pen.setFont(new Font("",Font.ITALIC,50)); // 글꼴 설정
			
			pen.drawString("안녕 그래픽", 100, 300); // 글자
			
			pen.drawImage(img, 50, 50, 300, 200, this); // this=canvas
			
		}
	};
	
	//main에 하던 설정들을 생성자에서 진행
	public Window01() {
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
		this.add(canvas);
	}

	private void event() {
		
	}

	private void menu() {
		
	}
}

public class Test01 {
	public static void main(String[] args) {
		//창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
		Window01 window = new Window01();
	}
}
