package Lecture05;
//20210412 ������ �޷� ���
public class Lecture5_3 {

	public static void main(String[] args) {
int k08_iWeekday = 5; //���ϴ� 0~6���̷� �ΰ� 1�� ù �������� �ݿ��Ϸ� ���߱� ���� 6��° ���� 5�� �ʱ�ȭ
		
		int[] k08_iEnd = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//���� ������ ���� �迭�� ����, 2�� ���޷� 29���� ����
		
		//��Ƽ��Ÿ�� ���� ���� �� �ʱ�ȭ
		//for���� 12������ �� �� �ֵ��� 0 ~ 11�� ����
		for (int k08_iMon = 0; k08_iMon < 12; k08_iMon++) {
			System.out.printf("\n\n         %d��\n", k08_iMon + 1); //i�� 0���� �����ϹǷ� i + 1���� ����ؾ���
			System.out.printf("=====================\n");//���м� ���
			System.out.printf("�� �� ȭ �� �� �� ��\n");//���� ���
			for (int k08_i = 1; k08_i <= k08_iEnd[k08_iMon]; k08_i++) {//���� for�� ������ ��¥��ŭ �� �� �ֵ��� 1 ~ �ش� ���� ������ ���� ���� ���� 
				if (k08_i == 1 && k08_iWeekday != 0) { //i�� 1���̰� week day�� 0�� �ƴҶ�
					for (int k08_j = 0; k08_j < k08_iWeekday; k08_j++) {//weekday�� ����ŭ
						System.out.printf("%3.3s", "");//���� ���
					}
					System.out.printf("%3.3s", k08_i + " ");//���� 1�� ���
				} else {
					System.out.printf("%3.3s", k08_i + " ");//�ƴ϶�� ������ �������� ��¥ ���
				}
				k08_iWeekday++; // weekday + 1�� �߰�
				if (k08_iWeekday == 7) { //weekday�� 7�� �Ǹ�
					k08_iWeekday = 0; //0���� �ʱ�ȭ
					System.out.printf("\n");//�ٹٲ�
				}
			}
		}

	}

}