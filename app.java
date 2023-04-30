import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class userInput {
    String file;
    ArrayList<String> arr = new ArrayList<>();
    String sort[];
    Boolean status;
    public userInput(String filename){
        File txtfile = new File(filename); 
        try {
            Scanner read = new Scanner(txtfile);
            while(read.hasNextLine()){
                file = read.nextLine();
        
                sort = file.split(",");                 
            }          
            read.close();
        } catch (FileNotFoundException e) { e.printStackTrace(); }
        for(String a : sort){ System.out.print(a + "\n"); } 
    }
    public void findUser(){
        
        System.out.print("ID:");   
        Scanner input = new Scanner(System.in);
        String user = input.next();
        for(int i=0;i<sort.length;i++){
            status = user.contains(sort[i]);
            if(status){break;}
        }
        if(status){System.out.println("Found");}               
        else System.out.println("Not Found"); 
    }
}
public class app {
    public static void main(String[] args) {
        System.out.println();
        userInput u = new userInput("info.txt");
        u.findUser();
    }
}