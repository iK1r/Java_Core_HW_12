package com.example.hw12;

public class Task1 {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    Thread timeThread = new Thread(() -> {
      while (true) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          return;
        }

        long seconds = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Час від запуску: " + seconds + " с");
      }
    });

    Thread messageThread = new Thread(() -> {
      while (true) {
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          return;
        }

        System.out.println("Минуло 5 секунд");
      }
    });

    timeThread.start();
    messageThread.start();
  }
}
