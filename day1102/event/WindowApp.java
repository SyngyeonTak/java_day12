package day1102.event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WindowApp extends JFrame{
	
	public WindowApp() {
		this.addWindowListener(new WindowAdapter(){//이름 없는 클래스, WindowAdapter의 자식 클래스
																				//내부 익명 클래스(재사용성이 없을 때 많이 사용)
			public void windowClosing(WindowEvent e) {
				System.out.println("window Closing");
				System.exit(0);//프로세스 종료
			}
			
			public void windowClosed(WindowEvent e) {
				System.out.println("window Closed");
			}
		});
		setSize(300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowApp();
	}

}
