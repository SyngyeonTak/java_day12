package day1102inner;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TestApp extends JFrame{
	Canvas can;
	JButton bt;
	JTextField t;
	
	public TestApp() {
		//Canvas를 현재 클래스에서만 사용하고 추후 재사용성이 없을 경우
		//굳이 거푸집(.java)으로 정의할 이유가 있을까??
		//일회성의 객체 사용인 경우 내부 익명 클래스로 사용할 수 있다..
		//Inner Anonymous Class 내부 익명 클래스라고 한다!!
		//형식은 앞의 클래스(new)를 구현한 클래스로 이해하면 된다.
		//주로 이벤트를 구현한 클래스는 해당 어플리케이션에서만 사용되므로, 재사용가능성이 없다.
		//따라서 내부 익명클래스로 많이 사용된다.
		
		setLayout(new FlowLayout());
		can =  new Canvas() {//재정의할 메서드(내부 익명 클래스)
			public void paint(Graphics g) {
				g.drawLine(0, 0, 100, 100);
			}
		};
		add(bt = new JButton() {
			public void paint(Graphics g) {
				g.setColor(Color.RED);
				g.fillRect(0, 0, 100, 40);
			}
		});
		add(can);
		add(t = new JTextField(20));
		
		//내부익명 클래스는 자신을 포함하고 있는 바깥쪽 클래스의 멤버변수를
		//접근하고 있다.
		t.addKeyListener(new KeyAdapter(){
			
			public void keyReleased(KeyEvent e) {
				System.out.println("눌렀어?");
			}
		});
		
		//내부 익명 클래스는 지역변수가 final로 된 것만 접근이 가능하다...
		final int x = 0;
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(x+"나 눌렀어?");
			}
		});
		
		//윈도우 이벤트 연결
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		can.setPreferredSize(new Dimension(300, 400));
		setSize(new Dimension(400, 400));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TestApp();

	}
}













