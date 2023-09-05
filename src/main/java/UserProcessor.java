import domain.User;
import repository.UserRepository;

import java.util.StringTokenizer;
import java.util.concurrent.Callable;

public class UserProcessor implements Callable<Integer> {

    private String userRecord;
    private UserRepository userRepository;

    public UserProcessor(String userRecord, UserRepository userRepository) {
        this.userRecord = userRecord;
        this.userRepository = userRepository;
    }

    @Override
    public Integer call() throws Exception {
        int rows = 0;
        System.out.println(Thread.currentThread().getName());
        StringTokenizer tokenizer = new StringTokenizer(userRecord, ",");
        User user = null;

        while (tokenizer.hasMoreTokens()) {
            user = new User();
            user.setEmail(tokenizer.nextToken());
            user.setName(tokenizer.nextToken());
            user.setId(Integer.parseInt(tokenizer.nextToken()));
        }
        rows = userRepository.saveUser(user);
        return rows;
    }
}
