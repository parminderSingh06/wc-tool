import java.io.FileInputStream;
import java.io.IOException;


public class ccwc {
    public static void main(String[] args){

        String filename = args[1];

        try(FileInputStream finput = new FileInputStream(filename)){

            if(args[0].equals("-c")){
                byte[] buffer = new byte[1024];
                int bytesRead;
                int byteCount = 0;

                while((bytesRead = finput.read(buffer)) != -1){
                    byteCount += bytesRead;
                }

                System.out.println(byteCount);
            }

            else if(args[0].equals("-l")){
                int lineCount = 0;
            }
        } catch(IOException e){
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
    
}