package com.example.hw12;

import java.util.LinkedList;
import java.util.Queue;

public class FizzBuzz {

  private final int n;
  private int currentNumber = 1;
  private final Queue<String> queue = new LinkedList<>();
  private boolean firstValue = true;

  public FizzBuzz(int n) {
    this.n = n;
  }

  public synchronized void fizz() {
    while (currentNumber <= n) {
      if (currentNumber % 3 == 0 && currentNumber % 5 != 0) {
        queue.add("fizz");
        currentNumber++;
        notifyAll();
      } else {
        try {
          wait();
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          return;
        }
      }
    }

    notifyAll();
  }

  public synchronized void buzz() {
    while (currentNumber <= n) {
      if (currentNumber % 5 == 0 && currentNumber % 3 != 0) {
        queue.add("buzz");
        currentNumber++;
        notifyAll();
      } else {
        try {
          wait();
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          return;
        }
      }
    }

    notifyAll();
  }

  public synchronized void fizzbuzz() {
    while (currentNumber <= n) {
      if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
        queue.add("fizzbuzz");
        currentNumber++;
        notifyAll();
      } else {
        try {
          wait();
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          return;
        }
      }
    }

    notifyAll();
  }

  public synchronized void number() {
    while (currentNumber <= n || !queue.isEmpty()) {

      if (!queue.isEmpty()) {
        printValue(queue.poll());
        notifyAll();

      } else if (currentNumber <= n
          && currentNumber % 3 != 0
          && currentNumber % 5 != 0) {

        queue.add(String.valueOf(currentNumber));
        currentNumber++;
        notifyAll();

      } else {
        try {
          wait();
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          return;
        }
      }
    }

    System.out.println();
    notifyAll();
  }

  private void printValue(String value) {
    if (!firstValue) {
      System.out.print(", ");
    }

    System.out.print(value);
    firstValue = false;
  }
}
