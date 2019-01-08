package atmproject;

import java.util.Scanner;

public class atmtwo {
	static String[] names = new String[20];
	static String[] passwd = new String[20];
	static int[] allMoney = new int[20];
	static int count = 1;
	static String[] recond = new String[20];
	static int index = 0;
//���˵�
	static void mainMenu() {
		System.out.println("*********************************");
		System.out.println("***                           ***");
		System.out.println(" ***     ��ӭ����ATM!          ***");
		System.out.println("***   1��ע��    2����¼                    ***");
		System.out.println("*********************************");

	}

//��ʼ��
	static void initDate() {
		names[0] = "admin";
		passwd[0] = "123";
		allMoney[0] = 10000;

	}

//��һ��ѡ��
	static void optionChoose() {
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		if (option == 1) {
			register();
			mainMenu();
			optionChoose();
		} else {
			login();
		}
		// ע��
		// 1����֤�Ƿ����
		// 2���������1

	}

//�ڶ���ѡ��
	static void sencondoPtionChoose() {
		Scanner sc = new Scanner(System.in);
		int optionother = sc.nextInt();
		switch (optionother) {
		case 1:
			transferWithdraw();
		case 2:
			transferAccounts();
		case 3:
			select();
		case 4:
			mainMenu();
		case 5:
			getMoney();
		}
	}

//���
	static void transferWithdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���������˻�");
		String toAcc = sc.next();
		System.out.println("�������Ľ��");
		int saveMoney = sc.nextInt();
		int index_toAcc = decidedUser(toAcc);
		String a;
		if (index_toAcc >= 0) {
			allMoney[index_toAcc] += saveMoney;
			System.out.println("����ɹ�");
		
			recond[index]="���"+saveMoney+"Ԫ";
			index++;
			
			mainMenu();
			optionChoose();
			
		} else {
			System.out.println("�˺Ų����ڴ���ʧ��");
			System.exit(0);
		}

	}

//ȡǮ
	static void getMoney() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������˻�");
		String toAcc = sc.next();
		System.out.println("����ȡ���Ľ��");
		int getMoney = sc.nextInt();
		int index_toAcc = decidedUser(toAcc);
		if (index_toAcc >= 0) {
			if (allMoney[index_toAcc] >= getMoney) {
				System.out.println("ȡǮ�ɹ�");
				System.exit(0);
			} else {
				System.out.println("�û�����");
			}
		} else {
			System.out.println("�˺Ų����ڴ���ʧ��");
			System.exit(0);
		}

	}

//�ж��û���
//�ж��û��� �����±�
	static int decidedUser(String toAcc) {
		int index_toAcc = -1;
		for (int i = 0; i < names.length; i++) {
			if (toAcc.equals(names[i])) {
				index_toAcc = i; // �����˺���ͬ�����±�
			}

		}
		return index_toAcc;
	}
	// ת��

//ת�˹���
	static void transferAccounts() {
		Scanner sc = new Scanner(System.in);
		System.out.println("����ת����˻�");
		String toAcc = sc.next();
		System.out.println("����ת�˽��");
		int toMoney = sc.nextInt();
		// 1���ж��˻�
		int index_toAcc = decidedUser(toAcc);
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

	}

//��ѯ����
	// ��ѯ
	static void select() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�����ѯ���˻�");
		String toAcc = sc.next();
		int index_toAcc = decidedUser(toAcc);
		if (index_toAcc >= 0) {
			System.out.println("������Ϊ��" + allMoney[index_toAcc]);
			for(int i=0;i<3;i++) {
			System.out.println("������ϸ" + recond[i]);
			}
			System.exit(0);
		}
		System.exit(0);
	}

//��������
	// ��������
	static void subMenu() {
		System.out.println("��½�ɹ���");
		System.out.println("**************************");
		System.out.println("\t��������Ҫ���еĲ�����");
		System.out.println("\t1����� 2��ת�� 3�� ��ѯ 4��ע��5��ȡ��");
		System.out.println("**************************");
	}

//�����ж��û����Ƿ����
//�����ж��û���
	static boolean searchForAcc(String newusername) {
		boolean ifexist = false;
		// int a=Arrays.binarySearch(names, newusername )
		for (int i = 0; i < names.length; i++) {
			if (newusername.equals(names[i])) {
				System.out.println("�û����Ѵ���");
				ifexist = true;
				System.exit(0);

			}
		}
		return ifexist;
	}

//ע��
	// ע��
	static void register() {

		Scanner sc = new Scanner(System.in);
		System.out.println("������Ҫע����û�����");
		String newusername = sc.next();
		System.out.println("������Ҫע������룺");
		String newpassword = sc.next();
		// �˺ű����������У���֤�˺��Ƿ���� ���������Ҫ��������

		// int a=Arrays.binarySearch(names, newusername )
		boolean ifexist = searchForAcc(newusername);
		if (!ifexist) { // Ϊfalse��ͨ��
			System.out.println("ע��ɹ�");
			names[count] = newusername;
			passwd[count] = newpassword;
			count++;
		}
	}

//��¼
	// ��¼
	static void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û�����");
		String username = sc.next();
		System.out.println("���������룺");
		String password = sc.next();
		// int index=-1; Ϊ�˻�ȡ�±�Ӷ��ж������Ƿ���ȷ
		for (int j = 0; j < names.length; j++) {
			if (username.equals(names[j]) && password.equals(passwd[j])) {
				subMenu();
				sencondoPtionChoose();
			}
		}
	}

//������
	// ������
	public static void main(String[] args) {
		initDate();
		mainMenu();
		optionChoose();
	}
}
