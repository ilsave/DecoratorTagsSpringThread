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

        // Коротко, но понятно
        //String path = FileManager.getPath(); // Пользователь указывает путь к файлу с кодом
        //File result_file = FileManager.checkFile(); // Создается файл, в который будут записаны результаты
        //List<String> list = FileManager.makeList(path); // Создается список всех строк кода из исходного файл
        //FileManager.PrintInFile(list, result_file); // Все строки записываются в .txt файл
        //FileManager.CopyToHTML(result_file); // Создается копия .txt файла, но уже с расширением .html

        // Максимально коротко
       // FileManager.CopyToHTML(FileManager.PrintInFile(FileManager.makeList("C:\\Users\\дом\\Documents\\GitHub\\DecoratorTagsSpring\\src\\main\\java\\ru\\gushchin\\ivt\\demo\\StudentPojo.java"), FileManager.checkFile()));


    }
}




