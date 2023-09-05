import java.io.File;

public class CleaningScheduler implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        File folder = new File("D:/myFolder");
        for (File file : folder.listFiles()) {
            if (System.currentTimeMillis() - folder.lastModified() > 1 * 60 * 1000) {
                System.out.println("This is going to be deleted: " + file.getName());
                //file.delete();
            }
        }
    }
}
