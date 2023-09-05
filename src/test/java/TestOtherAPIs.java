import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestOtherAPIs {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Callable<Boolean>> callables = new ArrayList<>();
        try {
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());


            List<Future<Boolean>> futures = service.invokeAll(callables);

            for (Future<Boolean> future : futures) {
                System.out.println("Operation result:"+future.get());
            }

        } catch (InterruptedException e) {
            Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, e);
        } catch (ExecutionException e) {
            Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, e);
        }
        service.shutdown();
        try {
            System.out.println("Service shutdown?: "+service.awaitTermination(30,TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            service.shutdownNow();
            Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
