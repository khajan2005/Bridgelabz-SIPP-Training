import java.util.*;
public class CompareStingbufferAndStringbuilder {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = 1_000_000;
        String text = sc.nextLine();

        long startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sbd.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ns");
    }
}