package Lecture05;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

//20210412 김은비 영수증 출력
public class Lecture5_4 {

	public static void main(String[] args) {//메인에서 시작
		DecimalFormat k08_df = new DecimalFormat("###,###,###");//decimal format으로 숫자 포맷 지정(콤마출력)
		Calendar k08_cal = Calendar.getInstance();//시스템 날짜를 이용하기 위해 calendar.getInstance() 사용
		SimpleDateFormat k08_sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 날짜 포맷을 영수증에 나올 포맷과 일치시키기
		
		Scanner k08_sc = new Scanner(System.in);//가격을 입력받을 스캐너 오브젝트 생성

		int k08_iTax, k08_iOrigin; //세금과 가격 원가를 저장할 변수 타입 지정 및 선언
		int k08_iPrice = k08_sc.nextInt();//가격을 integer type으로 입력받음
		// price = origin(1 + 0.1)
		// origin = price / 1.1 -> 1.1 곱하면 값이 이상하게 나오는 경우가 있으므로 1.1 = (11.0 * 10)을 변형 하여 계산  
		k08_iOrigin = (int) (k08_iPrice / 11.0 * 10);
		k08_iTax = k08_iPrice - k08_iOrigin;// tax = price - origin
		


		System.out.printf("신용승인\n");//영수증 최상단 내용 출력
		System.out.printf("%s%18.20s\n", "단말기 : 2N68665898", "전표번호 : 041218");//출력 단말기 번호와 전표번호 출력
		System.out.printf("가맹점 : 한양김치찌개\n");//가게명 출력
		System.out.printf("주  소 : 경기 성남시 분당구 황새울로 351번길 10 , 1층\n");//가게 주소 출력
		System.out.printf("대표자 : 유창신\n");//가게 대표명 출력
		System.out.printf("%s%20.20s\n", "사업자 : 752-53-00558", "TEL : 7055695");//사업자번호 및 매장 전화번호 출력
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n");//구분선 출력
		System.out.printf("%s%18.20s 원\n",k08_blank("금    액",20), k08_df.format(k08_iOrigin));//미리 지정해둔 포맷으로 원가 출력
		System.out.printf("%s%18.20s 원\n",k08_blank("부 가 세", 20), k08_df.format(k08_iTax));//미리 지정해둔 포맷으로 세금 출력
		System.out.printf("%s%18.20s 원\n",k08_blank("합    계", 20), k08_df.format(k08_iPrice));//미리 지정해둔 포맷으로 총액 출력(입력받은 금액)
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n");//구분선 출력
		System.out.printf("우리카드\n");//이용 카드 출력
		System.out.printf("%s%5.6s\n", "카드번호 : 5387-20**-****-4613(S)", "일시불");//카드번호 및 결제 방식 출력
		System.out.printf("거래일시 : %s\n", k08_sdf.format(k08_cal.getTime()));//미리지정해둔 날짜 타입으로 변환하여 거래일시 시스템 날짜로 출력
		System.out.printf("승인번호 : 70404427\n");//결제 승인번호 출력
		System.out.printf("거래번호 : 357734873739\n");//결제 거래 번호 출력
		System.out.printf("%s%20s\n", "매입 : 비씨카드사", "가맹 : 720068568");//결제 처리 카드사명 및 가맹점 번호 출력
		System.out.printf("알림 : EDC매출표\n");//알림 출력
		System.out.printf("문의 : TEL)1544-4700\n");//문의 번호 출력
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n");//구분선 출력
		System.out.printf("%23s\n", "* 감사합니다 *");//맺음말 출력
		System.out.printf("%39s\n", "표준v2.08_20200212"); //정보 출력

	}
	
	public static String k08_blank(String k08_temp, int k08_length) {//스트링 타입과 인티저 타입을 인자로 받고 스트링 타입을 리턴하는 메서드 선언
		int k08_blank = 0;
		if (k08_temp.getBytes().length <= k08_length) { // 만약 문자열의 바이트가 원하는 자르기 바이트보다 작을 경우
			k08_blank = (k08_length) - k08_temp.getBytes().length; //공백 길이 = 원하는 출력 바이트수 - 인자로 받은 문자열 바이트 수
			for (int i = 0; i < k08_blank; i++) { //위에서 구한 공백의 길이만큼 반복문 실행
				k08_temp += " "; // 문자열에 공백 추가
			}
			return k08_temp; // 수정된 문자열 리턴

		} else { //문자열의 바이트 수가 원하는 바이트 수 보다 클 경우
			int k08_cnt = 0; //인티저타입 변수 선언 및 0으로 초기화
			String k08_text = ""; //스트링타입 오브젝트 선언 및 ""로 초기화
			for (char k08_ch : k08_temp.toCharArray()) { //캐릭터 타입 변수 선언, 인자로 받은 문자열을 캐릭터 배열에 넣고 배열 길이만큼 반복문 실행
				k08_cnt += String.valueOf(k08_ch).getBytes().length; //카운트 변수에 한글자마다의 바이트길이 누적
				if (k08_cnt > k08_length) break; //카운트가 원하는 리턴 바이트 수보다 커지면 반복문 탈출 
				k08_text += String.valueOf(k08_ch);//카운트가 원하는 리턴 바이트 수보다 커지기 전까지 텍스트에 한글자씩 누적
			}

			k08_blank = k08_length - k08_text.getBytes().length;//공백 길이 = 원하는 출력 바이트수 - 인자로 받은 문자열 바이트 수
			for (int i = 0; i < k08_blank; i++) {//위에서 구한 공백의 길이만큼 반복문 실행
				k08_text += " ";// 문자열에 공백 추가
			}
			return k08_text;//수정된 문자열 리턴
		}
	}

}