package gui.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.BorderLayout;

// 윈도우 빌더 사용법
// - 클래스에 JFrame을 상속시킨 뒤 WindowBuilder 전용 에디터로 파일을 열면 끝
// - 좌표를 얻는 것이 주 목적
public class Test10 extends JFrame{
	public Test10() {
		getContentPane().setLayout(null);
	}

}
