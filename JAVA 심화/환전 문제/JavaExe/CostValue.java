package JavaExe;

public class CostValue {
	final static int typeUSD = 1;
	final static int typeEUR = 2;
	final static int typeJPY = 3;
	final static int typeChange =4;
	
	final static int[] dollar = {100,50,20,10,5,1};
	final static int[] euro = {100,50,20,10,5};
	final static int[] yen = {10000,5000,2000,1000};
	final static int[] won_arr = {10000,5000,1000,500,100,50,10};
	
	final static String[] print_dollar = {"100달러","50달러","20달러","10달러","5달러","1달러"};
	final static String[] print_euro = {"100유로","50유로","20유로","10유로","5유로"};
	final static String[] print_jpy = {"10000엔","5000엔","2000엔","1000엔"};
	final static String[] print_won = {"10000원","5000원","1000원","500원","100원","50원", "10원"};
	
	final static String[] nameMoney = {"달러(USD)","유로(EUR)","엔화(JPY)"};
	
	final static double[] currency = {1134.30, 1333.17, 10.31}; //dollar, euro, jpy
	
	public static int[] BALANCE = {500, 500, 100000}; //dollar, euro, jpy
	
}
