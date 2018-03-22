package gui.swing;

import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

class Window05 extends JFrame{
//	배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
//	기존에는 Component를 Frame에 직접 배치했었는데 이러면 관리효율이 떨어진다
//	Panel을 만들어서 Component를 배치할 수 있도록 설정할 수 있다(ContentPane)
	private JPanel mainPanel = new JPanel();
	
//	메뉴
//	JMenuBar - JMenu - JMenuItem / JCheckBoxMenuItem / JRadioButtonMenuItem
	private JMenuBar bar = new JMenuBar();
	
	private JMenu file = new JMenu("파일");
	
	private JMenuItem exit = new JMenuItem("종료하기");
	
	private JRadioButtonMenuItem r1 = new JRadioButtonMenuItem("일반용");
	private JRadioButtonMenuItem r2 = new JRadioButtonMenuItem("공학용");
	
	
	//main에 하던 설정들을 생성자에서 진행
	public Window05() {
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
		
//		메뉴에 단축키 지정할 때도 KeyStroke를 이용
		KeyStroke esc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
		
//		단축키 지정 - 지정한 뒤 단축키를 누르면 ActionEvent가 발생
		exit.setAccelerator(esc);
		
		exit.addActionListener(e->{
			System.exit(0);
		});
		
	}

	private void menu() {
		this.setJMenuBar(bar);
		bar.add(file);
		file.add(exit);
		file.add(r1);
		file.add(r2);
		
		// ButtonGroup을 만들어 r1, r2가 묶음임을 알려준다
		ButtonGroup group = new ButtonGroup();
		group.add(r1);
		group.add(r2);
		
		r1.setSelected(true); // r1을 선택하세요
	}
}

public class Test05 {
	public static void main(String[] args) {
		//창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
		Window05 window = new Window05();
	}
}
