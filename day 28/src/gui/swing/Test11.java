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
//	��ġ�� �������(������Ʈ)�� ����ʵ�� ������ �� ���
	
//	�������� Component�� Frame�� ���� ��ġ�߾��µ� �̷��� ����ȿ���� ��������
//	Panel�� ���� Component�� ��ġ�� �� �ֵ��� ������ �� �ִ�(ContentPane)
	private JPanel mainPanel = new JPanel();
	
	private JButton a = new JButton("�˸�â");
	private JButton b = new JButton("Ȯ��â");
	private JButton c = new JButton("�Է�â");
	private JButton d = new JButton("������â");
	private JButton e = new JButton("���ϼ���â");
	
	//main�� �ϴ� �������� �����ڿ��� ����
	public Window11() {
		this.display();//ȭ�� ���� ���� ó��
		this.event();//�̺�Ʈ ���� ó��
		this.menu();//�޴� ���� ó��
		
		this.setTitle("GUI�׽�Ʈ");
		this.setSize(500, 400);
//		��ġ�� �ü���� �����ϵ��� ����
		this.setLocationByPlatform(true);
//		��ܺκ��� ������ �ʵ��� ����
//		this.setUndecorated(true);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void display() {
		//mainPanel�� �⺻ �гη� ����
		this.setContentPane(mainPanel);
		
		//��� ������Ʈ�� �߰��� mainPanel�� ����
		mainPanel.add(a);
		mainPanel.add(b);
		mainPanel.add(c);
		mainPanel.add(d);
		mainPanel.add(e);
	}

	private void event() {
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//���α׷� ����
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//â ����
//		this.setDefaultCloseOperation(HIDE_ON_CLOSE);//â ����

//		���� �͵��� �� ���� ��� Ŀ���� �̺�Ʈ ����
//		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//�⺻ �̺�Ʈ ����
		
		a.addActionListener(e->{
//			�˸�â		JOptionPane.showMessageDialog(����������Ʈ, �޼���, ����, ����, ������);

//			ImageIcon icon  = new ImageIcon("image/a.jpg");
//			JOptionPane.showMessageDialog(mainPanel, "�ȳ�?", "�׽�Ʈ", 
//								JOptionPane.QUESTION_MESSAGE, icon);
			
			JOptionPane.showInternalMessageDialog(mainPanel, "�ȳ�?", "�׽�Ʈ", 
								JOptionPane.QUESTION_MESSAGE);
		});
		
		b.addActionListener(e->{
			//Ȯ��â	JOptionPane.showConfirmDialog(����, �޼���, ����, ����, ����);
			
			int res = JOptionPane.showConfirmDialog(mainPanel, "����� ���?", "�峭", 
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//			System.out.println(res);
			if(res == 0) {
				JOptionPane.showMessageDialog(mainPanel, "����� ������");
			}
		});		
		
		c.addActionListener(e->{
			//�Է�â 	JOptionPane.showInputDialog(����, �޼���, ����, ����)
			String str = JOptionPane.showInputDialog(mainPanel, "�Է�", "�׽�Ʈ", 
																	JOptionPane.PLAIN_MESSAGE);
			if(str == null) return;
//			System.out.println(str);
			alert("�Է°� : "+str);
		});
		
		d.addActionListener(e->{
			//������â		JColorChooser.showDialog()
			Color color = JColorChooser.showDialog(mainPanel, "���� ����", Color.BLACK);
//			System.out.println(color);
			if(color == null) return;
			mainPanel.setBackground(color);
		});
		
		e.addActionListener(e->{
			// ���ϼ���â		JFileChooser		�ν��Ͻ� ���� �� ���
			JFileChooser chooser = new JFileChooser(".");
			
//			������ ��� ���� ����
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
//			int res = chooser.showOpenDialog(mainPanel); // ����
			int res = chooser.showSaveDialog(mainPanel); // ����
			System.out.println(res);
			if(res!=0) return;
			
//			���� ���� �ҷ�����
			File target = chooser.getSelectedFile();
			System.out.println("target = "+target.getName());
		});
	}
	
	public void alert(String text) {
		JOptionPane.showMessageDialog(mainPanel, text, "�˸�", JOptionPane.PLAIN_MESSAGE);
	}

	private void menu() {
		
	}
}

public class Test11 {
	public static void main(String[] args) {
		//��Ų ��ġ - ???LookAndFeel Ŭ������ Swing ��ü�� �����ϵ��� �ڵ� ����
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		//â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
		Window11 window = new Window11();
	}
}
