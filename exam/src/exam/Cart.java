package exam;

import java.io.*;
import java.util.*;

import org.json.simple.*;
import org.json.simple.parser.*;

public class Cart {
	

	static Scanner scanner = new Scanner(System.in);
	static JSONArray array = new JSONArray();
	static JSONArray cart_array = new JSONArray();
	static JSONParser parser = new JSONParser();
	

	public static void input() {
		try {
			  // json ���� �б�
			  Object object = parser.parse(new FileReader("product_list.json"));
			  
			  // Object���� JSONArray�� ����
			  array = (JSONArray) object;
			  
			  // ��ٱ��Ͽ� �߰��� ��ǰ�� �̸� �Է�
			  System.out.println("��ٱ��Ͽ� �߰��� ��ǰ�� �̸��� �Է����ּ���");
			  String name = scanner.next();
			  
			  // for������ ��ü Ž���Ͽ� �Է¹��� �̸��� ��ǰ ã��
			  for (int i=0; i<array.size(); i++) {
				  JSONObject obj = (JSONObject) array.get(i);
				  
				  if(obj.get("productName").equals(name)) {
					  
					  // cart.json ���� �б�
					  Object object2 = parser.parse(new FileReader("cart.json"));
					  
			    	  // Object���� JSONArray�� ����
			    	  cart_array = (JSONArray) object2;
			    	  
			    	  // JSONArray(��ٱ���)�� ��ǰ �߰�
			    	  cart_array.add(obj);
			    	  
					  // cart.json ���Ͽ� ����
					  try {
				           FileWriter file = new FileWriter("cart.json", false);
				           file.write(cart_array.toJSONString());
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
	
	public static void output() {
		 try {
	    	  // json ���� �б�
	    	  Object object = parser.parse(new FileReader("cart.json"));
	    	  
	    	  // Object���� JSONArray�� ����
	    	  cart_array = (JSONArray) object;
	    	  
	    	  // for������ ��ü ��ǰ ��� ���
	    	  for (int i=0; i<cart_array.size(); i++) {
		            JSONObject obj = (JSONObject) cart_array.get(i);
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
			  Object object = parser.parse(new FileReader("cart.json"));
			  
			  // Object���� JSONArray�� ����
			  cart_array = (JSONArray) object;
			  
			  // ������ ��ǰ�� id �Է�
			  System.out.println("������ ��ǰ�� �̸��� �Է����ּ���");
			  String name = scanner.next();
			  
			  // for������ ��ü Ž���Ͽ� �Է¹��� id�� ��ġ�ϴ� ��ǰ ����
			  for (int i=0; i<cart_array.size(); i++) {
				  JSONObject obj = (JSONObject) cart_array.get(i);
				  if(obj.get("productName").equals(name)) {
					  System.out.println(obj.get("productName") + " ��ǰ�� ���ŵǾ����ϴ�.");
					  cart_array.remove(i);
					  // json ���Ͽ� ����
					  try {
				           FileWriter file = new FileWriter("cart.json", false);
				           file.write(cart_array.toJSONString());
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