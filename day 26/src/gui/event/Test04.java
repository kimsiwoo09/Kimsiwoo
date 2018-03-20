package gui.event;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class Window04 extends Frame{
	//배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
	//main에 하던 설정들을 생성자에서 진행
	public Window04() {
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
		
	}

	private void event() {
		// 창(Frame)에 이벤트를 설정
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
		//창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
		Window04 window = new Window04();
	}
}
