package atmproject;

import java.util.Scanner;

public class atmtwo {
	static String[] names = new String[20];
	static String[] passwd = new String[20];
	static int[] allMoney = new int[20];
	static int count = 1;
	static String[] recond = new String[20];
	static int index = 0;
//主菜单
	static void mainMenu() {
		System.out.println("*********************************");
		System.out.println("***                           ***");
		System.out.println(" ***     欢迎来到ATM!          ***");
		System.out.println("***   1、注册    2、登录                    ***");
		System.out.println("*********************************");

	}

//初始化
	static void initDate() {
		names[0] = "admin";
		passwd[0] = "123";
		allMoney[0] = 10000;

	}

//第一次选择
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
		// 注册
		// 1、验证是否存在
		// 2、存进数组1

	}

//第二次选择
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

//存款
	static void transferWithdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入存入的账户");
		String toAcc = sc.next();
		System.out.println("输入存入的金额");
		int saveMoney = sc.nextInt();
		int index_toAcc = decidedUser(toAcc);
		String a;
		if (index_toAcc >= 0) {
			allMoney[index_toAcc] += saveMoney;
			System.out.println("存入成功");
		
			recond[index]="存款"+saveMoney+"元";
			index++;
			
			mainMenu();
			optionChoose();
			
		} else {
			System.out.println("账号不存在存入失败");
			System.exit(0);
		}

	}

//取钱
	static void getMoney() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入账户");
		String toAcc = sc.next();
		System.out.println("输入取出的金额");
		int getMoney = sc.nextInt();
		int index_toAcc = decidedUser(toAcc);
		if (index_toAcc >= 0) {
			if (allMoney[index_toAcc] >= getMoney) {
				System.out.println("取钱成功");
				System.exit(0);
			} else {
				System.out.println("用户余额不足");
			}
		} else {
			System.out.println("账号不存在存入失败");
			System.exit(0);
		}

	}

//判断用户名
//判断用户名 返回下标
	static int decidedUser(String toAcc) {
		int index_toAcc = -1;
		for (int i = 0; i < names.length; i++) {
			if (toAcc.equals(names[i])) {
				index_toAcc = i; // 发现账号相同保留下标
			}

		}
		return index_toAcc;
	}
	// 转账

//转账功能
	static void transferAccounts() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入转入的账户");
		String toAcc = sc.next();
		System.out.println("输入转账金额");
		int toMoney = sc.nextInt();
		// 1、判断账户
		int index_toAcc = decidedUser(toAcc);
		if (index_toAcc >= 0) {
			if (allMoney[0] > toMoney) {
				allMoney[index_toAcc] += toMoney;
				allMoney[0] -= toMoney;
				System.out.println("转成功");

				System.exit(0);
			} else {
				System.out.println("余额不足");
			}

		} else {
			System.out.println("账号不存在请重新操作");
		}

	}

//查询功能
	// 查询
	static void select() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入查询的账户");
		String toAcc = sc.next();
		int index_toAcc = decidedUser(toAcc);
		if (index_toAcc >= 0) {
			System.out.println("你的余额为：" + allMoney[index_toAcc]);
			for(int i=0;i<3;i++) {
			System.out.println("近期明细" + recond[i]);
			}
			System.exit(0);
		}
		System.exit(0);
	}

//二级界面
	// 二级界面
	static void subMenu() {
		System.out.println("登陆成功！");
		System.out.println("**************************");
		System.out.println("\t请输入你要进行的操作：");
		System.out.println("\t1、存款 2、转账 3、 查询 4、注销5、取款");
		System.out.println("**************************");
	}

//布尔判断用户名是否存在
//布尔判断用户名
	static boolean searchForAcc(String newusername) {
		boolean ifexist = false;
		// int a=Arrays.binarySearch(names, newusername )
		for (int i = 0; i < names.length; i++) {
			if (newusername.equals(names[i])) {
				System.out.println("用户名已存在");
				ifexist = true;
				System.exit(0);

			}
		}
		return ifexist;
	}

//注册
	// 注册
	static void register() {

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要注册的用户名：");
		String newusername = sc.next();
		System.out.println("请输入要注册的密码：");
		String newpassword = sc.next();
		// 账号保存在数组中，验证账号是否存在 如果存在需要将结果输出

		// int a=Arrays.binarySearch(names, newusername )
		boolean ifexist = searchForAcc(newusername);
		if (!ifexist) { // 为false则通过
			System.out.println("注册成功");
			names[count] = newusername;
			passwd[count] = newpassword;
			count++;
		}
	}

//登录
	// 登录
	static void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = sc.next();
		System.out.println("请输入密码：");
		String password = sc.next();
		// int index=-1; 为了获取下标从而判断密码是否正确
		for (int j = 0; j < names.length; j++) {
			if (username.equals(names[j]) && password.equals(passwd[j])) {
				subMenu();
				sencondoPtionChoose();
			}
		}
	}

//主函数
	// 主函数
	public static void main(String[] args) {
		initDate();
		mainMenu();
		optionChoose();
	}
}
