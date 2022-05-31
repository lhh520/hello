import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.TimeUnit;

public class 管道 {
    private static PipedReader reader = new PipedReader();
    private static PipedWriter writer = new PipedWriter();

    static class Server implements Runnable {

        @Override
        public void run() {
            try {

                int receivedData = 0;
                while ((receivedData = reader.read()) != -1) {
                    System.out.print((char)receivedData);
                }
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Client implements Runnable {

        @Override
        public void run() {
            try {
                writer.write("test");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        writer.connect(reader);//管道连接
        new Thread(new Server()).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new Client()).start();
    }



}
