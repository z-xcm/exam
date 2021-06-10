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
		
		// ��ǰ ���� �Է�
		
        System.out.println("id�� �Է����ּ���");
        watch.put("id", scanner.next());
		
        System.out.println("��ǰ�� �Է�");
		watch.put("productName", scanner.next());
		
		 System.out.println("������ �Է����ּ���");
	        watch.put("price", scanner.nextInt());
	        
	        System.out.println("������ �Է����ּ���");
	        watch.put("amount", scanner.nextInt());
	        
	        // JSONArray�� ��ǰ ������ �Էµ� JSONObject �Է�
	        array.add(watch);

	        // json ���Ͽ� ����
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

		public static void output() {
		      try {
		    	  // json ���� �б�
		    	  Object object = parser.parse(new FileReader("product_list.json"));
		    	  
		    	  // Object���� JSONArray�� ����
		    	  array = (JSONArray) object;
		    	  
		    	  // for������ ��ü ��ǰ ��� ���
		    	  for (int i=0; i<array.size(); i++) {
			            JSONObject obj = (JSONObject) array.get(i);
			            System.out.print("���̵�: " + obj.get("id") + "\t");
			            System.out.print("�̸�: " + obj.get("productName") + "\t");
			            System.out.print("����: " + obj.get("price") + "\t");
			            System.out.println("����: " + obj.get("amount") + "\t");
			         }
			         
			      }
		      // ���� ó��
		      catch (FileNotFoundException e) { e.printStackTrace(); } 
		      catch (IOException e) { e.printStackTrace(); } 
		      catch (ParseException e) { e.printStackTrace(); }
		      
		   }

		public static void delete() {
			try {
				  // json ���� �б�
				  Object object = parser.parse(new FileReader("product_list.json"));
				  
				  // Object���� JSONArray�� ����
				  array = (JSONArray) object;
				  
				  // ������ ��ǰ�� id �Է�
				  System.out.println("������ ��ǰ�� id�� �Է����ּ���");
				  String productId = scanner.next();
				  
				  // for������ ��ü Ž���Ͽ� �Է¹��� id�� ��ġ�ϴ� ��ǰ ����
				  for (int i=0; i<array.size(); i++) {
					  JSONObject obj = (JSONObject) array.get(i);
					  if(obj.get("id").equals(productId)) {
						  System.out.println(obj.get("productName") + " ��ǰ�� ���ŵǾ����ϴ�.");
						  array.remove(i);
						  // json ���Ͽ� ����
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
			  // ���� ó��
			catch (FileNotFoundException e) { e.printStackTrace(); } 
			catch (IOException e) { e.printStackTrace(); } 
			catch (ParseException e) { e.printStackTrace(); }
		}
	}