import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class userManagement {
    String file;
    int i,index;
    String sort[];
    Boolean status;
    String filename = "info.txt";
    Scanner input;
    String user;
    public userManagement(String filename){
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
    public int findUser(){
        //find index of element
        //if the function return -1 means it not found in the database
        System.out.print("ID:");   
        input = new Scanner(System.in);
        user = input.next();
        
        for(i=0;i<sort.length;i++){
            status = user.contains(sort[i]);
            
            if(status){break;}
        }
        if(status){System.out.println("Found");}               
        else System.out.println("Not Found"); 

        return i;
    }

    public void addUser(){
        System.out.print("ID:"); 
        input = new Scanner(System.in);
        user = input.next();
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.append(",");
            writer.append(user);
            
            input.close(); writer.close();
        }catch(IOException e) { e.printStackTrace(); }   
    }

    public void deleteUser(){
        int p;
        //findUser();
        p=findUser();
        if(p>-1){
            System.out.print(p);
            
        }
    }
}
public class app {
    public static void main(String[] args) {
        System.out.println();
        userManagement u = new userManagement("info.txt");
        //u.findUser();
        //u.addUser();
        u.deleteUser();
    }
}