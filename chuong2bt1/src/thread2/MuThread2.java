package thread2;

public class MuThread2 implements Runnable{

    @Override
    public void run() {
        int input = 10;
        for (int i = 1; i < input; i++) {
            try {
                if (i % 2 != 0) {
                    System.out.println("so le la: " + i);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
