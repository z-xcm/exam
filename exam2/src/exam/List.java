package exam;

import java.io.*;
import java.util.*;

import org.json.simple.*;
import org.json.simple.parser.*;

public class List {

	static Scanner scanner = new Scanner(System.in);
	static JSONArray array = new JSONArray();
	static JSONParser parser = new JSONParser();
	
	
	
	
	public static void input() {
		JSONObject watch = new JSONObject();
		
		// 상품 정보 입력
		
        System.out.println("id를 입력해주세요");
        watch.put("id", scanner.next());
		
        System.out.println("상품명 입력");
		watch.put("productName", scanner.next());
		
		 System.out.println("가격을 입력해주세요");
	        watch.put("price", scanner.nextInt());
	        
	        System.out.println("수량을 입력해주세요");
	        watch.put("amount", scanner.nextInt());
	        
	        // JSONArray에 상품 정보가 입력된 JSONObject 입력
	        array.add(watch);

	        // json 파일에 쓰기
	        try {
	           FileWriter file = new FileWriter("product_list.json", false);
	           file.write(array.toJSONString());
	           file.flush();
	           file.close();
	        }
	        catch (IOException e) {
	           e.printStackTrace();
	        }
		   
		}
	
	/**
	 * @fn : output
	 * @brief : 시계상품 등록 
	 * @details : JSON 을 사용하여 각각 해당하는 입력값을 받고 리스트에 덮어쓰기 형식
	 * @author : 임정우(jwlim1210@gmail.com)
	 * @date : 2021-06-10 (11시33분)
	 * @param :   id = 상품 id ,productName = 상품 이름, price = 상품의 가격, amount = 상품 수량
	 * @remark  수정이유: 코딩만있으면 코딩을 이해하는데 시간이 조금 걸리기 때문이다 (임정우, 2021-06-10 (15시33분))
	 * 			필요성 : output을 좀 더 한눈에 볼수있게 하기 위해 (임정우, 2021-06-10 (15시33분))
	 */

		public static void output() {
		      try {
		    	  // json 파일 읽기
		    	  Object object = parser.parse(new FileReader("product_list.json"));
		    	  
		    	  // Object에서 JSONArray로 변경
		    	  array = (JSONArray) object;
		    	  
		    	  // for문으로 전체 상품 목록 출력
		    	  for (int i=0; i<array.size(); i++) {
			            JSONObject obj = (JSONObject) array.get(i);
			            System.out.print("아이디: " + obj.get("id") + "\t");
			            System.out.print("이름: " + obj.get("productName") + "\t");
			            System.out.print("가격: " + obj.get("price") + "\t");
			            System.out.println("수량: " + obj.get("amount") + "\t");
			         }
			         
			      }
		      // 예외 처리
		      catch (FileNotFoundException e) { e.printStackTrace(); } 
		      catch (IOException e) { e.printStackTrace(); } 
		      catch (ParseException e) { e.printStackTrace(); }
		      
		   }

		public static void delete() {
			try {
				  // json 파일 읽기
				  Object object = parser.parse(new FileReader("product_list.json"));
				  
				  // Object에서 JSONArray로 변경
				  array = (JSONArray) object;
				  
				  // 삭제할 상품의 id 입력
				  System.out.println("삭제할 상품의 id를 입력해주세요");
				  String productId = scanner.next();
				  
				  // for문으로 전체 탐색하여 입력받은 id와 일치하는 상품 제거
				  for (int i=0; i<array.size(); i++) {
					  JSONObject obj = (JSONObject) array.get(i);
					  if(obj.get("id").equals(productId)) {
						  System.out.println(obj.get("productName") + " 상품이 제거되었습니다.");
						  array.remove(i);
						  // json 파일에 저장
						  try {
					           FileWriter file = new FileWriter("product_list.json", false);
					           file.write(array.toJSONString());
					           file.flush();
					           file.close();
					        }
					        catch (IOException e) {
					           e.printStackTrace();
					        }
					  }
				  }
			  }
			  // 예외 처리
			catch (FileNotFoundException e) { e.printStackTrace(); } 
			catch (IOException e) { e.printStackTrace(); } 
			catch (ParseException e) { e.printStackTrace(); }
		}
	}