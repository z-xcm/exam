/** 
 @fn login
 @brief 함수의 설명 (What) 이름 설정
 @details 동작과정 설명 (How) name 변수에 이름 설정
 @author Name(Name@tistory.com) (Who) 남수만(sumannam@gmail.com)
 @date 함수 생성 날짜 (When)
 @return 리턴값에 대한설명(type 상품의 이름)
 @param 함수의 인자 설명(name: 상품의 이름)
 @remark  수정이유[작성자; 날짜2]
					필요성[작성자; 날짜1] (Why)
*/



package exam;

	
	import java.security.NoSuchAlgorithmException;
	import java.util.Scanner;
	import java.security.MessageDigest;
	import java.security.SecureRandom;
	import java.util.Base64;
	import java.math.*;

	public class login {
	   //salt생성
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
	   
	    //회원가입
	    public void login(String[] args) {
	       Scanner scan = new Scanner(System.in);
	       
	        int num = 0;
	        
	        System.out.println("-----회원 가입-----");
	        System.out.println("id 입력 :");
	        String id = scan.nextLine();
	        
	        System.out.println("pw 입력 :");
	        String pw = scan.nextLine();
	        
	        //salt값 생성
	        String salt = Salt();
	        System.out.println("(salt 생성 완료="+salt+")");
	        
	        
	        //암호화
	        String pw_encrypt = SHA512(pw, salt);
	        System.out.println("(암호화된 비밀번호이자 db에 저장될 문자열="+pw_encrypt+")");
	      
	         
	        System.out.println("-----가입 완료-----");
	        boolean go = true;
	       
	        System.out.println("-----로 그 인-----");
	        System.out.println("id 입력 :");
	        String id_input = scan.nextLine();
	          
	           while(go) {
	              
	              if(id.equals(id_input)) {
	                 System.out.println("pw 입력 :");
	                 String pw_input = scan.nextLine();
	               
	                 //복호화
	                 String pw_decrypt = SHA512(pw_input, salt);
	                 
	                 if( pw_decrypt.equals(pw_encrypt)) {
	                    System.out.println("-----"+id+"님 로그인 성공-----");
	                    go = false;//while문 나가기
	                
	                 }else {
	                    num++;
	                    System.out.println("-----비밀번호 틀림. 다시 입력해주세요-----"+num+"회 시도");
	                 }
	                 
	              }else {
	                 System.out.println("---- 없는 아이디 입니다. 다시 입력해주세요");
	                 System.out.println("id 입력 :");
	                 id_input = scan.nextLine();
	                 
	              }
	              
	              
	             
	           }
	        
	   }

	}
