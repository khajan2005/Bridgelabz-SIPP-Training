import java.io.*;
public class UsingFilereader {

	public static void main(String[] args) throws IOException{
        FileReader fr = new FileReader("sample.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        fr.close();
    }
}