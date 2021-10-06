package JavaExe;

public class ExchangeMoneyMethods {
	
	public String getMoney(int type, int money) {
		
		double ExchangedMoney = 0;
		int returnMoney = 0; //final return money
		int returnWon = 0; // change that is left after exchange
		int typeInArray = type - 1; // type number in array is type - 1
		
		ExchangedMoney = money / CostValue.currency[typeInArray]; 
		//get exchanged money as integer type that we can actually get from bank : paper
		if (type == CostValue.typeUSD) {
			returnMoney = (int)ExchangedMoney;
			
		} else if (type == CostValue.typeEUR) {
			returnMoney = (int)(ExchangedMoney - (ExchangedMoney % 5));
				
		} else if (type == CostValue.typeJPY) {
			returnMoney = (int)(ExchangedMoney - (ExchangedMoney % 1000));
			
		} 
		//get rest of money as KRW
		returnWon = (int)((ExchangedMoney - returnMoney) * CostValue.currency[typeInArray]);
		returnWon -= returnWon % 10;
		
		//calculate the balance left after exchange
		if (returnMoney <= CostValue.BALANCE[typeInArray]) {
			CostValue.BALANCE[typeInArray] = CostValue.BALANCE[typeInArray] - returnMoney;
			
			PrintAllResult.printExchangeMoney(type, returnMoney);
			int[] sortForeign = Sort(type, returnMoney);
			
			PrintAllResult.printExchangeMoney(CostValue.typeChange, returnWon);
			int[] sortWon = Sort(CostValue.typeChange, returnWon);
			
			 
			String exFormat = FileReadAndWrite.ExFormat(sortForeign, type, true);
			String wonFormat = FileReadAndWrite.WonFormat(sortWon, true); 
			
			PrintAllResult.printRest(typeInArray, true);
			
			return FileReadAndWrite.allWriteFormat(money, typeInArray, returnWon, 
					returnMoney, exFormat, wonFormat, true); //return string to write on csv file
			
		} else {
			PrintAllResult.printRest(typeInArray, false);
			
			int[] nothing = new int[1]; //fake array
			String exFormat = FileReadAndWrite.ExFormat(nothing, type, false);
			String wonFormat = FileReadAndWrite.WonFormat(nothing, false);
			
			return FileReadAndWrite.allWriteFormat(money, typeInArray, returnWon, 
					returnMoney, exFormat, wonFormat, false); //return string to write on csv file
		}
	}
	
	public static int[] Sort(int type, int money) {
		int[] kind = null;
		String[] print = null;
		switch(type) {
		case CostValue.typeUSD:
			kind = CostValue.dollar;
			print = CostValue.print_dollar;
			break;
			
		case CostValue.typeEUR:
			kind = CostValue.euro;
			print = CostValue.print_euro;
			break;
			
		case CostValue.typeJPY:
			kind = CostValue.yen;
			print = CostValue.print_jpy;
			break;
			
		case CostValue.typeChange:
			kind = CostValue.won_arr;
			print = CostValue.print_won;
			break;
			
		}
		
		int [] sort = new int[kind.length];
		for (int i = 0; i < kind.length; i++) {
				sort[i] = money / kind[i];
				money = money % kind[i];
		}
		PrintAllResult.printResult(sort, print);
		
		return sort;
	}
}
	