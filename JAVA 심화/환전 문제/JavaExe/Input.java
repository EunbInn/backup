package JavaExe;

import java.util.Scanner;

public class Input {
	Scanner sc = null;
	
	public Input() {
		sc = new Scanner(System.in);
	}
	
	public int inputFromConsoleType() {
		System.out.println("# 환전할 화폐 종류를 골라주세요\n"
					+ "1. 달러 (Dollar)\n"
					+ "2. 유로 (Euro)\n"
	                + "3. 엔화 (JPY)\n"
					+ "0. Exit");
		
		int input = sc.nextInt();
		
		return input;
	}
	
	public int inputFromConsoleMoney() {
		System.out.print("원화 입력: ");
		int input = sc.nextInt();
		
		return input;
	}
	

}
