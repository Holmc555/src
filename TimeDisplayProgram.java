public class TimeDisplayProgram {

    public static void main(String[] args) {
        // Перший поток
        Thread timeThread = new Thread(() -> displayElapsedtime());
        timeThread.start();

        // Затримка
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Другий поток
        Thread messageThread = new Thread(() -> displayMessage());
        messageThread.start();
    }

    private static void displayElapsedtime() {
        long startTime = System.currentTimeMillis();
        while (true) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = (currentTime - startTime) / 1000;
            System.out.println("Пройшло часу: " + (elapsedTime + 1) + " секунд");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void displayMessage() {
        while (true) {
            System.out.println("Минуло 5 секунд");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
