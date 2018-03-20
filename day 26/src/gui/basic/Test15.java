package gui.basic;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Window15 extends Frame{
	//��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
	//��ư 16��
	private Button[] bt = new Button[16];
	private String[] title = new String[] {
			"7","8","9","+","4","5","6","-","1","2","3","*","0","Clear","=","/"
	};
	
	//��
	private Label label = new Label("0", Label.RIGHT);
	
	//�г�
	private Panel p = new Panel();
	
	//���̾ƿ� 2��
	private BorderLayout border = new BorderLayout();
	private GridLayout grid = new GridLayout(4, 4);
	
//	�۲� ��ü - �󺧿�, ��ư��
	private Font lbFont = new Font("", Font.BOLD, 40);
	private Font btFont = new Font("", Font.PLAIN, 30);
	
//	Ŀ�� ��ü
	private Cursor hand = new Cursor(Cursor.HAND_CURSOR);
	
//	�̺�Ʈ ó�� ��ü
//	private ActionListener listener = new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent event) {
//			
//		}
//	};
	
//	������ڿ� �����ȣ�� ������ ����
	private long bknum;
	private String bkyun;
	
//	â �Է��� �ʱ�ȭ�� ����(true�� ��� �Է�, false�� �ʱ�ȭ�ϰ� �Է� ����)
	private boolean flag = true;
	
	private ActionListener listener = (event)->{
//		���� ��ư�� ���ڰ� �ƴ� ��ư�� �����Ͽ� �ٸ��� ó���� ����
		String cmd = event.getActionCommand();
		
		try {
//			���ڸ� - �����ؼ� ȭ�鿡 ǥ��
			if(flag) {
				long no = Long.parseLong(label.getText() + cmd);
				label.setText(String.valueOf(no));
			}
			else {
				long no = Long.parseLong(cmd);
				flag = true;
				label.setText(String.valueOf(no));
			}
		}catch(Exception e) {
//			���ڰ� �ƴϸ�
//			System.out.println("���� �ƴ�! "+cmd);
			
			switch(cmd) {
			case "+":
			case "-":
			case "/":
			case "*":
				if(bkyun != null) {
					long input = Long.parseLong(label.getText());
					long result = calc(bknum, input, bkyun);
					label.setText(String.valueOf(result));
				}
				//������ڿ� ��ȣ ��ü
				bknum = Long.parseLong(label.getText());
				System.out.println("����� ���� : "+bknum);
				bkyun = cmd;
				System.out.println("����� ��ȣ : "+bkyun);
				
				//�Է��� ���� �޵��� flag ����
				flag = false;
				
				break;
			case "=":
				long input = Long.parseLong(label.getText());
				long result = calc(bknum,input,bkyun);
				label.setText(String.valueOf(result));
				bkyun = null; // �����ȣ ����
				break;
			case "Clear":
				label.setText("0");
				break;
			}
			
		}
		
	};
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window15() {
		this.display();//ȭ�� ���� ���� ó��
		this.event();//�̺�Ʈ ���� ó��
		this.menu();//�޴� ���� ó��
		
		this.setTitle("GUI�׽�Ʈ");
		this.setSize(500, 400);
		this.setLocation(100, 100);
		this.setResizable(false);
		this.setVisible(true);
	}

	private long calc(long bk, long input, String cmd) {
		switch(cmd) {
		case "+": return bk + input;
		case "-": return bk - input;
		case "*": return bk * input;
		case "/": return bk / input;
		}
		return 0;
	}

	private void display() {
		this.setLayout(border);
		
		this.add(label, BorderLayout.NORTH);
		this.add(p, BorderLayout.CENTER);
		
		p.setLayout(grid);
		
		label.setFont(lbFont);
		
		for(int i=0; i < bt.length; i++) {
			bt[i] = new Button(title[i]);				//����
			bt[i].setBackground(Color.black);	//����
			bt[i].setForeground(Color.yellow);	//���ڻ�
			bt[i].setFont(btFont);						//�۲�
			p.add(bt[i]);										//�߰�
		}
	}

	private void event() {
		//�̺�Ʈ ����(��ư 16���� ��ü ��)
		for(int i=0; i < bt.length; i++) {
			bt[i].addActionListener(listener);
		}
	}

	private void menu() {
		
	}
}

public class Test15 {
	public static void main(String[] args) {
		//â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
		Window15 window = new Window15();
	}
}
