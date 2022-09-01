package b1_21318;

import java.util.*;

public class omok21318 { 
	 static String[][] map = {
             {"��","��","��","��","��","��","��","��","��","��"}, // map[0][0-9]
             {"��","��","��","��","��","��","��","��","��","��"}, // map[1][0-9]
             {"��","��","��","��","��","��","��","��","��","��"}, // map[2][0-9]
             {"��","��","��","��","��","��","��","��","��","��"}, // map[3][0-9]
             {"��","��","��","��","��","��","��","��","��","��"}, // map[4][0-9]
             {"��","��","��","��","��","��","��","��","��","��"}, // map[5][0-9]
             {"��","��","��","��","��","��","��","��","��","��"}, // map[6][0-9]
             {"��","��","��","��","��","��","��","��","��","��"}, // map[7][0-9]
             {"��","��","��","��","��","��","��","��","��","��"}, // map[8][0-9]
             {"��","��","��","��","��","��","��","��","��","��"}  // map[9][0-9]
     };

 public static void main(String[] args) {
    
     Player P1 = new Player();
    
     Scanner sc = new Scanner(System.in);

     System.out.print("�÷��̾�1�� �̸��� �Է��ϼ���~ ");
     String player1 = sc.next();
     
    
     System.out.print("�÷��̾�2�� �̸��� �Է��ϼ���~ ");
     String player2 = sc.next();
    
     boolean re = true;
    
     while(re) {
         int x��ǥ, y��ǥ;
        
         while(true) {
             System.out.printf("%s���� ���Դϴ�!", player1);
             System.out.printf("%s��, ��� ������? x y", player1);
             x��ǥ = sc.nextInt();
             y��ǥ = sc.nextInt();
            
             if(map[x��ǥ][y��ǥ]=="��" || map[x��ǥ][y��ǥ]=="��") { 
                 System.out.println("���� �̹� �����մϴ�. �ٽ� �Է��ϼ���!");
                 continue;
             } else {
                 map[x��ǥ][y��ǥ] = "��";
                 printMap();
                 break;
             }
         }
         
         if(Check(x��ǥ, y��ǥ, "��")==false) {
             System.out.println(player1 + "���� �¸�!!");
             break;
         }
        
         while(true) {
             System.out.printf("%s���� ���Դϴ�!", player2);
             System.out.printf("%s��, ��� ������? x y", player2);
             x��ǥ = sc.nextInt();
             y��ǥ = sc.nextInt();
            
             if(map[x��ǥ][y��ǥ]=="��" || map[x��ǥ][y��ǥ]=="��") {
                 System.out.println("���� �̹� �����մϴ�. �ٽ� �Է��ϼ���!");
                 continue;
             } else {
                 map[x��ǥ][y��ǥ] = "��";
                 printMap();
                 break;
             }
         }
        
         if(Check(x��ǥ, y��ǥ, "��")==false) {
             System.out.println(player2 + "���� �¸�!!");
             break;
         }
     }
 }

 private static boolean Check(int x��ǥ, int y��ǥ, String ��) {

     int cnt = 1;
    
     cnt = Check(x��ǥ, y��ǥ, ��, 0, 1, cnt);  // �� �� �� �� ��
     
     cnt = Check(x��ǥ, y��ǥ, ��, 0, -1, cnt); // �� �� �� �� ��         
       
     if(cnt>=5) {
         return false;
     }
    
    
     cnt = 1;
    
     cnt = Check(x��ǥ, y��ǥ, ��, 1, 0, cnt);   // �� �� �� �� ��
     
     cnt = Check(x��ǥ, y��ǥ, ��, -1, 0, cnt);  // �� �� �� �� ��
         
    
     if(cnt>=5) {
         return false;
     }
    
     cnt = 1;
    
     cnt = Check(x��ǥ, y��ǥ, ��, 1, 1, cnt);	  // �� �� �� �� ��
     
     cnt = Check(x��ǥ, y��ǥ, ��, -1, -1, cnt);  // �� �� �� �� ��
    
     if(cnt>=5) {
         return false;
     }
    

     cnt = 1;
    
     cnt = Check(x��ǥ, y��ǥ, ��, 1, -1, cnt);	   // �� �� �� �� ��
     
     cnt = Check(x��ǥ, y��ǥ, ��, -1, 1, cnt);   // �� �� �� �� ��
    
     if(cnt>=5) {
         return false;
     }

     return true;
 }

 
 	private static int Check(int x��ǥ, int y��ǥ, String ��, int moveRow, int moveCol, int cnt) {
 		
 		for(int i=1; i<5; i++) {
 	         try {
 	             if(map[x��ǥ+i*moveRow][y��ǥ+i*moveCol]!=��){
 	                 break;
 	             } else    {
 	                 if(map[x��ǥ+i*moveRow][y��ǥ+i*moveCol]==��) {
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