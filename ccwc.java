import java.io.FileInputStream;
import java.io.IOException;


public class ccwc {
    public static void main(String[] args){
        if(args.length != 2 || !args[0].equals("-c")){
            System.out.println("Error incorrect usage" + args[0]);
            return;
        }

        String filename = args[1];

        try(FileInputStream finput = new FileInputStream(filename)){
            byte[] buffer = new byte[1024];
            int bytesRead;
            int byteCount = 0;

            while((bytesRead = finput.read(buffer)) != -1){
                byteCount += bytesRead;
            }

            System.out.println(byteCount);
        } catch(IOException e){
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
    
}