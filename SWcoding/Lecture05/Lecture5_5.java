package Lecture05;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//20210412 ������ ������ ���2
public class Lecture5_5 { // Ŭ���� ����

	public static void main(String[] args) { // ���ο��� ����
		Date k08_date = new Date();//date ������Ʈ ����
		Date k08_after = new Date(k08_date.getTime() + (long)(1000 * 60 * 60 * 24 * 14));//���� ������ ������Ʈ�� �ð��� 14���� ���� ���� �����ϴ� ��¥ ������Ʈ ����
		DecimalFormat k08_df = new DecimalFormat("###,###,###"); // ���� �޸� ��� ��� ����
		SimpleDateFormat k08_last = new SimpleDateFormat("MM��dd��");//ȯ���� ��¾�� ����
		SimpleDateFormat k08_sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"); // ���� ����Ʈ ������ �̿��� ������ ���� �־��� �Ͱ� ������ ��¥
																				
		String k08_itemname1 = "���� �Ǽ��縮�� 3ĭ(����)"; // ù��° ������ �̸� ��Ʈ������ ���� �� ������ ������ ����
		String k08_itemcode1 = "1031617";// ù��° �������ڵ带 ��Ʈ��Ÿ������ �����ϰ� ������ ������ ����
		int k08_price1 = 100000;// ù��° �������� ���� integer type ���� �� ������ ����
		int k08_amount1 = 22;// ù��° ������ integer type���� ���� �� ���� ������ ����

		String k08_itemname2 = "���ᱺ �Ŀ�ġ(Ȳ��) 15cm"; // �ι�° ������ �̸� ��Ʈ������ ���� �� ������ ������ ����
		String k08_itemcode2 = "1104042";// �ι�° �������ڵ� ��Ʈ��Ÿ������ �����ϰ� ������ ������ ����
		int k08_price2 = 2000;// �ι�° �������� ������ integer type���� ���� �� ������ ����
		int k08_amount2 = 3;// �ι�° ������ integer type���� ���� �� ���� ������ ����

		String k08_itemname3 = "ưư ������ ������(330ml)"; // ����° ������ �̸� ��Ʈ������ ���� �� ������ ������ ����
		String k08_itemcode3 = "1811019";// ����° �������ڵ带 ��Ʈ��Ÿ������ ����, ������ ������ ����
		int k08_price3 = 3000;// ����° �������� ���� integer type ���� �� ������ ����
		int k08_amount3 = 1;// ����° ������ integer type ���� �� ������ ���� ������ ����

		int k08_sumPrice = (k08_price1 * k08_amount1) + (k08_price2 * k08_amount2) + (k08_price3 * k08_amount3); // integer type�� ���� ���� �� ������ ������ ���� ����
		int k08_originPrice = (int) (k08_sumPrice / 11.0 * 10); // total price = original price + tax -> tp = orp + (orp * 0.1) -> orp = tp / 1.1
		int k08_taxPrice = k08_sumPrice - k08_originPrice; // tax�� = �� �� - ������ ����

		System.out.printf("%22s\n","\"���ΰ���, ���̼�\""); // ���� ���� �� ����κ� ��� ū����ǥ�� �������ø� ����Ͽ� ǥ��
		System.out.printf("(��)�Ƽ����̼�_�д缭����\n");// ������ ���
		System.out.printf("��ȭ:031-702-6016\n");// ��ȭ��ȣ ���
		System.out.printf("����:���� ������ ���μ�ȯ�� 2748 (���)\n");// ���� �ּ� ���
		System.out.printf("��ǥ:������,��ȣ�� 213-81-52063\n");// ��ǥ��� ����ڹ�ȣ ���
		System.out.printf("����:��⵵ ������ �д籸 �д��53���� 11 (������)\n");// �д������� �ּ� ���
		System.out.printf("=========================================\n");// ���м� ���
		System.out.printf("%23s\n%25s\n", "�Һ����߽ɰ濵(CCM) �������", "ISO 9001 ǰ���濵�ý��� �������"); // �Һ��� �߽ɰ濵�� ǰ���濵�ý��� ���� ���� ���
		System.out.printf("=========================================\n");// ���м� ���
		System.out.printf("     ��ȯ/ȯ�� 14��(%s)�̳�\n",k08_last.format(k08_after));// ��ȯ, ȯ���� ���� �Ⱓ ���
		System.out.printf("%23s\n%21s\n","(����)������, ����ī�� ���� ��","���Ը��忡�� ����");// ��ȯ ȯ�� ��� �ȳ� ���� ���
		System.out.printf("   ����/���� �� �Ѽս� ��ȯ/ȯ�� �Ұ�\n"); // ��ȯ ȯ�� �Ұ� ���� ���
		System.out.printf("     üũī�� ��� �� �ִ� 7�� �ҿ�\n"); // ī�� ��� ���� ���� ���
		System.out.printf("=========================================\n");// ���м� ���
		System.out.printf("[POS 1058231]%28s\n", k08_sdf.format(k08_date.getTime()));// ���� ��ȣ�� �̸� �����ص� ��¥ �������� ��¥ ���
		System.out.printf("=========================================\n");// ���м� ���
		// blank�޼��带 �̿��Ͽ� ������ �̸��� ���ϴ� ���ڼ���ŭ �ڸ��� ���� �ο�, decimal format �̿��Ͽ� �ܰ��� ��
		// ����(�ܰ�*����)�� �޸� �����Ͽ� ���
		System.out.printf("%s%10.10s%3.3s%10.10s\n", k08_blank(k08_itemname1, 18), k08_df.format(k08_price1), k08_amount1 + "",
				k08_df.format(k08_price1 * k08_amount1));
		System.out.printf("[%s]\n", k08_itemcode1);// ù��° �������ڵ� ���
		// blank�޼��带 �̿��Ͽ� ������ �̸��� ���ϴ� ���ڼ���ŭ �ڸ��� ���� �ο�, decimal format �̿��Ͽ� �ܰ��� ��
		// ����(�ܰ�*����)�� �޸� �����Ͽ� ���
		System.out.printf("%s%10.10s%3.3s%10.10s\n", k08_blank(k08_itemname2, 18), k08_df.format(k08_price2), k08_amount2 + "",
				k08_df.format(k08_price2 * k08_amount2));
		System.out.printf("[%s]\n", k08_itemcode2);// �ι�° �������ڵ� ���
		// blank�޼��带 �̿��Ͽ� ������ �̸��� ���ϴ� ���ڼ���ŭ �ڸ��� ���� �ο�, decimal format �̿��Ͽ� �ܰ��� ��
		// ����(�ܰ�*����)�� �޸� �����Ͽ� ���
		System.out.printf("%s%10.10s%3.3s%10.10s\n", k08_blank(k08_itemname3, 18), k08_df.format(k08_price3), k08_amount3 + "",
				k08_df.format(k08_price3 * k08_amount3));
		System.out.printf("[%s]\n", k08_itemcode3);// ����° �������ڵ� ���
		System.out.printf("%16s%21.20s\n", "�����հ�", k08_df.format(k08_originPrice));// ���� ����������ִ� blank2�޼����
																								// �����հ� ���� ����, ���� �հ� ���
		System.out.printf("%17.13s%21.20s\n", "�ΰ���", k08_df.format(k08_taxPrice));// ���� ����������ִ� blank2�޼���� �ΰ���
																							// ���� ����, ���� �հ��� ���� ���
		System.out.printf("-----------------------------------------\n");
		System.out.printf("�Ǹ��հ�%33s\n", k08_df.format(k08_sumPrice));// ������ ������������ ��ȯ�Ͽ� ���հ�ݾ� ���
		System.out.printf("=========================================\n");// ���м� ���
		System.out.printf("�ſ�ī��%33s\n", k08_df.format(k08_sumPrice));// �ſ�ī�� �����ݾ��� �Ǹ��հ�� ������ �ݾ����� ���
		System.out.printf("-----------------------------------------\n");
		System.out.printf("�츮ī��                 538720**********\n");// ī��� �� ī���ȣ ���
		// ���� ���� ��ȣ�� ���� �ݾ�(�Ǹ��հ�) ��� -> �ݾ��� ���� ���͵� ���αݾ� ���ڿ� ���������� �����̵��� �� ��Ʈ������ �Ͽ� ���� ����
		System.out.printf("���ι�ȣ 77982843(0)%17.17s\n", "���αݾ� " + k08_df.format(k08_sumPrice));
		System.out.printf("=========================================\n");// ���м� ���
		System.out.printf("%24s �д缭����\n", k08_sdf.format(k08_date.getTime()));// ������� �������� ���
		System.out.printf("��ǰ �� ��Ÿ ���� : 1522-4400\n");// ��ǰ �� ��Ÿ���� ��ȣ ���
		System.out.printf("����� �� �����̼� ���� ���� : 1599-2211\n\n");// ����� �� ���̼� ���� ���� ��ȣ ���
		System.out.printf("            2112820610158231\n");// ���ڵ� ��ȣ ���
		System.out.printf("-----------------------------------------\n");//���м� ���
		// �귣�� Ȩ������ �� ���� ȫ���� ��� (������ ��±⿡�� �ڵ� �ٹٲ��� �ǹǷ� ���� ó�� x)
		System.out.println(" �� ���̼� ����� �� �Ǵ� Ȩ�������� �����ϼż� ȸ������ �� �پ��� ������ ����������! ��");

	}

	public static String k08_blank(String k08_temp, int k08_length) { // ��Ʈ�� Ÿ�԰� ��Ƽ�� Ÿ���� ���ڷ� �ް� ��Ʈ�� Ÿ���� �����ϴ� �޼��� ����
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
