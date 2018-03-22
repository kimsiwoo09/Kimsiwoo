package gui.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

class Window07 extends JFrame{
//	배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
//	기존에는 Component를 Frame에 직접 배치했었는데 이러면 관리효율이 떨어진다
//	Panel을 만들어서 Component를 배치할 수 있도록 설정할 수 있다(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JButton bt1 = new JButton("1번");
	private JButton bt2 = new JButton("2번");
	private JButton bt3 = new JButton("3번");
	
	//main에 하던 설정들을 생성자에서 진행
	public Window07() {
		this.display();//화면 구성 관련 처리
		this.event();//이벤트 관련 처리
		this.menu();//메뉴 관련 처리
		
		this.setTitle("GUI테스트");
		this.setSize(500, 400);
//		위치를 운영체제가 결정하도록 하자
		this.setLocationByPlatform(true);
//		상단부분이 나오지 않도록 설정
//		this.setUndecorated(true);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void display() {
		//mainPanel을 기본 패널로 설정
		this.setContentPane(mainPanel);
		
		// 레이아웃 제거
		mainPanel.setLayout(null);
		
		// 레이아웃이 없으면 좌표를 지정해줘야한다
//		bt1.setLocation(50, 50);
//		bt1.setSize(200, 100);
		bt1.setBounds(50, 50, 200, 100);
		bt2.setBounds(300, 100, 80, 40);
		bt3.setBounds(100, 300,60, 50);
		
		//모든 컴포넌트의 추가는 mainPanel에 수행
		mainPanel.add(bt1);
		mainPanel.add(bt2);
		mainPanel.add(bt3);
		
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

public class Test07 {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
		Window07 window = new Window07();
	}
}
