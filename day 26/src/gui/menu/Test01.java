package gui.menu;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

class Window01 extends Frame{
	//배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
	// 메뉴를 객체로 생성
	// MenuBar -> Menu -> MenuItem, CheckboxMenuItem
	private MenuBar bar = new MenuBar();
	
	private Menu file = new Menu("File");
	
	private MenuItem n = new MenuItem("New");
	private MenuItem exit = new MenuItem("Exit");
	
	private Menu window = new Menu("Window");
	
	private Menu sv = new Menu("Show View");
	
	private CheckboxMenuItem console = new CheckboxMenuItem("Consol");
	private CheckboxMenuItem outline = new CheckboxMenuItem("Outline");
	
	//main에 하던 설정들을 생성자에서 진행
	public Window01() {
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
		
	}

	private void event() {
		exit.addActionListener(event->{
			System.exit(0);
		});
		
		console.addItemListener(event->{
			// console 메뉴와 체크 여부를 알 수 있는가?
			System.out.println(console.getState());
		});
	}

	private void menu() {
		this.setMenuBar(bar);
		
		bar.add(file);
		
		file.add(n);
		file.add(exit);
		
		bar.add(window);
		
		window.add(sv);
		
		sv.add(console);
		sv.add(outline);
	}
}

public class Test01 {
	public static void main(String[] args) {
		//창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
		Window01 window = new Window01();
	}
}
