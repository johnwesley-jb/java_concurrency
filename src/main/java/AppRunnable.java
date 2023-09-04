public class AppRunnable implements Runnable {
    @Override
    public void run() {

    }

    public static void main(String[] args) {
        AppRunnable runnable = new AppRunnable() {
            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported");
            }
        };
    }
}
