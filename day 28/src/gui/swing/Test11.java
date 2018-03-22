package gui.swing;

import java.awt.Color;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

class Window11 extends JFrame{
//	배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
//	기존에는 Component를 Frame에 직접 배치했었는데 이러면 관리효율이 떨어진다
//	Panel을 만들어서 Component를 배치할 수 있도록 설정할 수 있다(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JButton a = new JButton("알림창");
	private JButton b = new JButton("확인창");
	private JButton c = new JButton("입력창");
	private JButton d = new JButton("색상선택창");
	private JButton e = new JButton("파일선택창");
	
	//main에 하던 설정들을 생성자에서 진행
	public Window11() {
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
		mainPanel.add(a);
		mainPanel.add(b);
		mainPanel.add(c);
		mainPanel.add(d);
		mainPanel.add(e);
	}

	private void event() {
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//프로그램 종료
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//창 종료
//		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//창 숨김

//		위의 것들이 다 싫을 경우 커스텀 이벤트 설정
//		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//기본 이벤트 방지
		
		a.addActionListener(e->{
//			알림창		JOptionPane.showMessageDialog(기준컴포넌트, 메세지, 제목, 종류, 아이콘);

//			ImageIcon icon  = new ImageIcon("image/a.jpg");
//			JOptionPane.showMessageDialog(mainPanel, "안녕?", "테스트", 
//								JOptionPane.QUESTION_MESSAGE, icon);
			
			JOptionPane.showInternalMessageDialog(mainPanel, "안녕?", "테스트", 
								JOptionPane.QUESTION_MESSAGE);
		});
		
		b.addActionListener(e->{
			//확인창	JOptionPane.showConfirmDialog(기준, 메세지, 제목, 유형, 종류);
			
			int res = JOptionPane.showConfirmDialog(mainPanel, "전재산 기부?", "장난", 
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//			System.out.println(res);
			if(res == 0) {
				JOptionPane.showMessageDialog(mainPanel, "전재산 탕진각");
			}
		});		
		
		c.addActionListener(e->{
			//입력창 	JOptionPane.showInputDialog(기준, 메세지, 제목, 종류)
			String str = JOptionPane.showInputDialog(mainPanel, "입력", "테스트", 
																	JOptionPane.PLAIN_MESSAGE);
			if(str == null) return;
//			System.out.println(str);
			alert("입력값 : "+str);
		});
		
		d.addActionListener(e->{
			//색상선택창		JColorChooser.showDialog()
			Color color = JColorChooser.showDialog(mainPanel, "색상 선택", Color.BLACK);
//			System.out.println(color);
			if(color == null) return;
			mainPanel.setBackground(color);
		});
		
		e.addActionListener(e->{
			// 파일선택창		JFileChooser		인스턴스 생성 후 사용
			JFileChooser chooser = new JFileChooser(".");
			
//			선택할 대상에 대한 설정
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
//			int res = chooser.showOpenDialog(mainPanel); // 열기
			int res = chooser.showSaveDialog(mainPanel); // 저장
			System.out.println(res);
			if(res!=0) return;
			
//			파일 정보 불러오기
			File target = chooser.getSelectedFile();
			System.out.println("target = "+target.getName());
		});
	}
	
	public void alert(String text) {
		JOptionPane.showMessageDialog(mainPanel, text, "알림", JOptionPane.PLAIN_MESSAGE);
	}

	private void menu() {
		
	}
}

public class Test11 {
	public static void main(String[] args) {
		//스킨 설치 - ???LookAndFeel 클래스를 Swing 전체에 설정하도록 코드 구현
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		//창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
		Window11 window = new Window11();
	}
}
