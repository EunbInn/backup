package Lecture05;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//20210415 김은비 이마트 영수증 출력
public class Lecture5_6 {//클래스선언
	
	public static void main(String[] args) {//메인에서 시작
		Date k08_date = new Date(); //데이트 오브젝트 선언
		SimpleDateFormat k08_sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //영수증 날짜 포맷을 참고하여 포맷 설정
		SimpleDateFormat k08_car = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //영수증 내 입차시간의 날짜포맷 설정
		SimpleDateFormat k08_last = new SimpleDateFormat("yyyyMMdd");//영수증 최하단 출력부 날짜 포맷 설정
		Date k08_carD = new Date(k08_date.getTime() - (long)(1000 * 60 * 60));//입차시간 임의로 1시간 빼서 설정
		DecimalFormat k08_df = new DecimalFormat("###,###,###,###");//가격의 세자리마다 콤마를 출력해주기 위해 숫자 포맷 설정
		String[] k08_itemName = {"aaaaa엑스트라버진올리브오일","비비고 김치만두","안주나라 불막창볶음","다크초코마들렌 500g","삼립 촉촉한 모닝 식빵",
                "식물나라 바디워시 라벤더 200ml","보풀제거기 여분 배터리","꼬북칩 초코츄러스맛","코카콜라 제로콜라 330ml",
                "하얀나라 점보롤휴지(그린 소프트) 30입","가나초콜릿 마일드(레드)","오레오즈 시리얼 마시멜로우","형광 싸인펜 24색","지구색연필 12색",
                "홈데코 원목 보석함(로즈우드)","글레이즈 도넛 스퀴즈","말랑말랑 슬라임(옐로우)","글로리아 유리병",
                "클린하우스 빗자루 녹색 100cm","유한 락스 욕실청소 200ml","8핀 충전기 (2m)","버니니 스트로베리 500ml","테라 맥주 500ml",
                "s","집편한세상 양은냄비 m","비비고 매콤 육개장","까르보 불닭볶음면 5개입","진라면 순한맛 5개입",
                "오뚜기 3분카레 순한맛","오뚜기 3분짜장","LG디오스냉장고(양문형)","싱싱 쌈채소 세트 100g" }; //스트링 배열에 30개 이상의 아이템명 입력
		int[] k08_itemPrice = {3000,2000,7300,5600,3000,
							7250,12000,3400,1200,21000,
							1500,5000,5620,4560,1200,7200,
							8200,3250,7000,21000,9180,
							1500,1600,4500,5700,1420,5500,
							7200,1200,1200,9990000,550}; //인티저 배열에 스트링 배열과 동일한 크기로 아이템의 값 입력
		int[] k08_itemNum = {1,1,3,1,3,1,2,3,2,1,//인티저 배열에 스트링 배열과 동일한 크기로 아이템 수량 입력
						2,2,1,2,1,2,4,3,1,2,
						1,3,2,4,1,2,1,2,4,2,3,1};
		// 불린 배열에 스트링 배열과 동일한 크기로 true false 입력 -> 해당 값은 면세, 과세 항목 구분을 위함
		boolean[] k08_TaxFree = {false,false,false,true,false,false,false,false,false,true,
				true,false,false,false,false,false,false,false,false,true,
				true,false,false,false,false,true,true,false,false,true,false,false};
		int k08_origin = 0; //origin price 인티저 타입 선언 및 초기화 
		int k08_tax = 0;//tax 인티저 타입 선언 및 초기화
		
		System.out.printf("             이마트 죽전점 (031)888-1234\n"); //지점 및 지점 번호 출력
		System.out.printf("    emart    206-86-50913 강희석\n");//이마트 사업자번호 및 대표자명 출력
		System.out.printf("             용인 수지구 포은대로 552\n");//지점 주소 출력
		System.out.printf("\n영수증 미지참시 교환/환불 불가\n");//환불 불가내용 출력
		System.out.printf("정상상품에 한함, 30일 이내(신선 7일)\n");//환불 기간 안내 출력
		System.out.printf("※일부 브랜드매장 제외(매장 고지물참조)\n");//제외매장 관련 출력
		System.out.printf("교환/환불 구매점에서 가능(결제카드 지참)\n");//교환환불 방법 출력
		System.out.printf("\n[구 매]%15.20s%18.20s\n", k08_sdf.format(k08_date.getTime()), "POS:0011-9861");//구매일과 포스 등록번호 출력
		System.out.printf("-----------------------------------------\n");//구분선 출력
		System.out.printf("  상 품 명          단  가  수량   금  액\n");//값 구분 카테고리 출력
		System.out.printf("-----------------------------------------\n");//구분선 출력
		int k08_sumNoTax = 0;//비과세항목 총 가격 변수 인티저로 선언
		int k08_sumTax = 0;//과세항목 총 가격 변수 인티저로 선언 
		int k08_cnt = 0;//인티저타입 변수 선언 및 초기화
		for (int k08_i = 0; k08_i < k08_itemName.length; k08_i++) { //0~상품명 저장한 스트링 배열 크기만큼 반복문 실행
			String k08_taxCheck = "";//스트링 변수 선언 및 초기화
			k08_cnt++;
			if (k08_TaxFree[k08_i] == true) {//불린 배열 tax free의 i번째 저장값이 false일때
				k08_taxCheck = "* " + k08_itemName[k08_i];//아이템 이름 앞에 * 추가
				k08_sumNoTax += k08_itemPrice[k08_i] * k08_itemNum[k08_i];//no tax 합계 값 누적
				
			} else {//불린 배열 tax free의 i번째 저장 값이 true일 때,
				k08_taxCheck = "  " + k08_itemName[k08_i];//아이템 이름 앞에 공백 추가(*붙인 값과 길이를 맞추기 위함)
				k08_sumTax += k08_itemPrice[k08_i] * k08_itemNum[k08_i];//tax항목 합계값 누적
			}
			int k08_length = 0; //인티저 변수 선언 및 0 으로 초기화
			if (k08_df.format(k08_itemPrice[k08_i]).length() > 8) {//만약 아이템 가격을 콤마포함 포맷으로 변형한 길이가 8보다 길면
				k08_length = 17;//length 변수에 17 저장
				System.out.printf("%s%11.11s%2.3s%11.11s\n",strForm(k08_taxCheck, k08_length), //출력부 숫자 길이 11로 늘리고 순차적으로 상품명, 단가, 수량, 금액 출력(금액과 관련된 숫자는 미리 지정해둔 콤마 추가 포맷으로 변경하여 출력
						k08_df.format(k08_itemPrice[k08_i]), k08_itemNum[k08_i] + "", k08_df.format(k08_itemPrice[k08_i] * k08_itemNum[k08_i]));
			}
			else {
				k08_length = 19;//length 변수에 19 저장
				System.out.printf("%s%9.9s%2.3s%11.11s\n",strForm(k08_taxCheck, k08_length), //출력부 숫자 길이 10로 지정하고 순차적으로 상품명, 단가, 수량, 금액 출력(금액과 관련된 숫자는 미리 지정해둔 콤마 추가 포맷으로 변경하여 출력
						k08_df.format(k08_itemPrice[k08_i]), k08_itemNum[k08_i] + "", k08_df.format(k08_itemPrice[k08_i] * k08_itemNum[k08_i]));
			}
			
			
			if ((k08_i + 1) % 5 == 0) {//i + 1을 5로 나눈 나머지 값이 0일 때, 구분선과 줄바꿈 출력
				System.out.printf("-----------------------------------------\n");
			}
			
		}
		
		k08_origin = (int)(k08_sumTax / 11.0 * 10);//과세항목 누적값을 1.1로 나눈 몫을 원가 변수에 저장
		k08_tax = k08_sumTax - k08_origin;//세금 = 총액 - 원가
		int k08_totalSum = k08_sumNoTax + k08_sumTax;//total sum 변수에 비과세항목 가격과 과세항목 가격 누적값의 합 저장
		
		System.out.printf("\n%22.25s%14.14s\n","총 품목 수량", k08_cnt + "");//총 물품 수량은 스트링 배열의 길이로 출력
		System.out.printf("%23.25s%14.14s\n","(*)면 세  물 품", k08_df.format(k08_sumNoTax));//면세항목 누적값 출력
		System.out.printf("%23.25s%14.14s\n","과 세  물 품", k08_df.format(k08_origin));//과세항목 원가 출력
		System.out.printf("%24.25s%14.14s\n","부   가   세", k08_df.format(k08_tax));//과세항목의 세금 출력
		System.out.printf("%25.25s%14.14s\n","합        계", k08_df.format(k08_totalSum));//합계에 총 금액 출력
		System.out.printf("결 제 대 상 금 액%24.20s\n", k08_df.format(k08_totalSum));// 결제 대상 금액에 합계와 동일하게 총 금액 출력
		System.out.printf("-----------------------------------------\n");//구분선 출력
		System.out.printf("0012 KEB 하나       541707**0484/35860658\n");//결제 카드 정보 출력
		System.out.printf("카드결제(IC)%26.26s\n","일시불/" + k08_df.format(k08_totalSum));//결제 방식 출력
		System.out.printf("-----------------------------------------\n");//구분선 출력
		System.out.printf("          [신세계 포인트 적립]\n");//포인트 정립내역 출력
		System.out.printf("김*비 고객님의 포인트 현황입니다.\n");//포인트 관련 안내 출력
		System.out.printf("금회발생포인트%19.20s%8.8s\n","9350**9995","164");//금번 발생 포인트 출력
		System.out.printf("누계(가용)포인트%25.25s\n","5,637(   5,473)");//총 사용 가능한 포인트 출력
		System.out.printf("*신세계포인트 유효기간은 2년입니다.\n");//포인트 유효기간 안내
		System.out.printf("-----------------------------------------\n");//구분선 출력
		System.out.printf("   구매금액기준 무료주차시간 자동부여\n");//무료 주차안내 출력
		System.out.printf("차량번호 :%30.30s\n","34저****");//차량번호 출력
		System.out.printf("입차시간 :%31.30s\n",k08_car.format(k08_carD));//입차시간 출력
		System.out.printf("-----------------------------------------\n");//구분선 출력
		System.out.printf("캐셔:084599 양00%25.25s\n","1150");//담당 캐셔 정보 출력
		System.out.printf("             l|l|l|l|l|l|l|\n");//바코드 임의
		System.out.printf("%14s/00119861/00164980/30",k08_last.format(k08_date)); //바코드 정보 출력

	}
	
	public static String strForm(String k08_temp, int k08_length) { // 스트링타입과 인티저타입을 인자로 받아 스트링을 리턴하는 매서드 선언
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