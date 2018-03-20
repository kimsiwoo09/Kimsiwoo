package gui.menu;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

class Window01 extends Frame{
	//��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
	// �޴��� ��ü�� ����
	// MenuBar -> Menu -> MenuItem, CheckboxMenuItem
	private MenuBar bar = new MenuBar();
	
	private Menu file = new Menu("File");
	
	private MenuItem n = new MenuItem("New");
	private MenuItem exit = new MenuItem("Exit");
	
	private Menu window = new Menu("Window");
	
	private Menu sv = new Menu("Show View");
	
	private CheckboxMenuItem console = new CheckboxMenuItem("Consol");
	private CheckboxMenuItem outline = new CheckboxMenuItem("Outline");
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window01() {
		this.display();//ȭ�� ���� ���� ó��
		this.event();//�̺�Ʈ ���� ó��
		this.menu();//�޴� ���� ó��
		
		this.setTitle("GUI�׽�Ʈ");
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
			// console �޴��� üũ ���θ� �� �� �ִ°�?
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
		//â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
		Window01 window = new Window01();
	}
}
