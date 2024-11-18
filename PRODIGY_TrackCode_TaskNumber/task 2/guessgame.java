import java.util.*;

public class guessgame {
    
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE= "\u001B[34m";
    public static final String CYAN= "\u001B[36m";  
    public static final String WHITE= "\u001B[37m";
    public static final String BLACK= "\u001B[30m";
    public static final String MAGENTA= "\u001B[35m";
    public static final String RED_BACKGROUND="\u001B[41m";
    public static void main(String arg[]){
        

        Random random = new Random();
        System.out.println("==========================================");
        // System.out.println("       ");
        System.out.println(RED_BACKGROUND+"               GUESSING GAME              "+ RESET);
        System.out.println("==========================================");
        
        System.out.println();

        int rand = random.nextInt(100)+1;
        int u=0;
        int attempts=0;
        
        System.out.println(MAGENTA +"i have genrated number between 1 to 100");
  
    while(u != rand){
        
            Scanner sc= new Scanner(System.in);
            int n= sc.nextInt();
            attempts++;
            
            if (n<rand) {
                System.out.println(YELLOW+"Too low, try again!!");
                
            }
            else if (n>rand) {
            System.out.println(YELLOW+"Too high, try again!!");
            }else{
            
            System.out.println("=======================================================");
            System.out.println(CYAN+"?  congratulation you guess the right answer  ?: "+rand +RESET);
            System.out.println(YELLOW+"=======================================================\n");
            System.out.println();
            System.out.println(GREEN+"you took this much of attempt: "+attempts);
            }
    }
  
   }
}