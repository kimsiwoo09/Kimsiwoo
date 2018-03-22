package gui.swing;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;

class Window09 extends JFrame{
//	배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
//	기존에는 Component를 Frame에 직접 배치했었는데 이러면 관리효율이 떨어진다
//	Panel을 만들어서 Component를 배치할 수 있도록 설정할 수 있다(ContentPane)
	private JPanel mainPanel = new JPanel();
	
//	 ToolBar(툴바) - 이동형 메뉴
	private JToolBar toolBar = new JToolBar();
	
//	툴바에 추가할 컴포넌트
	private JButton jajang = new JButton("자장면");
	private JButton jjam = new JButton("짬뽕");
	private JButton bock = new JButton("볶음밥");
	private JButton random = new JButton("아무거나");
	
//	이미지
	private ImageIcon img1 = new ImageIcon("lib/jajang.jpg");
	private ImageIcon img2 = new ImageIcon("lib/jjam.jpg");
	private ImageIcon img3 = new ImageIcon("lib/bock.jpg");
	
//	이미지 표시용 라벨
	private JLabel display = new JLabel();
	
	//main에 하던 설정들을 생성자에서 진행
	public Window09() {
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
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(toolBar,BorderLayout.NORTH);
		
		toolBar.add(jajang);
		toolBar.add(jjam);
		toolBar.add(bock);
		toolBar.add(random);
		
		mainPanel.add(display);
	}

	private void event() {
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//프로그램 종료
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//창 종료
//		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//창 숨김

//		위의 것들이 다 싫을 경우 커스텀 이벤트 설정
//		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//기본 이벤트 방지
//		jajang.addActionListener(l);
		
//		버튼을 누르면 해당하는 메뉴가 표시되도록 설정
		jajang.addActionListener(e->{
			display.setIcon(img1);
		});
		jjam.addActionListener(e->{
			display.setIcon(img2);
		});
		bock.addActionListener(e->{
			display.setIcon(img3);
		});
		random.addActionListener(e->{
			int num=(int)(Math.random()*3);
			switch(num) {
			case 0:
				display.setIcon(img1);
				break;
			case 1:
				display.setIcon(img2);
				break;
			case 2:
				display.setIcon(img3);
				break;
			}
		});
		
	}

	private void menu() {
		
	}
}

public class Test09 {
	public static void main(String[] args) {
		// 스킨 설치 - ??LookAndFeel 클래스를 Swing 전체에 설정하도록 코드 구현
		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
		Window09 window = new Window09();
	}
}
