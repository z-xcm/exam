package exam;

	
	import java.security.NoSuchAlgorithmException;
	import java.util.Scanner;
	import java.security.MessageDigest;
	import java.security.SecureRandom;
	import java.util.Base64;
	import java.math.*;

	public class login {
	   //salt����
	    public static String Salt() {
	         
	         String salt="";
	         try {
	            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
	            byte[] bytes = new byte[16];
	            random.nextBytes(bytes);
	            salt = new String(Base64.getEncoder().encode(bytes));
	            
	         } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	         }
	         return salt;
	      }
	   
	    //sha512
	   public static String SHA512(String password, String hash) {
	      String salt = hash+password;
	      String hex = null;
	      
	      try {

	         MessageDigest msg = MessageDigest.getInstance("SHA-512");
	         msg.update(salt.getBytes());
	         
	         hex = String.format("%128x", new BigInteger(1, msg.digest()));
	         
	      } catch (NoSuchAlgorithmException e) {
	         e.printStackTrace();
	      }
	      return hex;
	   }
	   
	    //ȸ������
	    public void login(String[] args) {
	       Scanner scan = new Scanner(System.in);
	       
	        int num = 0;
	        
	        System.out.println("-----ȸ�� ����-----");
	        System.out.println("id �Է� :");
	        String id = scan.nextLine();
	        
	        System.out.println("pw �Է� :");
	        String pw = scan.nextLine();
	        
	        //salt�� ����
	        String salt = Salt();
	        System.out.println("(salt ���� �Ϸ�="+salt+")");
	        
	        
	        //��ȣȭ
	        String pw_encrypt = SHA512(pw, salt);
	        System.out.println("(��ȣȭ�� ��й�ȣ���� db�� ����� ���ڿ�="+pw_encrypt+")");
	      
	         
	        System.out.println("-----���� �Ϸ�-----");
	        boolean go = true;
	       
	        System.out.println("-----�� �� ��-----");
	        System.out.println("id �Է� :");
	        String id_input = scan.nextLine();
	          
	           while(go) {
	              
	              if(id.equals(id_input)) {
	                 System.out.println("pw �Է� :");
	                 String pw_input = scan.nextLine();
	               
	                 //��ȣȭ
	                 String pw_decrypt = SHA512(pw_input, salt);
	                 
	                 if( pw_decrypt.equals(pw_encrypt)) {
	                    System.out.println("-----"+id+"�� �α��� ����-----");
	                    go = false;//while�� ������
	                
	                 }else {
	                    num++;
	                    System.out.println("-----��й�ȣ Ʋ��. �ٽ� �Է����ּ���-----"+num+"ȸ �õ�");
	                 }
	                 
	              }else {
	                 System.out.println("---- ���� ���̵� �Դϴ�. �ٽ� �Է����ּ���");
	                 System.out.println("id �Է� :");
	                 id_input = scan.nextLine();
	                 
	              }
	              
	              
	             
	           }
	        
	   }

	}
