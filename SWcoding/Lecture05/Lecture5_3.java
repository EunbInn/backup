package Lecture05;
//20210412 김은비 달력 출력
public class Lecture5_3 {

	public static void main(String[] args) {
int k08_iWeekday = 5; //요일당 0~6사이로 두고 1월 첫 시작일을 금요일로 맞추기 위해 6번째 날인 5로 초기화
		
		int[] k08_iEnd = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//월별 마지막 날을 배열에 저장, 2월 윤달로 29일이 말일
		
		//인티저타입 변수 선언 및 초기화
		//for문을 12월까지 돌 수 있도록 0 ~ 11로 지정
		for (int k08_iMon = 0; k08_iMon < 12; k08_iMon++) {
			System.out.printf("\n\n         %d월\n", k08_iMon + 1); //i가 0부터 시작하므로 i + 1월로 출력해야함
			System.out.printf("=====================\n");//구분선 출력
			System.out.printf("일 월 화 수 목 금 토\n");//요일 출력
			for (int k08_i = 1; k08_i <= k08_iEnd[k08_iMon]; k08_i++) {//이중 for문 내에는 날짜만큼 돌 수 있도록 1 ~ 해당 월의 마지막 날로 범위 설정 
				if (k08_i == 1 && k08_iWeekday != 0) { //i가 1일이고 week day가 0이 아닐때
					for (int k08_j = 0; k08_j < k08_iWeekday; k08_j++) {//weekday의 수만큼
						System.out.printf("%3.3s", "");//공백 출력
					}
					System.out.printf("%3.3s", k08_i + " ");//이후 1일 출력
				} else {
					System.out.printf("%3.3s", k08_i + " ");//아니라면 정해진 포맷으로 날짜 출력
				}
				k08_iWeekday++; // weekday + 1씩 추가
				if (k08_iWeekday == 7) { //weekday가 7이 되면
					k08_iWeekday = 0; //0으로 초기화
					System.out.printf("\n");//줄바꿈
				}
			}
		}

	}

}