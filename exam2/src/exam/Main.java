package exam;

import java.util.*;


public class Main {

	public static void main(String[] args) {
		 login login = new login();
		
		// Scanner 
		Scanner scanner = new Scanner(System.in);
		
		int menu = 0;
		int adminMenu = 0;
		int cartMenu = 0;
		
		
		while (true) {
			System.out.println("-------------------");
			System.out.println("���θ�(����ڸ��)");
			System.out.println("1. ��ǰ ���");
			System.out.println("2. ��ٱ���");
			System.out.println("3. ������ ���");
			System.out.println("4. ����");
			System.out.println("--------------------");
			System.out.println(" ��ȣ�� �Է��ϼ��� : ");
			
			menu = scanner.nextInt();
			switch (menu) {
			
				case 1:
					List.output();
					break;
					
				case 2: 
					cartMenu = 0; 
					
					
					while(cartMenu != 4) {
						System.out.println("--------------------");
						System.out.println("��ٱ���");
						System.out.println("1. ��ǰ�߰�");
						System.out.println("2. ��ǰ ���");
						System.out.println("3. ��ǰ ����");
						System.out.println("4. ����ڸ��");
						System.out.println("--------------------");
						System.out.print(" ��ȣ�� �Է��ϼ��� : ");
						
						cartMenu = scanner.nextInt();
						switch (cartMenu) {
						
						case 1: 
							Cart.input();
							break;
							
						case 2: 
							Cart.output();
							break;
						
						case 3: 
							Cart.delete();
							break;
							
						case 4: 
							break;
						}
					}
					break;
					
				case 3: 
					adminMenu = 0; 
					login.login(args);

					
					while(adminMenu != 4) {
						System.out.println("--------------------");
						System.out.println(" ���θ� (�����ڸ��)");
						System.out.println("1. ��ǰ �߰�");
						System.out.println("2. ��ǰ ���");
						System.out.println("3. ��ǰ ����");
						System.out.println("4. ����� ���");
						System.out.println("5. �ý��� ����");
						System.out.println("--------------------");
						System.out.print("��ȣ�� �Է��ϼ��� : ");
						

						adminMenu = scanner.nextInt();
						switch (adminMenu) {
						
						case 1:
							List.input();
							break;
							
						case 2:
							List.output();
							break;
							
						case 3: 
							List.delete();
							break;
							
						case 4:
							break;
						
						case 5:
							System.out.println("�ý����� ����Ǿ����ϴ�.");
							System.exit(0);
							break;
						}
					}
					break;
				case 4:
					System.out.println("�ý����� ����Ǿ����ϴ�.");
					System.exit(0);
					break;
					
				default: // 
					System.out.println("��ȿ�� ���� �Է��ϼ���.");
					break;
			}
		}
	}

}
