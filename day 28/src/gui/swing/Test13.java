package gui.swing;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

class Window13 extends JFrame{
//	배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
//	기존에는 Component를 Frame에 직접 배치했었는데 이러면 관리효율이 떨어진다
//	Panel을 만들어서 Component를 배치할 수 있도록 설정할 수 있다(ContentPane)
	
//	Swing에서는 Panel에 Canvas 기능이 있다
	private BufferedImage img;
	private JPanel mainPanel = new JPanel() {
		protected void paintComponent(java.awt.Graphics g) {
			if(img != null)
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		};
	};
	
	private JMenuBar bar = new JMenuBar();
	private JMenu menu = new JMenu("기능");
	private JMenuItem capture = new JMenuItem("스크린샷 캡쳐");
	
	//main에 하던 설정들을 생성자에서 진행
	public Window13() {
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
		
	}

	private void event() {
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//프로그램 종료
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//창 종료
//		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//창 숨김

//		위의 것들이 다 싫을 경우 커스텀 이벤트 설정
//		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//기본 이벤트 방지
		
//		F5를 menu의 단축키로 지정
		KeyStroke f5 = KeyStroke.getKeyStroke(KeyEvent.VK_F5,0);
		capture.setAccelerator(f5);
		
		capture.addActionListener(e->{
			try {
				Robot r = new Robot();
				// Toolkit을 이용해 모니터 크기를 계산
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//				System.out.println(d);
				Rectangle rect = new Rectangle(0, 0, d.width, d.height);
				img = r.createScreenCapture(rect);
				mainPanel.repaint();
			} catch(Exception err) {
				err.printStackTrace();
			}
		});
		
	}

	private void menu() {
		this.setJMenuBar(bar);
		bar.add(menu);
		menu.add(capture);
	}
}

public class Test13 {
	public static void main(String[] args) {
		// 스킨 설치 - ??LookAndFeel 클래스를 Swing 전체에 설정하도록 코드 구현
		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
		Window13 window = new Window13();
	}
}
