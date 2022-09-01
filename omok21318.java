package b1_21318;

import java.util.*;

public class omok21318 { 
	 static String[][] map = {
             {"¦£","¦¨","¦¨","¦¨","¦¨","¦¨","¦¨","¦¨","¦¨","¦¤"}, // map[0][0-9]
             {"¦§","¦«","¦«","¦«","¦«","¦«","¦«","¦«","¦«","¦©"}, // map[1][0-9]
             {"¦§","¦«","¦«","¦«","¦«","¦«","¦«","¦«","¦«","¦©"}, // map[2][0-9]
             {"¦§","¦«","¦«","¦«","¦«","¦«","¦«","¦«","¦«","¦©"}, // map[3][0-9]
             {"¦§","¦«","¦«","¦«","¦«","¦«","¦«","¦«","¦«","¦©"}, // map[4][0-9]
             {"¦§","¦«","¦«","¦«","¦«","¦«","¦«","¦«","¦«","¦©"}, // map[5][0-9]
             {"¦§","¦«","¦«","¦«","¦«","¦«","¦«","¦«","¦«","¦©"}, // map[6][0-9]
             {"¦§","¦«","¦«","¦«","¦«","¦«","¦«","¦«","¦«","¦©"}, // map[7][0-9]
             {"¦§","¦«","¦«","¦«","¦«","¦«","¦«","¦«","¦«","¦©"}, // map[8][0-9]
             {"¦¦","¦ª","¦ª","¦ª","¦ª","¦ª","¦ª","¦ª","¦ª","¦¥"}  // map[9][0-9]
     };

 public static void main(String[] args) {
    
     Player P1 = new Player();
    
     Scanner sc = new Scanner(System.in);

     System.out.print("ÇÃ·¹ÀÌ¾î1ÀÇ ÀÌ¸§À» ÀÔ·ÂÇÏ¼¼¿ä~ ");
     String player1 = sc.next();
     
    
     System.out.print("ÇÃ·¹ÀÌ¾î2ÀÇ ÀÌ¸§À» ÀÔ·ÂÇÏ¼¼¿ä~ ");
     String player2 = sc.next();
    
     boolean re = true;
    
     while(re) {
         int xÁÂÇ¥, yÁÂÇ¥;
        
         while(true) {
             System.out.printf("%s´ÔÀÇ ÅÏÀÔ´Ï´Ù!", player1);
             System.out.printf("%s´Ô, ¾îµû ³õÀ»·¡? x y", player1);
             xÁÂÇ¥ = sc.nextInt();
             yÁÂÇ¥ = sc.nextInt();
            
             if(map[xÁÂÇ¥][yÁÂÇ¥]=="¡Ü" || map[xÁÂÇ¥][yÁÂÇ¥]=="¡Û") { 
                 System.out.println("µ¹ÀÌ ÀÌ¹Ì Á¸ÀçÇÕ´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇÏ¼¼¿ä!");
                 continue;
             } else {
                 map[xÁÂÇ¥][yÁÂÇ¥] = "¡Ü";
                 printMap();
                 break;
             }
         }
         
         if(Check(xÁÂÇ¥, yÁÂÇ¥, "¡Ü")==false) {
             System.out.println(player1 + "´ÔÀÌ ½Â¸®!!");
             break;
         }
        
         while(true) {
             System.out.printf("%s´ÔÀÇ ÅÏÀÔ´Ï´Ù!", player2);
             System.out.printf("%s´Ô, ¾îµû ³õÀ»·¡? x y", player2);
             xÁÂÇ¥ = sc.nextInt();
             yÁÂÇ¥ = sc.nextInt();
            
             if(map[xÁÂÇ¥][yÁÂÇ¥]=="¡Ü" || map[xÁÂÇ¥][yÁÂÇ¥]=="¡Û") {
                 System.out.println("µ¹ÀÌ ÀÌ¹Ì Á¸ÀçÇÕ´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇÏ¼¼¿ä!");
                 continue;
             } else {
                 map[xÁÂÇ¥][yÁÂÇ¥] = "¡Û";
                 printMap();
                 break;
             }
         }
        
         if(Check(xÁÂÇ¥, yÁÂÇ¥, "¡Û")==false) {
             System.out.println(player2 + "´ÔÀÌ ½Â¸®!!");
             break;
         }
     }
 }

 private static boolean Check(int xÁÂÇ¥, int yÁÂÇ¥, String µ¹) {

     int cnt = 1;
    
     cnt = Check(xÁÂÇ¥, yÁÂÇ¥, µ¹, 0, 1, cnt);  // ¡æ ¡æ ¡æ ¡æ ¡æ
     
     cnt = Check(xÁÂÇ¥, yÁÂÇ¥, µ¹, 0, -1, cnt); // ¡ç ¡ç ¡ç ¡ç ¡ç         
       
     if(cnt>=5) {
         return false;
     }
    
    
     cnt = 1;
    
     cnt = Check(xÁÂÇ¥, yÁÂÇ¥, µ¹, 1, 0, cnt);   // ¡è ¡è ¡è ¡è ¡è
     
     cnt = Check(xÁÂÇ¥, yÁÂÇ¥, µ¹, -1, 0, cnt);  // ¡é ¡é ¡é ¡é ¡é
         
    
     if(cnt>=5) {
         return false;
     }
    
     cnt = 1;
    
     cnt = Check(xÁÂÇ¥, yÁÂÇ¥, µ¹, 1, 1, cnt);	  // ¢Ù ¢Ù ¢Ù ¢Ù ¢Ù
     
     cnt = Check(xÁÂÇ¥, yÁÂÇ¥, µ¹, -1, -1, cnt);  // ¢Ø ¢Ø ¢Ø ¢Ø ¢Ø
    
     if(cnt>=5) {
         return false;
     }
    

     cnt = 1;
    
     cnt = Check(xÁÂÇ¥, yÁÂÇ¥, µ¹, 1, -1, cnt);	   // ¢× ¢× ¢× ¢× ¢×
     
     cnt = Check(xÁÂÇ¥, yÁÂÇ¥, µ¹, -1, 1, cnt);   // ¢Ö ¢Ö ¢Ö ¢Ö ¢Ö
    
     if(cnt>=5) {
         return false;
     }

     return true;
 }

 
 	private static int Check(int xÁÂÇ¥, int yÁÂÇ¥, String µ¹, int moveRow, int moveCol, int cnt) {
 		
 		for(int i=1; i<5; i++) {
 	         try {
 	             if(map[xÁÂÇ¥+i*moveRow][yÁÂÇ¥+i*moveCol]!=µ¹){
 	                 break;
 	             } else    {
 	                 if(map[xÁÂÇ¥+i*moveRow][yÁÂÇ¥+i*moveCol]==µ¹) {
 	                     cnt++;

 	                 }                    
 	             }
 	         } catch (ArrayIndexOutOfBoundsException e) {
 	             i=5;                
 	         }
 	     }
 		
 		return cnt;
 	}

 	public static void printMap() {
 		for(int i=0; i<map.length; i++) {
 			for(int j=0; j<map[i].length; j++) {
 				System.out.print(map[i][j]);
 			}
 			System.out.println();
 		}
 	}
}