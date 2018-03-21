package gui.swing;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

class Window03 extends JFrame{
//	배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
//	기존에는 Component를 Frame에 직접 배치했었는데 이러면 관리효율이 떨어진다
//	Panel을 만들어서 Component를 배치할 수 있도록 설정할 수 있다(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JLabel lb1 = new JLabel("라벨1",JLabel.CENTER);
	private JLabel lb2 = new JLabel("라벨2",JLabel.CENTER);
	private JLabel lb3 = new JLabel("라벨3",JLabel.CENTER);
	private JLabel lb4 = new JLabel("라벨4",JLabel.CENTER);
	
	//main에 하던 설정들을 생성자에서 진행
	public Window03() {
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
		
		//모든 컴포넌트의 추가는 mainPanel에 수행
		mainPanel.setLayout(new GridLayout(2,2));
		
		mainPanel.add(lb1);
		mainPanel.add(lb2);
		mainPanel.add(lb3);
		mainPanel.add(lb4);
		
//		Border를 만들어서 Swing Component에 설정
//		LineBorder line = new LineBorder(Color.BLACK, 1, true); // 직접 생성
		Border line = BorderFactory.createLineBorder(Color.BLACK, 3, true);
		lb1.setBorder(line);
		
//		Border title = BorderFactory.createTitledBorder("오늘 할일");
		Border title = BorderFactory.createTitledBorder(line, "오늘 할 일");
		lb2.setBorder(title);
		
		Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		lb3.setBorder(empty);
		lb3.setOpaque(true); // 불투명화 설정
		lb3.setBackground(Color.YELLOW);
		
		Border dual = BorderFactory.createCompoundBorder(empty, line);
		lb4.setBorder(dual);
		
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

public class Test03 {
	public static void main(String[] args) {
		//창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
		Window03 window = new Window03();
	}
}
