import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;


public class ccwc {
    public static void main(String[] args){

        if(args.length != 2 || !args[0].equals("-c")){
            System.out.println("Error incorrect usage " + args[0]);
            return;
        }
        
        argsDesignater(args[0], args[1]);

    }

    public static void argsDesignater(String argsType, String fileName){
        if(argsType.equals("-c")) getBytes(fileName);
    }
    
    public static void getBytes(String fileName){

        try(FileInputStream finput = new FileInputStream(fileName)){
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