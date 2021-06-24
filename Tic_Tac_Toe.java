package ticTacToe;
import java.util.*;

public class Tic_Tac_Toe {

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		int T = obj.nextInt();
		String a[][] = new String[3][3];
		while(T-- != 0) 
		{
			int count_X=0,count_O=0,count_blanks=0;
			for(int i=0;i<3;i++) {
				String[] s = obj.next().split("");
				for(int j=0;j<3;j++) {
					a[i][j] = s[j];
					if(a[i][j].equals("X")) {
						count_X++;
					}
					else if(a[i][j].equals("O")) {
						count_O++;
					}
					else {
						count_blanks++;
					}
				}
			}
			int x=0, o=0;
			if(a[0][0].equals("X") && a[1][0].equals("X") && a[2][0].equals("X") ) x=1;
			if(a[0][1].equals("X") && a[1][1].equals("X") && a[2][1].equals("X") ) x=1;
			if(a[0][2].equals("X") && a[1][2].equals("X") && a[2][2].equals("X") ) x=1;
			
			if(a[0][0].equals("X") && a[0][1].equals("X") && a[0][2].equals("X") ) x=1;
			if(a[1][0].equals("X") && a[1][1].equals("X") && a[1][2].equals("X") ) x=1;
			if(a[2][0].equals("X") && a[2][1].equals("X") && a[2][2].equals("X") ) x=1;
			
			if(a[0][0].equals("X") && a[1][1].equals("X") && a[2][2].equals("X") ) x=1;
			if(a[0][2].equals("X") && a[1][1].equals("X") && a[2][0].equals("X") ) x=1;
// X ended		
			
			if(a[0][0].equals("O") && a[1][0].equals("O") && a[2][0].equals("O") ) o=1;
			if(a[0][1].equals("O") && a[1][1].equals("O") && a[2][1].equals("O") ) o=1;
			if(a[0][2].equals("O") && a[1][2].equals("O") && a[2][2].equals("O") ) o=1;
			
			if(a[0][0].equals("O") && a[0][1].equals("O") && a[0][2].equals("O") ) o=1;
			if(a[1][0].equals("O") && a[1][1].equals("O") && a[1][2].equals("O") ) o=1;
			if(a[2][0].equals("O") && a[2][1].equals("O") && a[2][2].equals("O") ) o=1;
			
			if(a[0][0].equals("O") && a[1][1].equals("O") && a[2][2].equals("O") ) o=1;
			if(a[0][2].equals("O") && a[1][1].equals("O") && a[2][0].equals("O") ) o=1;
// Count for Y ended:-	
			if((x==1 && o==1) ||((count_X - count_O)<0) || (count_X-count_O)>1) {
				System.out.println(3);
			}
			else if(count_X == 0 && count_O==0 && count_blanks==9) {
				System.out.println(2);
			}
			else if(x==1 && o==0 && count_X>count_O) {
				System.out.println(1);
			}
			else if(x==0 && o==1 && count_X == count_O) {
				System.out.println(1);
			}
			else if(x==0 && o==0 && count_blanks==0) {
				System.out.println(1);
			}
			else if(x==0 && o==0 && count_blanks>0) {
				System.out.println(2);
			}
			else {
				System.out.println(3);
			}
		}
	}
}
