import java.util.*;
public class ConcatenateStrings {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		String s1=sc.nextLine();
		String s2=sc.nextLine();
		StringBuilder sb =new StringBuilder();
		for(int i=0;i<s1.length()+s2.length();i++) {
			if(i<s1.length()) {
				sb.append(s1.charAt(i));
			}
			else {
				sb.append(s2.charAt(i - s1.length()));
			}
			
		}
		System.out.print(sb.toString());
	}

}
