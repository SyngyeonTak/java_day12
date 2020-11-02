/*
 	입력스트림 처리는 파일에 국한된 기술이 아니다!!
 	즉, 실행 중인 프로그램으로 데이터가 흘러들어온다며, 이 모든 것이 다 입력 스트림이다!!
 	따라서 이 예제에서는 파일을 대상으로 데이터를 읽는 것이 아니라,
 	키보드를 대상으로 데이터를 읽어와 보자!!
 	주의) 파일과는 달리, 키보드의 스트림은 자바에서 생성할 수 없다.
 			이미 OS 차원에서 스트림이 존재하므로, 자바는 단지 이미 존재하는 스트림을 얻어와 쓸 수 있을 뿐이다.
 			
 */
package day1102.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyBoardInputApp {
	public static void main(String[] args) {
		//키보드 스트림은 이미 시스템 적으로 존재하므로, 자바의 System 클래스로 부터 얻자!
		//System.in은 이미 연동된 키보드, System.out은 이미 연동된 모니터이다.
		//System.int은 InputStream, System.out은 PrintStream 형이다.
		
		InputStream is = System.in;
		InputStreamReader reader = new InputStreamReader(is);//표준 입력 스트림
		//문자기반 스트림을 이용하려면 먼저 바이트기반 스트림을 먼저 임포트 해야한다.
		//    InputStreamReader          InputStream
		int data;
		try {
			while(true) {
				data = reader.read();//1byte읽기, read()의 특징: 입력이 완료되지 않으면 무한 대기에 빠진다.
												//즉, 입력이 되어야 read()메서드 이후의 문장이 수행될 수 있다.
				System.out.print((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println();//표준 출력 스트림
	}
}












