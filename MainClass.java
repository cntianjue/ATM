package atmproject;

import java.util.Arrays;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class MainClass {

	public static void main(String[] args) {
		// ԭ��
		// 1.java�е��ն���Ŀ��ֻ��һ�����Ե��߳�
		// 2.java���������Ե���Ŀ�����ȴ�����滯����
		// 3.�����������Ȳɼ����ж��塢�ֶ�ʹ�õķ�ʽ

		// ʵ�ֲ���
		// 1�����延ӭ���� sysout
		// 2������˵�����
		// 3�����һ���û������ѡ�Ȼ���жϣ���¼��ע�ᣩ scanner���� if�ж�
		// 4����¼���ж��˺�����
		// 5��ע�᣺�����µ��˺š�����
		// ��ѯ ת�� ȡ�� ���
while(true) {
		System.out.println("*********************************");
		System.out.println("***                           ***");
		System.out.println(" ***     ��ӭ����ATM!          ***");
		System.out.println("***   1��ע��    2����¼       ***");
		System.out.println("*********************************");
//		String[] names = { "admin", "", "" };
//		String[] passwd = { "123456", "", "" }; else {

		// �����˺����������
		String[] names = new String[20];
		String[] passwd = new String[20];
		int[] allMoney = new int[20];
		names[0] = "admin";
		passwd[0] = "123";
		allMoney[0] = 10000;
		// countΪ�ȴ����Ѿ��е�������ͬʱҲ������һ��ע�����ݴ���Ľű꣬��ȻҲ����ͨ��ѭ���жϿ�Ȼ��д������
		int count = 1;
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		switch (option) {
		// ע��
		// 1����֤�Ƿ����
		// 2���������1
		case 1:
			System.out.println("������Ҫע����û�����");
			String newusername = sc.next();
			System.out.println("������Ҫע������룺");
			String newpassword = sc.next();
			// �˺ű����������У���֤�˺��Ƿ���� ���������Ҫ��������
			boolean ifexist = false;
			// int a=Arrays.binarySearch(names, newusername )
			for (int i = 0; i < names.length; i++) {
				if (newusername.equals(names[i])) {
					System.out.println("�û����Ѵ���");
					ifexist = true;
					break;
				}
			}
			if (!ifexist) { // Ϊfalse��ͨ��
				System.out.println("ע��ɹ�");
				names[count] = newusername;
				passwd[count] = newpassword;
				count++;
			}
			break;

		case 2:
			System.out.println("�������û�����");
			String username = sc.next();
			System.out.println("���������룺");
			String password = sc.next();
			// int index=-1; Ϊ�˻�ȡ�±�Ӷ��ж������Ƿ���ȷ

			for (int j = 0; j < names.length; j++) {
				if (username.equals(names[j]) && password.equals(passwd[j])) {
					System.out.println("��½�ɹ���");
					System.out.println("**************************");
					System.out.println("\t��������Ҫ���еĲ�����");
					System.out.println("\t1����ȡ�� 2��ת�� 3�� ��ѯ 4��ע��");
					System.out.println("**************************");
					int optionother = sc.nextInt();
					switch (optionother) {
					case 1: // ��ȡ��
						System.out.println("���������˻�");
						String saveAcc = sc.next();
						System.out.println("�������Ľ��");
						int saveMoney = sc.nextInt();
						int index_saveAcc = -1;
						for (int i = 0; i < names.length; i++) {
							if (saveAcc.equals(names[i])) {
								index_saveAcc = i; // �����˺���ͬ�����±�
							}

						}
						if (index_saveAcc >= 0) {
							allMoney[index_saveAcc] += saveMoney;
							System.out.println("����ɹ�");
							System.exit(0);
						} else {
							System.out.println("�˺Ų����ڴ���ʧ��");
							System.exit(0);
						}

					case 2: // ת�� ת��˭ ת����Ǯ
						System.out.println("����ת����˻�");
						String toAcc = sc.next();
						System.out.println("����ת�˽��");
						int toMoney = sc.nextInt();
						// 1���ж��˻�
						int index_toAcc = -1;
						for (int i = 0; i < names.length; i++) {
							if (toAcc.equals(names[i])) {
								index_toAcc = i; // �����˺���ͬ�����±�
							}

						}
						if (index_toAcc >= 0) {
							if (allMoney[0] > toMoney) {
								allMoney[index_toAcc] += toMoney;
								allMoney[0] -= toMoney;
								System.out.println("ת�ɹ�");

								System.exit(0);
							} else {
								System.out.println("����");
							}

						} else {
							System.out.println("�˺Ų����������²���");
						}

						// 2���жϽ��

						// 3.ת�˲����ֹ�������

						break;
					case 3: // ��ѯ
						System.out.println("���������˻�");
						String selectAcc = sc.next();
						int index_selectAcc = -1;
						for (int i = 0; i < names.length; i++) {
							if (selectAcc.equals(names[i])) {
								index_selectAcc = i; // �����˺���ͬ�����±�
							}
						}
						if (index_selectAcc >= 0) {
							System.out.println("������Ϊ��" + allMoney[index_selectAcc]);
							System.exit(0);
						}
						System.exit(0);
					case 4: // ע��
						System.exit(0);
					default:
						System.out.println("�������ѡ������");
						System.exit(0);
					}
					

				} else {
					System.out.println("��¼ʧ��!");
					System.exit(0);
				}
				
			}

		
		}
      }
	}
}
