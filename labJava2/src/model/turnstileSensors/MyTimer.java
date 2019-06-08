package model.turnstileSensors;


public class MyTimer extends TurnstileSensor {
    private int idOfTurnstile;
    private int numberOfSeconds;
    private boolean isTimerRun;

    public MyTimer(int idOfTurnstile, int numberOfSeconds) {
        this.idOfTurnstile = idOfTurnstile;
        this.numberOfSeconds = numberOfSeconds;
    }

    public void countTime(int seconds) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                isTimerRun = true;
                try {
                    Thread.sleep(seconds * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isTimerRun = false;
            }
        };

        new Thread(runnable).start();
    }
}
