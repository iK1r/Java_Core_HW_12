package com.example.hw12;

public class Task2 {

  public static void main(String[] args) throws InterruptedException {
    FizzBuzz fizzBuzz = new FizzBuzz(15);

    Thread threadA = new Thread(() -> fizzBuzz.fizz());
    Thread threadB = new Thread(() -> fizzBuzz.buzz());
    Thread threadC = new Thread(() -> fizzBuzz.fizzbuzz());
    Thread threadD = new Thread(() -> fizzBuzz.number());

    threadA.start();
    threadB.start();
    threadC.start();
    threadD.start();

    threadA.join();
    threadB.join();
    threadC.join();
    threadD.join();
  }
}
