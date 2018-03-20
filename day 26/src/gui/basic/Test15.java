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
	//배치할 구성요소(컴포넌트)를 멤버필드로 구현한 뒤 사용
	
	//버튼 16개
	private Button[] bt = new Button[16];
	private String[] title = new String[] {
			"7","8","9","+","4","5","6","-","1","2","3","*","0","Clear","=","/"
	};
	
	//라벨
	private Label label = new Label("0", Label.RIGHT);
	
	//패널
	private Panel p = new Panel();
	
	//레이아웃 2개
	private BorderLayout border = new BorderLayout();
	private GridLayout grid = new GridLayout(4, 4);
	
//	글꼴 객체 - 라벨용, 버튼용
	private Font lbFont = new Font("", Font.BOLD, 40);
	private Font btFont = new Font("", Font.PLAIN, 30);
	
//	커서 객체
	private Cursor hand = new Cursor(Cursor.HAND_CURSOR);
	
//	이벤트 처리 객체
//	private ActionListener listener = new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent event) {
//			
//		}
//	};
	
//	백업숫자와 백업기호를 저장할 공간
	private long bknum;
	private String bkyun;
	
//	창 입력을 초기화할 변수(true면 계속 입력, false면 초기화하고 입력 진행)
	private boolean flag = true;
	
	private ActionListener listener = (event)->{
//		숫자 버튼과 숫자가 아닌 버튼을 구별하여 다르게 처리를 지시
		String cmd = event.getActionCommand();
		
		try {
//			숫자면 - 누적해서 화면에 표시
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
//			숫자가 아니면
//			System.out.println("숫자 아님! "+cmd);
			
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
				//백업숫자와 기호 교체
				bknum = Long.parseLong(label.getText());
				System.out.println("백업된 숫자 : "+bknum);
				bkyun = cmd;
				System.out.println("백업된 기호 : "+bkyun);
				
				//입력을 새로 받도록 flag 설정
				flag = false;
				
				break;
			case "=":
				long input = Long.parseLong(label.getText());
				long result = calc(bknum,input,bkyun);
				label.setText(String.valueOf(result));
				bkyun = null; // 백업기호 삭제
				break;
			case "Clear":
				label.setText("0");
				break;
			}
			
		}
		
	};
	
	//main에 하던 설정들을 생성자에서 진행
	public Window15() {
		this.display();//화면 구성 관련 처리
		this.event();//이벤트 관련 처리
		this.menu();//메뉴 관련 처리
		
		this.setTitle("GUI테스트");
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
			bt[i] = new Button(title[i]);				//생성
			bt[i].setBackground(Color.black);	//배경색
			bt[i].setForeground(Color.yellow);	//글자색
			bt[i].setFont(btFont);						//글꼴
			p.add(bt[i]);										//추가
		}
	}

	private void event() {
		//이벤트 설정(버튼 16개에 전체 다)
		for(int i=0; i < bt.length; i++) {
			bt[i].addActionListener(listener);
		}
	}

	private void menu() {
		
	}
}

public class Test15 {
	public static void main(String[] args) {
		//창을 더이상 직접 만들지 않고 확장시킨 클래스의 인스턴스를 생성
		Window15 window = new Window15();
	}
}
