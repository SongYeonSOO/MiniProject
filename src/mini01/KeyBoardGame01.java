package mini01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Scanner;

public class KeyBoardGame01 {

	public static void Game() {

		FileReader rf;
		char[] buf = new char[30];
		char[] ans = new char[30];
		
		
		try {
			
			rf = new FileReader("D://memil.txt");
			int score = 0;
			
			Calendar cal = Calendar.getInstance();
			int hour0 = cal.get(Calendar.HOUR);
			int min0 = cal.get(Calendar.MINUTE);
			int sec0 = cal.get(Calendar.SECOND);
					
			try {
				
				while (rf.read(buf) != -1) {
					System.out.println(buf);
					Scanner sc = new Scanner(System.in);
					ans = sc.nextLine().toCharArray(); // scanner로 받은 걸 char
														// array에 넣어서 비교
					score = score(buf, ans, score); // 점수계산
				}
				
				
				cal = Calendar.getInstance();
				int hour1 = cal.get(Calendar.HOUR);
				int min1 = cal.get(Calendar.MINUTE);
				int sec1 = cal.get(Calendar.SECOND);
				
				
				int time = TimeScore(hour0,min0,sec0,hour1,min1,sec1);
				System.out.println("총 걸린시간: "+time);
				System.out.println("총 점수"+score);
				
				rf.close();
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static int TimeScore(int hour0, int min0,int sec0,int hour1, int min1,int sec1) {
		int hour = hour1*3600-hour0*3600;
		int min = min1*60-min0*60;
		int sec = sec1-sec0;
		int totaltime = hour+min+sec;
		return totaltime;
	}

	public static int score(char[] buf, char[] ans, int score) {

		int shortlength = buf.length<ans.length?buf.length:ans.length;
				
		for (int i = 0; i < shortlength; i++) {
			if (ans[i] == buf[i]) {
				score += 100;
			} else
				score -= 10;
		}
		return score;

	}
}
