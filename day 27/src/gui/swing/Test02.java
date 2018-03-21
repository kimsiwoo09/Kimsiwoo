package gui.swing;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Window02 extends JFrame{
//	배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
//	기존에는 Component를 Frame에 직접 배치했었는데 이러면 관리효율이 떨어진다
//	Panel을 만들어서 Component를 배치할 수 있도록 설정할 수 있다(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JButton bt = new JButton("버튼!");
	
//	Swing에서는 ImageIcon이라는 클래스를 이용해서 이미지 처리 없이 쉽게 설정이 가능
	private ImageIcon icon = new ImageIcon("image/sea.jpg");
	
	//main에 하던 설정들을 생성자에서 진행
	public Window02() {
		this.display();//화면 구성 관련 처리
		this.event();//이벤트 관련 처리
		this.menu();//메뉴 관련 처리
		
		this.setTitle("GUI테스트");
		this.setSize(500, 400);
//		위치를 운영체제가 결정하도록 하자
		this.setLocationByPlatform(true);
//		상단부분이 나오지 않도록 설정
//		this.setUndecorated(true);
		this.setResizable(true);
		this.setVisible(true);
	}

	private void display() {
		//mainPanel을 기본 패널로 설정
		this.setContentPane(mainPanel);
		
		//모든 컴포넌트의 추가는 mainPanel에 수행
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(bt);
		
		//bt에 icon을 설정
		bt.setIcon(icon);
		bt.setText("");
	}

	private void event() {
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//프로그램 종료
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//창 종료
//		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//창 숨김

//		위의 것들이 다 싫을 경우 커스텀 이벤트 설정
//		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//기본 이벤트 방지
		
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
