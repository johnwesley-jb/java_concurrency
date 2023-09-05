import repository.UserRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestExecutors {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        List<String> users = getusersFromFile("C:\\Users\\WES\\OneDrive\\Documents\\Workspace\\Java\\Concurrency\\src\\main\\resources\\new_users.txt");
        UserRepository userRepository = new UserRepository();
        for (String user : users) {
            Future<Integer> future = service.submit(new UserProcessor(user, userRepository));
            try {
                System.out.println("Result of the new operation is:" + future.get());
            } catch (InterruptedException e) {
                Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, e);
            } catch (ExecutionException e) {
                Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        service.shutdown();
        System.out.println("Main execution over!");
    }

    public static List<String> getusersFromFile(String fileName) {
        List<String> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                users.add(line);
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
}
