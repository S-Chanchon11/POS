import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class userInput {
    String file;
    ArrayList<String> arr = new ArrayList<>();
    String sort[];
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
        Scanner input = new Scanner(System.in);
        if(input.equals(file)){           
        }
    }
}
public class app {
    public static void main(String[] args) {
        System.out.println();
        userInput u = new userInput("info.txt");
        //u.findUser();
    }
}