package gui.menu;

import java.awt.Dialog;
import java.awt.Frame;

class Window02 extends Frame{
	//��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
	// ���̾�α� ����
	// modal - true(����â ���úҰ�), false(���ð���)
	private Dialog dialog = new Dialog(this, "���̾�α�", false);
	
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
		
		// â�� ǥ�õǰ� ���� ��� �ڿ� ���̾�α� ǥ��
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		
		// ���̾�α� ���� Frame�� ������ ������� ���
		dialog.setSize(300, 300);
		dialog.setLocation(200, 200);
		dialog.setResizable(true);
		dialog.setVisible(true);
	}

	private void display() {
		
	}

	private void event() {
		
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
