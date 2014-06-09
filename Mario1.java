import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;



public class Mario1 {

    public static int inputReader(){
        int inputInt = -1;
        String preInt;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean a = true;
        while(a==true){
            System.out.println("Please enter an integer between 0 and "
                    + "23(inclusive).");
            try{
            preInt = br.readLine();
            inputInt = parseInt(preInt);
                }
            catch(NumberFormatException | IOException e){
                System.out.println("Errrr...Does not compute.");
                }
            if(inputInt>=0 && inputInt<=23){
                a=false;
                }
            }
    return inputInt;
    }
    
    public static void stepBuilder(int input){
       for(int i=0; i<=input; i++){
           int j = i;
           int k = i;
           String sb = new String();
           while(k>0){
               sb = sb + "#";
               k--;
               }
           while(input-j!=0){
               sb = " " + sb;
               j++;
               }
           System.out.println(sb);
           }
           }
    
    public static void main(String[] args){
        stepBuilder(inputReader());
        }
}

            
            
