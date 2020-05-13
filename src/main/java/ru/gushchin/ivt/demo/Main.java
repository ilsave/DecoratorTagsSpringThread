package ru.gushchin.ivt.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        ExecutorService executorService = Executors.newFixedThreadPool(5); // задаем пул и количество потоковв нем

        for(int i = 0; i < 5; i++){
            executorService.submit(new Visit(i)); //раздаем задания
        }
        executorService.shutdown();//перестаем принимать задания и начинаем выполнение

        System.out.println("all task submitted");
        executorService.awaitTermination(1, TimeUnit.HOURS); //ожидание окончания работы


    }
}




