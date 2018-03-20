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
	//��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	private Label label = new Label("�̿� ����� �����Ͻʴϱ�?", Label.CENTER);
	
	private Panel p = new Panel(new GridLayout(1,2));
	
	private Button bt1 = new Button("��");
	private Button bt2 = new Button("�ƴϿ�");
	
//	private BorderLayout border = new BorderLayout();
//	private GridLayout grid = new GridLayout(1, 2);
	
//	private Color color = new Color(171,242,0);
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window02() {
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
		this.setLayout(new GridLayout(2,1));
		
		this.add(label);
		this.add(p);
//		p.setLayout(grid);
		p.add(bt1);
		p.add(bt2);
	}

	private void event() {
		// ~~ Listener�� ��� �������̽��� ������ �����Ǹ� �ؾ��ϹǷ� �ڵ� ���� �߻�
		// -> �޼ҵ尡 2�� �̻��� Listener�� �ݵ�� �̸� ����� Ŭ������ ����(Adapter)
		
		MouseListener listener = new MouseAdapter() {
			public void mouseExited(MouseEvent event) {
				if(event.getSource() == bt1)
					bt1.setBackground(null);
				else if(event.getSource() == bt2)
					bt2.setBackground(null);
			}
			
			public void mouseEntered(MouseEvent event) {
				// event.getSource()�� �̿��ϸ� �̺�Ʈ�� �߻��� ��ü�� ������ ��ȯ
				if(event.getSource() == bt1)
					bt1.setBackground(Color.yellow);
				else if(event.getSource() == bt2)
					bt2.setBackground(Color.YELLOW);
			}
			
			public void mouseClicked(MouseEvent event) {
				bt1.setEnabled(false);
				bt2.setEnabled(false);
				label.setText("ó���� �Ϸ�Ǿ����ϴ�");
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
		//â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
		Window02 window = new Window02();
	}
}
