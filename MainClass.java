package atmproject;

import java.util.Arrays;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class MainClass {

	public static void main(String[] args) {
		// 原则：
		// 1.java中的终端项目，只有一个线性的线程
		// 2.java中做功能性的项目，优先处理界面化操作
		// 3.变量定义优先采集集中定义、分段使用的方式

		// 实现步骤
		// 1、定义欢迎界面 sysout
		// 2、定义菜单界面
		// 3、获得一个用户输入的选项，然后判断（登录、注册） scanner输入 if判断
		// 4、登录：判断账号密码
		// 5、注册：增加新的账号、密码
		// 查询 转账 取款 存款
while(true) {
		System.out.println("*********************************");
		System.out.println("***                           ***");
		System.out.println(" ***     欢迎来到ATM!          ***");
		System.out.println("***   1、注册    2、登录       ***");
		System.out.println("*********************************");
//		String[] names = { "admin", "", "" };
//		String[] passwd = { "123456", "", "" }; else {

		// 所有账号密码放这里
		String[] names = new String[20];
		String[] passwd = new String[20];
		int[] allMoney = new int[20];
		names[0] = "admin";
		passwd[0] = "123";
		allMoney[0] = 10000;
		// count为既代表已经有的数据组同时也代表下一个注册数据存入的脚标，当然也可以通过循环判断空然后写入数据
		int count = 1;
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		switch (option) {
		// 注册
		// 1、验证是否存在
		// 2、存进数组1
		case 1:
			System.out.println("请输入要注册的用户名：");
			String newusername = sc.next();
			System.out.println("请输入要注册的密码：");
			String newpassword = sc.next();
			// 账号保存在数组中，验证账号是否存在 如果存在需要将结果输出
			boolean ifexist = false;
			// int a=Arrays.binarySearch(names, newusername )
			for (int i = 0; i < names.length; i++) {
				if (newusername.equals(names[i])) {
					System.out.println("用户名已存在");
					ifexist = true;
					break;
				}
			}
			if (!ifexist) { // 为false则通过
				System.out.println("注册成功");
				names[count] = newusername;
				passwd[count] = newpassword;
				count++;
			}
			break;

		case 2:
			System.out.println("请输入用户名：");
			String username = sc.next();
			System.out.println("请输入密码：");
			String password = sc.next();
			// int index=-1; 为了获取下标从而判断密码是否正确

			for (int j = 0; j < names.length; j++) {
				if (username.equals(names[j]) && password.equals(passwd[j])) {
					System.out.println("登陆成功！");
					System.out.println("**************************");
					System.out.println("\t请输入你要进行的操作：");
					System.out.println("\t1、存取款 2、转账 3、 查询 4、注销");
					System.out.println("**************************");
					int optionother = sc.nextInt();
					switch (optionother) {
					case 1: // 存取款
						System.out.println("输入存入的账户");
						String saveAcc = sc.next();
						System.out.println("输入存入的金额");
						int saveMoney = sc.nextInt();
						int index_saveAcc = -1;
						for (int i = 0; i < names.length; i++) {
							if (saveAcc.equals(names[i])) {
								index_saveAcc = i; // 发现账号相同保留下标
							}

						}
						if (index_saveAcc >= 0) {
							allMoney[index_saveAcc] += saveMoney;
							System.out.println("存入成功");
							System.exit(0);
						} else {
							System.out.println("账号不存在存入失败");
							System.exit(0);
						}

					case 2: // 转账 转给谁 转多少钱
						System.out.println("输入转入的账户");
						String toAcc = sc.next();
						System.out.println("输入转账金额");
						int toMoney = sc.nextInt();
						// 1、判断账户
						int index_toAcc = -1;
						for (int i = 0; i < names.length; i++) {
							if (toAcc.equals(names[i])) {
								index_toAcc = i; // 发现账号相同保留下标
							}

						}
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

						// 2、判断金额

						// 3.转账并保持过程完整

						break;
					case 3: // 查询
						System.out.println("输入存入的账户");
						String selectAcc = sc.next();
						int index_selectAcc = -1;
						for (int i = 0; i < names.length; i++) {
							if (selectAcc.equals(names[i])) {
								index_selectAcc = i; // 发现账号相同保留下标
							}
						}
						if (index_selectAcc >= 0) {
							System.out.println("你的余额为：" + allMoney[index_selectAcc]);
							System.exit(0);
						}
						System.exit(0);
					case 4: // 注销
						System.exit(0);
					default:
						System.out.println("你输入的选项有误");
						System.exit(0);
					}
					

				} else {
					System.out.println("登录失败!");
					System.exit(0);
				}
				
			}

		
		}
      }
	}
}
