import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;


public class ccwc {
    public static void main(String[] args){

        if(args.length == 2){
            argsDesignater(args[0], args[1]);
        }
        
        else if(args.length == 1){
            getAll(args[0]);
        }


    }

    public static void argsDesignater(String argsType, String fileName){

        int answer = -1;

        if(argsType.equals("-c")) answer = getBytes(fileName);

        else if(argsType.equals("-l")) answer = getLines(fileName);

        else if(argsType.equals("-w")) answer = getWords(fileName);

        else if(argsType.equals("-m")) answer = getCharacters(fileName);

        else if(argsType.equals(null)) getAll(fileName);

        if(answer != -1) System.out.println(answer);
    }
    
    public static int getBytes(String fileName){

        try(FileInputStream finput = new FileInputStream(fileName)){
            byte[] buffer = new byte[1024];
            int bytesRead;
            int byteCount = 0;

            while((bytesRead = finput.read(buffer)) != -1){
                byteCount += bytesRead;
            }

            return byteCount;

        } catch(IOException e){
            System.err.println("Error reading the file: " + e.getMessage());
            return -1;
        }

    }

    public static int getLines(String fileName){

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

            return numLines;

        } catch(IOException e){
            System.err.println("Error reading the file: " + e.getMessage());
            return -1;
        }

    }

    public static int getWords(String fileName){

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            int numWords = 0;
            int currentCodePoint;
            boolean isWord = false;

            while((currentCodePoint = reader.read()) != -1){
                if(Character.isWhitespace(currentCodePoint)){
                    isWord = false;
                }
                else if(!isWord){
                    isWord = true;
                    numWords++;
                }
            }
            return numWords;

        } catch(IOException e){
            System.err.println("Error reading the file: " + e.getMessage());
            return -1;
        }

    }

    public static int getCharacters(String fileName){

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            int characterCount = 0;

            while(reader.read() != -1){
                characterCount++;
            }
            
            return characterCount;

        } catch(IOException e){
            System.err.println("Error reading the file: " + e.getMessage());
            return -1;
        }
    }

    public static void getAll(String fileName){
        System.out.println(getLines(fileName) + "   " + getWords(fileName) + "  " + getBytes(fileName) + "  " + fileName);
    }

}