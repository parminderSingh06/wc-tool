import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;


public class ccwc {
    public static void main(String[] args){

        if(args.length != 2){
            System.out.println("Error incorrect usage " + args[0]);
            return;
        }
        
        argsDesignater(args[0], args[1]);

    }

    public static void argsDesignater(String argsType, String fileName){

        if(argsType.equals("-c")) getBytes(fileName);

        else if(argsType.equals("-l")) getLines(fileName);

        else if(argsType.equals("-w")) getWords(fileName);
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

    public static void getLines(String fileName){

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            int numLines = 0;
            boolean moreLines = true;

            while(moreLines){
                if(reader.readLine() == null){
                    moreLines = false;
                }
                else{
                    numLines++;
                }
            }
            System.out.println(numLines);

        } catch(IOException e){
            System.err.println("Error reading the file: " + e.getMessage());
        }

    }

    public static void getWords(String fileName){

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            int numWords = 0;
            String currentLine;
            String[] tempArr;
            boolean moreLines = true;

            while(moreLines){
                currentLine = reader.readLine();
                if(currentLine == null){
                    moreLines = false;
                    break;
                }

                tempArr = currentLine.split("\\s+");
                numWords += tempArr.length;
            }
            System.out.println(numWords);

        } catch(IOException e){
            System.err.println("Error reading the file: " + e.getMessage());
        }

    }

}