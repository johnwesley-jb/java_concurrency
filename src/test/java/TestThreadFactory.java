import custom.CustomThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadFactory {
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(3,new CustomThreadFactory());
       for (int i=0; i<6; i++){
           service.submit(new LoggingProcessor());
       }
    }
}
