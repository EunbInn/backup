package JavaExe;

public class PrintAllResult {
	
	public static void printExchangeMoney(int type, int Money) {
		switch(type) {
		case CostValue.typeUSD:
			System.out.println("> 환전 달러: " + Money + " 달러\n"
					+ "(환율: 1 달러 = " + CostValue.currency[0] + " 원)");
			break;
		case CostValue.typeEUR:
			System.out.println("> 환전 유로: " + Money + " 유로\n"
					+ "(환율: 1 유로 = " + CostValue.currency[1] + " 원)");
			break;
		
		case CostValue.typeJPY:
			System.out.println("> 환전 엔화: " + Money + " 엔\n"
					+ "(환율: 1 엔 = " + CostValue.currency[2] + " 원)");
			break;
		
		case CostValue.typeChange:
			System.out.println("\n> 거스릅 돈: " + Money + " 원");
			break;
		}
	}
	
	public static void printResult(int[] sort, String[] print) {
		for (int i = 0; i < print.length; i++) {
			if (sort[i] != 0) {
				System.out.println(print[i] + ":\t" + sort[i] + " 개");
			}				
		}
	}
	
	public static void printRest(int type, boolean rest) {
		if (rest == true) {
			System.out.println("\n*" + CostValue.nameMoney[type] 
								+ "잔액 : "  + CostValue.BALANCE[type] + "\n");
		} else {
			System.out.println(">> " + CostValue.nameMoney[type]
								+ "잔고가 부족합니다. \n");
		}
	}
	
}
