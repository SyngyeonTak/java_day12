//키보드 입력 스트림은 문자기반의 Buffer 처리된 스트림을 이용할 것

package day1102.event;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KeyBoardApp extends JFrame{
	JPanel panel;
	JTextField field;
	FileWriter writer;
	BufferedWriter buffw;
	
	
	public KeyBoardApp() {
		panel = new JPanel();
		field = new JTextField(20);
		field.setPreferredSize(new Dimension(200, 30));
		
		panel.add(field);
		add(panel);
		
		field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				write();
			}
			
		});
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void write() {
		URL url = this.getClass().getClassLoader().getResource("res/test.txt");
		//url을 매개 변수로 받는 녀석을 못찾겠음...
		buffw = new BufferedWriter(writer);
	}
	
	public static void main(String[] args) {
		new KeyBoardApp();
	}
}
