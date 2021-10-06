package Lecture05;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

//20210412 ������ ������ ���
public class Lecture5_4 {

	public static void main(String[] args) {//���ο��� ����
		DecimalFormat k08_df = new DecimalFormat("###,###,###");//decimal format���� ���� ���� ����(�޸����)
		Calendar k08_cal = Calendar.getInstance();//�ý��� ��¥�� �̿��ϱ� ���� calendar.getInstance() ���
		SimpleDateFormat k08_sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // ��¥ ������ �������� ���� ���˰� ��ġ��Ű��
		
		Scanner k08_sc = new Scanner(System.in);//������ �Է¹��� ��ĳ�� ������Ʈ ����

		int k08_iTax, k08_iOrigin; //���ݰ� ���� ������ ������ ���� Ÿ�� ���� �� ����
		int k08_iPrice = k08_sc.nextInt();//������ integer type���� �Է¹���
		// price = origin(1 + 0.1)
		// origin = price / 1.1 -> 1.1 ���ϸ� ���� �̻��ϰ� ������ ��찡 �����Ƿ� 1.1 = (11.0 * 10)�� ���� �Ͽ� ���  
		k08_iOrigin = (int) (k08_iPrice / 11.0 * 10);
		k08_iTax = k08_iPrice - k08_iOrigin;// tax = price - origin
		


		System.out.printf("�ſ����\n");//������ �ֻ�� ���� ���
		System.out.printf("%s%18.20s\n", "�ܸ��� : 2N68665898", "��ǥ��ȣ : 041218");//��� �ܸ��� ��ȣ�� ��ǥ��ȣ ���
		System.out.printf("������ : �Ѿ��ġ�\n");//���Ը� ���
		System.out.printf("��  �� : ��� ������ �д籸 Ȳ����� 351���� 10 , 1��\n");//���� �ּ� ���
		System.out.printf("��ǥ�� : ��â��\n");//���� ��ǥ�� ���
		System.out.printf("%s%20.20s\n", "����� : 752-53-00558", "TEL : 7055695");//����ڹ�ȣ �� ���� ��ȭ��ȣ ���
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n");//���м� ���
		System.out.printf("%s%18.20s ��\n",k08_blank("��    ��",20), k08_df.format(k08_iOrigin));//�̸� �����ص� �������� ���� ���
		System.out.printf("%s%18.20s ��\n",k08_blank("�� �� ��", 20), k08_df.format(k08_iTax));//�̸� �����ص� �������� ���� ���
		System.out.printf("%s%18.20s ��\n",k08_blank("��    ��", 20), k08_df.format(k08_iPrice));//�̸� �����ص� �������� �Ѿ� ���(�Է¹��� �ݾ�)
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n");//���м� ���
		System.out.printf("�츮ī��\n");//�̿� ī�� ���
		System.out.printf("%s%5.6s\n", "ī���ȣ : 5387-20**-****-4613(S)", "�Ͻú�");//ī���ȣ �� ���� ��� ���
		System.out.printf("�ŷ��Ͻ� : %s\n", k08_sdf.format(k08_cal.getTime()));//�̸������ص� ��¥ Ÿ������ ��ȯ�Ͽ� �ŷ��Ͻ� �ý��� ��¥�� ���
		System.out.printf("���ι�ȣ : 70404427\n");//���� ���ι�ȣ ���
		System.out.printf("�ŷ���ȣ : 357734873739\n");//���� �ŷ� ��ȣ ���
		System.out.printf("%s%20s\n", "���� : ��ī���", "���� : 720068568");//���� ó�� ī���� �� ������ ��ȣ ���
		System.out.printf("�˸� : EDC����ǥ\n");//�˸� ���
		System.out.printf("���� : TEL)1544-4700\n");//���� ��ȣ ���
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n");//���м� ���
		System.out.printf("%23s\n", "* �����մϴ� *");//������ ���
		System.out.printf("%39s\n", "ǥ��v2.08_20200212"); //���� ���

	}
	
	public static String k08_blank(String k08_temp, int k08_length) {//��Ʈ�� Ÿ�԰� ��Ƽ�� Ÿ���� ���ڷ� �ް� ��Ʈ�� Ÿ���� �����ϴ� �޼��� ����
		int k08_blank = 0;
		if (k08_temp.getBytes().length <= k08_length) { // ���� ���ڿ��� ����Ʈ�� ���ϴ� �ڸ��� ����Ʈ���� ���� ���
			k08_blank = (k08_length) - k08_temp.getBytes().length; //���� ���� = ���ϴ� ��� ����Ʈ�� - ���ڷ� ���� ���ڿ� ����Ʈ ��
			for (int i = 0; i < k08_blank; i++) { //������ ���� ������ ���̸�ŭ �ݺ��� ����
				k08_temp += " "; // ���ڿ��� ���� �߰�
			}
			return k08_temp; // ������ ���ڿ� ����

		} else { //���ڿ��� ����Ʈ ���� ���ϴ� ����Ʈ �� ���� Ŭ ���
			int k08_cnt = 0; //��Ƽ��Ÿ�� ���� ���� �� 0���� �ʱ�ȭ
			String k08_text = ""; //��Ʈ��Ÿ�� ������Ʈ ���� �� ""�� �ʱ�ȭ
			for (char k08_ch : k08_temp.toCharArray()) { //ĳ���� Ÿ�� ���� ����, ���ڷ� ���� ���ڿ��� ĳ���� �迭�� �ְ� �迭 ���̸�ŭ �ݺ��� ����
				k08_cnt += String.valueOf(k08_ch).getBytes().length; //ī��Ʈ ������ �ѱ��ڸ����� ����Ʈ���� ����
				if (k08_cnt > k08_length) break; //ī��Ʈ�� ���ϴ� ���� ����Ʈ ������ Ŀ���� �ݺ��� Ż�� 
				k08_text += String.valueOf(k08_ch);//ī��Ʈ�� ���ϴ� ���� ����Ʈ ������ Ŀ���� ������ �ؽ�Ʈ�� �ѱ��ھ� ����
			}

			k08_blank = k08_length - k08_text.getBytes().length;//���� ���� = ���ϴ� ��� ����Ʈ�� - ���ڷ� ���� ���ڿ� ����Ʈ ��
			for (int i = 0; i < k08_blank; i++) {//������ ���� ������ ���̸�ŭ �ݺ��� ����
				k08_text += " ";// ���ڿ��� ���� �߰�
			}
			return k08_text;//������ ���ڿ� ����
		}
	}

}