package gui.menu;

import java.awt.FileDialog;
import java.awt.Frame;

class Window03 extends Frame{
	//��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
	// FileDialog		���� ���ÿ� ��â
	private FileDialog f = new FileDialog(this, "���� �����ϱ�", FileDialog.SAVE);
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window03() {
		this.display();//ȭ�� ���� ���� ó��
		this.event();//�̺�Ʈ ���� ó��
		this.menu();//�޴� ���� ó��
		
		this.setTitle("GUI�׽�Ʈ");
		this.setSize(500, 400);
		this.setLocation(100, 100);
		this.setResizable(false);
		this.setVisible(true);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		f.setVisible(true); // â�� ���� ������ block ȿ�� �߻�(���)
		// ����ڰ� ���� ���� �ߴ��� �˾Ƴ��� �Ѵ�
		System.out.println("����ڰ� �� �ൿ�� ���");
		System.out.println(f.getDirectory());
		System.out.println(f.getFile());
	}

	private void display() {
		
	}

	private void event() {
		
	}

	private void menu() {
		
	}
}

public class Test03 {
	public static void main(String[] args) {
		//â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
		Window03 window = new Window03();
	}
}
