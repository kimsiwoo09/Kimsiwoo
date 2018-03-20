package gui.menu;

import java.awt.Dialog;
import java.awt.Frame;

class Window02 extends Frame{
	//배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
	// 다이얼로그 생성
	// modal - true(상위창 선택불가), false(선택가능)
	private Dialog dialog = new Dialog(this, "다이얼로그", false);
	
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
		
		// 창이 표시되고 나서 잠시 뒤에 다이얼로그 표시
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		
		// 다이얼로그 역시 Frame과 동일한 명령으로 사용
		dialog.setSize(300, 300);
		dialog.setLocation(200, 200);
		dialog.setResizable(true);
		dialog.setVisible(true);
	}

	private void display() {
		
	}

	private void event() {
		
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
