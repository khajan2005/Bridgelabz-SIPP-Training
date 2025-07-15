import java.io.*;

public class Read_WriteToFile {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        FileWriter fw = new FileWriter("user_input.txt");
        String line;
        while (!(line = br.readLine()).equals("exit")) {
            fw.write(line + System.lineSeparator());
        }
        fw.close();
        br.close();
    }
}