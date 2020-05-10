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


        ExecutorService executorService = Executors.newFixedThreadPool(1);

        for(int i = 0; i < 5; i++){
            executorService.submit(new Visit(i));
        }
         executorService.shutdown();
        System.out.println("all task submitted");
        executorService.awaitTermination(1, TimeUnit.HOURS);

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


class Visit implements Runnable{
    private int id;

    public Visit(int id){
        this.id = id;
    }
    @Override
    public void run() {
        try {
            StringBuilder path = new StringBuilder("C:\\Users\\дом\\Documents\\GitHub\\DecoratorTagsSpring\\src\\main\\java\\ru\\gushchin\\ivt\\demo\\StudentPojo");


            Thread.sleep(1000);
            int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);

            path.append(randomNum).append(".java");
            FileManager.CopyToHTML(FileManager.PrintInFile(FileManager.makeList(path.toString()), FileManager.checkFile()),randomNum);
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

