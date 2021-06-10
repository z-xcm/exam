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
			System.out.println("쇼핑몰(사용자모드)");
			System.out.println("1. 상품 목록");
			System.out.println("2. 장바구니");
			System.out.println("3. 관리자 모드");
			System.out.println("4. 종료");
			System.out.println("--------------------");
			System.out.println(" 번호를 입력하세요 : ");
			
			menu = scanner.nextInt();
			switch (menu) {
			
				case 1:
					List.output();
					break;
					
				case 2: 
					cartMenu = 0; 
					
					
					while(cartMenu != 4) {
						System.out.println("--------------------");
						System.out.println("장바구니");
						System.out.println("1. 상품추가");
						System.out.println("2. 상품 목록");
						System.out.println("3. 상품 삭제");
						System.out.println("4. 사용자모드");
						System.out.println("--------------------");
						System.out.print(" 번호를 입력하세요 : ");
						
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
						System.out.println(" 쇼핑몰 (관리자모드)");
						System.out.println("1. 상품 추가");
						System.out.println("2. 상품 목록");
						System.out.println("3. 상품 삭제");
						System.out.println("4. 사용자 모드");
						System.out.println("5. 시스템 종료");
						System.out.println("--------------------");
						System.out.print("번호를 입력하세요 : ");
						

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
							System.out.println("시스템이 종료되었습니다.");
							System.exit(0);
							break;
						}
					}
					break;
				case 4:
					System.out.println("시스템이 종료되었습니다.");
					System.exit(0);
					break;
					
				default: // ����
					System.out.println("유효한 값을 입력하세요.");
					break;
			}
		}
	}

}
