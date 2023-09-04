import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AppThread extends Thread{
//    public static void main(String[] args) {
//        System.out.println("It works");
//    }

    @Override
    public void run() {
        try(BufferedReader reader=new BufferedReader(new FileReader(new File("C:\\Users\\WES\\OneDrive\\Documents\\Workspace\\Java\\Concurrency\\src\\main\\resources\\sample.txt")))){
            String line=null;
             while ((line=reader.readLine())!=null){
                 System.out.println(Thread.currentThread().getName()+"Reading the Line: "+line);
             }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
