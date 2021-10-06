package Lecture05;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//20210412 김은비 영수증 출력2
public class Lecture5_5 { // 클래스 선언

	public static void main(String[] args) { // 메인에서 시작
		Date k08_date = new Date();//date 오브젝트 생성
		Date k08_after = new Date(k08_date.getTime() + (long)(1000 * 60 * 60 * 24 * 14));//위에 생성한 오브젝트의 시간에 14일을 더한 값을 리턴하는 날짜 오브젝트 생성
		DecimalFormat k08_df = new DecimalFormat("###,###,###"); // 숫자 콤마 출력 양식 설정
		SimpleDateFormat k08_last = new SimpleDateFormat("MM월dd일");//환불일 출력양식 설정
		SimpleDateFormat k08_sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"); // 심플 데이트 포맷을 이용해 영수증 내에 있었던 것과 동일한 날짜
																				
		String k08_itemname1 = "원목 악세사리함 3칸(로즈)"; // 첫번째 아이템 이름 스트링으로 지정 및 변수에 데이터 저장
		String k08_itemcode1 = "1031617";// 첫번째 아이템코드를 스트링타입으로 지정하고 변수에 데이터 저장
		int k08_price1 = 100000;// 첫번째 아이템의 가격 integer type 선언 및 데이터 저장
		int k08_amount1 = 22;// 첫번째 아이템 integer type으로 선언 및 수량 데이터 저장

		String k08_itemname2 = "땅콩군 파우치(황색) 15cm"; // 두번째 아이템 이름 스트링으로 지정 및 변수에 데이터 저장
		String k08_itemcode2 = "1104042";// 두번째 아이템코드 스트링타입으로 지정하고 변수에 데이터 저장
		int k08_price2 = 2000;// 두번째 아이템의 가격을 integer type으로 선언 및 데이터 저장
		int k08_amount2 = 3;// 두번째 아이템 integer type으로 선언 및 수량 데이터 저장

		String k08_itemname3 = "튼튼 개나리 유리컵(330ml)"; // 세번째 아이템 이름 스트링으로 지정 및 변수에 데이터 저장
		String k08_itemcode3 = "1811019";// 세번째 아이템코드를 스트링타입으로 지정, 변수에 데이터 저장
		int k08_price3 = 3000;// 세번째 아이템의 가격 integer type 선언 및 데이터 저장
		int k08_amount3 = 1;// 세번째 아이템 integer type 선언 및 변수에 수량 데이터 저장

		int k08_sumPrice = (k08_price1 * k08_amount1) + (k08_price2 * k08_amount2) + (k08_price3 * k08_amount3); // integer type의 변수 선언 및 아이템 가격의 총합 저장
		int k08_originPrice = (int) (k08_sumPrice / 11.0 * 10); // total price = original price + tax -> tp = orp + (orp * 0.1) -> orp = tp / 1.1
		int k08_taxPrice = k08_sumPrice - k08_originPrice; // tax값 = 총 합 - 총합의 원가

		System.out.printf("%22s\n","\"국민가게, 다이소\""); // 한줄 개행 후 제목부분 출력 큰따옴표는 역슬레시를 사용하여 표현
		System.out.printf("(주)아성다이소_분당서현점\n");// 지점명 출력
		System.out.printf("전화:031-702-6016\n");// 전화번호 출력
		System.out.printf("본사:서울 강남구 남부순환로 2748 (도곡동)\n");// 본사 주소 출력
		System.out.printf("대표:박정부,신호섭 213-81-52063\n");// 대표명과 사업자번호 출력
		System.out.printf("매장:경기도 성남시 분당구 분당로53번길 11 (서현동)\n");// 분당지점의 주소 출력
		System.out.printf("=========================================\n");// 구분선 출력
		System.out.printf("%23s\n%25s\n", "소비자중심경영(CCM) 인증기업", "ISO 9001 품질경영시스템 인증기업"); // 소비자 중심경영과 품질경영시스템 인증 내용 출력
		System.out.printf("=========================================\n");// 구분선 출력
		System.out.printf("     교환/환불 14일(%s)이내\n",k08_last.format(k08_after));// 교환, 환불의 가능 기간 출력
		System.out.printf("%23s\n%21s\n","(전자)영수증, 결제카드 지참 후","구입매장에서 가능");// 교환 환불 방법 안내 내용 출력
		System.out.printf("   포장/가격 택 훼손시 교환/환불 불가\n"); // 교환 환불 불가 내용 출력
		System.out.printf("     체크카드 취소 시 최대 7일 소요\n"); // 카드 취소 관련 내용 출력
		System.out.printf("=========================================\n");// 구분선 출력
		System.out.printf("[POS 1058231]%28s\n", k08_sdf.format(k08_date.getTime()));// 포스 번호와 미리 지정해둔 날짜 포맷으로 날짜 출력
		System.out.printf("=========================================\n");// 구분선 출력
		// blank메서드를 이용하여 아이템 이름을 원하는 글자수만큼 자르고 공백 부여, decimal format 이용하여 단가와 총
		// 가격(단가*수량)에 콤마 포함하여 출력
		System.out.printf("%s%10.10s%3.3s%10.10s\n", k08_blank(k08_itemname1, 18), k08_df.format(k08_price1), k08_amount1 + "",
				k08_df.format(k08_price1 * k08_amount1));
		System.out.printf("[%s]\n", k08_itemcode1);// 첫번째 아이템코드 출력
		// blank메서드를 이용하여 아이템 이름을 원하는 글자수만큼 자르고 공백 부여, decimal format 이용하여 단가와 총
		// 가격(단가*수량)에 콤마 포함하여 출력
		System.out.printf("%s%10.10s%3.3s%10.10s\n", k08_blank(k08_itemname2, 18), k08_df.format(k08_price2), k08_amount2 + "",
				k08_df.format(k08_price2 * k08_amount2));
		System.out.printf("[%s]\n", k08_itemcode2);// 두번째 아이템코드 출력
		// blank메서드를 이용하여 아이템 이름을 원하는 글자수만큼 자르고 공백 부여, decimal format 이용하여 단가와 총
		// 가격(단가*수량)에 콤마 포함하여 출력
		System.out.printf("%s%10.10s%3.3s%10.10s\n", k08_blank(k08_itemname3, 18), k08_df.format(k08_price3), k08_amount3 + "",
				k08_df.format(k08_price3 * k08_amount3));
		System.out.printf("[%s]\n", k08_itemcode3);// 세번째 아이템코드 출력
		System.out.printf("%16s%21.20s\n", "과세합계", k08_df.format(k08_originPrice));// 왼쪽 공백출력해주는 blank2메서드로
																								// 과세합계 글자 편집, 원가 합계 출력
		System.out.printf("%17.13s%21.20s\n", "부가세", k08_df.format(k08_taxPrice));// 왼쪽 공백출력해주는 blank2메서드로 부가세
																							// 글자 편집, 원가 합계의 세금 출력
		System.out.printf("-----------------------------------------\n");
		System.out.printf("판매합계%33s\n", k08_df.format(k08_sumPrice));// 지정된 숫자포맷으로 변환하여 총합계금액 출력
		System.out.printf("=========================================\n");// 구분선 출력
		System.out.printf("신용카드%33s\n", k08_df.format(k08_sumPrice));// 신용카드 결제금액은 판매합계와 동일한 금액으로 출력
		System.out.printf("-----------------------------------------\n");
		System.out.printf("우리카드                 538720**********\n");// 카드사 및 카드번호 출력
		// 결제 승인 번호와 승인 금액(판매합계) 출력 -> 금액이 많이 나와도 승인금액 글자와 유동적으로 움직이도록 한 스트링으로 하여 길이 지정
		System.out.printf("승인번호 77982843(0)%17.17s\n", "승인금액 " + k08_df.format(k08_sumPrice));
		System.out.printf("=========================================\n");// 구분선 출력
		System.out.printf("%24s 분당서현점\n", k08_sdf.format(k08_date.getTime()));// 지점명과 결제일자 출력
		System.out.printf("상품 및 기타 문의 : 1522-4400\n");// 상품 및 기타문의 번호 출력
		System.out.printf("멤버십 및 샵다이소 관련 문의 : 1599-2211\n\n");// 멤버십 및 다이소 관련 문의 번호 출력
		System.out.printf("            2112820610158231\n");// 바코드 번호 출력
		System.out.printf("-----------------------------------------\n");//구분선 출력
		// 브랜드 홈페이지 및 어플 홍보글 출력 (영수증 출력기에서 자동 줄바꿈이 되므로 따로 처리 x)
		System.out.println(" ◈ 다이소 멤버십 앱 또는 홈페이지에 접속하셔서 회원가입 후 다양한 혜택을 누려보세요! ◈");

	}

	public static String k08_blank(String k08_temp, int k08_length) { // 스트링 타입과 인티저 타입을 인자로 받고 스트링 타입을 리턴하는 메서드 선언
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
