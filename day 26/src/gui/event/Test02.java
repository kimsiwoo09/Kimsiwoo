package gui.event;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Window02 extends Frame{
	//배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	private Label label = new Label("이용 약관에 동의하십니까?", Label.CENTER);
	
	private Panel p = new Panel(new GridLayout(1,2));
	
	private Button bt1 = new Button("예");
	private Button bt2 = new Button("아니오");
	
//	private BorderLayout border = new BorderLayout();
//	private GridLayout grid = new GridLayout(1, 2);
	
//	private Color color = new Color(171,242,0);
	
	//main에 하던 설정들을 생성자에서 진행
	public Window02() {
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
		this.setLayout(new GridLayout(2,1));
		
		this.add(label);
		this.add(p);
//		p.setLayout(grid);
		p.add(bt1);
		p.add(bt2);
	}

	private void event() {
		// ~~ Listener의 경우 인터페이스라 무조건 재정의를 해야하므로 코드 낭비가 발생
		// -> 메소드가 2개 이상인 Listener는 반드시 이를 상속한 클래스가 존재(Adapter)
		
		MouseListener listener = new MouseAdapter() {
			public void mouseExited(MouseEvent event) {
				if(event.getSource() == bt1)
					bt1.setBackground(null);
				else if(event.getSource() == bt2)
					bt2.setBackground(null);
			}
			
			public void mouseEntered(MouseEvent event) {
				// event.getSource()를 이용하면 이벤트가 발생한 객체의 참조를 반환
				if(event.getSource() == bt1)
					bt1.setBackground(Color.yellow);
				else if(event.getSource() == bt2)
					bt2.setBackground(Color.YELLOW);
			}
			
			public void mouseClicked(MouseEvent event) {
				bt1.setEnabled(false);
				bt2.setEnabled(false);
				label.setText("처리가 완료되었습니다");
			}
		};
		bt1.addMouseListener(listener);
		bt2.addMouseListener(listener);
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
