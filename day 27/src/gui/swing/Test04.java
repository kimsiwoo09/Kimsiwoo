package gui.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

class Window04 extends JFrame{
//	배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
//	기존에는 Component를 Frame에 직접 배치했었는데 이러면 관리효율이 떨어진다
//	Panel을 만들어서 Component를 배치할 수 있도록 설정할 수 있다(ContentPane)
	private JPanel mainPanel = new JPanel();
	
//	TextArea -> JTextArea
	private JTextArea jta = new JTextArea();
	
//	JScrollPane
	private JScrollPane scroll = new JScrollPane(jta);
	
	//main에 하던 설정들을 생성자에서 진행
	public Window04() {
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
		
//		mainPanel.add(jta); // 스크롤 불가
		mainPanel.add(scroll);
		
//		스크롤바 설정
//		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
	}

	private void event() {
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//프로그램 종료
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//창 종료
//		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//창 숨김

//		위의 것들이 다 싫을 경우 커스텀 이벤트 설정
//		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//기본 이벤트 방지
		
//		우리가 알던 이벤트 외에 Swing에서는 "내장 단축키"를 변경할 수 있다
//		단축키 객체를 만들어야 한다 - KeyStroke
//		KeyStroke enter = KeyStroke.getKeyStroke(조합키,입력키);
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0);
		KeyStroke ctrlEnter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);
		
		Action enterAction = new AbstractAction() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("전송해!");
			}
		};
		Action ctrlEnterAction = new AbstractAction() {

			public void actionPerformed(ActionEvent arg0) {
				System.out.println("다음줄로 이동!");
			}
		};
		
		//jta에 존재하는 InputMap과 ActionMap에 단축키 + 별칭 / 별칭 + 액션을 등록
		jta.getInputMap().put(enter, "전송");
		jta.getActionMap().put("전송", enterAction);
		
		jta.getInputMap().put(ctrlEnter,"다음줄");
		jta.getActionMap().put("다음줄", ctrlEnterAction);
	}

	private void menu() {
		
	}
}

public class Test04 {
	public static void main(String[] args) {
		//창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
		Window04 window = new Window04();
	}
}
