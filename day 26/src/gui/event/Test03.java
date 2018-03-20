package gui.event;

import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

class Window03 extends Frame{
	//배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	private TextArea ta = new TextArea();
	
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
		this.add(ta);
		ta.setFont(new Font("", Font.PLAIN, 30));
	}

	private void event() {
		// KeyEvent를 처리할 수 있는 객체를 만들어 ta에 설정
		// - KeyListener , KeyAdapter
		// - 유니코드를 유일하게 식별할 수 있는 메소드가 keyType(대신 기능키 감지 불가)
		KeyListener listener = new KeyListener() {
			
			public void keyTyped(KeyEvent event) {
//				System.out.println("타이핑");
			}
			
			public void keyReleased(KeyEvent event) {
//				System.out.println("뗌");
			}
			
			public void keyPressed(KeyEvent event) {
//				System.out.println("누름");
				
				// 뭘 눌렀는지를 event 객체에 있다
//				System.out.println(event.getKeyCode());
//				System.out.println(event.getKeyChar()); // 기능키 감지 불가
				
				// 키에 따른 처리는 일반적으로 아래와 같이 구현
				switch(event.getKeyCode()) {
				case KeyEvent.VK_F5 : //F5키
					Date d = new Date();
					Format f = new SimpleDateFormat("a h:mm y-MM-dd");
					String time = f.format(d);
//					ta.setText(time);
					ta.append(time); // append는 뒤에 붙여쓸때...
					break;
				case KeyEvent.VK_ESCAPE:
					dispose();
					break;
					
				}
				// 조합키 처리(Alt + F4 , Ctrl + A)
				// event.getModifiersEx()
				System.out.println(event.getModifiersEx());
				
				// Ctrl 키를 눌렀다면 ... 을 조건으로 구현
				if(event.getModifiersEx() == KeyEvent.CTRL_DOWN_MASK) {
					System.out.println("컨트롤 조합키...");
				}
				
				// 예를 들어 컨트롤 + 알트면 .. or 연산을 통해 계산
				System.out.println(KeyEvent.CTRL_DOWN_MASK | KeyEvent.ALT_DOWN_MASK);
			}
		};
		ta.addKeyListener(listener);
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
