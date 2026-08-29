package com.example.hw12;

public class Task1 {

  public static void main(String[] args) {
    Thread timeThread = new Thread(() -> {
      int seconds = 0;

      while (true) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          return;
        }

        seconds++;
        System.out.println("Минуло " + seconds + " секунд");
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
