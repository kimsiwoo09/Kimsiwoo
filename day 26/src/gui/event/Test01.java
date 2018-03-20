package gui.event;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Window01 extends Frame{
	//배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	private Button bt = new Button("마우스를 올려보세요!");
	
	
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
		this.add(bt);
	}

	private void event() {
		// 마우스 이벤트를 처리할 수 있는 객체를 만들어 버튼에 설정
		// - > MouseListener
		MouseListener listener = new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
//				System.out.println("마우스 뗌");
			}
			
			public void mousePressed(MouseEvent arg0) {
//				System.out.println("마우스 누름!");
			}
			
			public void mouseExited(MouseEvent arg0) {
//				System.out.println("마우스 탈출!");
			}
			
			public void mouseEntered(MouseEvent arg0) {
//				System.out.println("마우스 진입");
			}
			
			public void mouseClicked(MouseEvent event) {
				System.out.println("마우스 클릭!");
//				System.out.println(event.get); get....
			}
		};
		bt.addMouseListener(listener);
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
