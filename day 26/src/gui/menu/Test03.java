package gui.menu;

import java.awt.FileDialog;
import java.awt.Frame;

class Window03 extends Frame{
	//배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
	// FileDialog		파일 선택용 새창
	private FileDialog f = new FileDialog(this, "파일 저장하기", FileDialog.SAVE);
	
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
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		f.setVisible(true); // 창이 꺼질 때까지 block 효과 발생(대기)
		// 사용자가 무슨 짓을 했는지 알아내야 한다
		System.out.println("사용자가 한 행동과 결과");
		System.out.println(f.getDirectory());
		System.out.println(f.getFile());
	}

	private void display() {
		
	}

	private void event() {
		
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
