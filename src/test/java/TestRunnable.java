import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TestRunnable {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            try (BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\WES\\OneDrive\\Documents\\Workspace\\Java\\Concurrency\\src\\main\\resources\\sample.txt")))) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(Thread.currentThread().getName() + "Reading the Line: " + line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
//        Thread thread=new Thread(runnable);
//        thread.start();
// Diff between Runnable & Callable
        Executor executor= Executors.newSingleThreadExecutor();
        executor.execute(runnable);
    }
}
