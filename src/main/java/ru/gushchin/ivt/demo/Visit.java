package ru.gushchin.ivt.demo;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;


// Класс - задание для потоков
class Visit implements Runnable{
    private int id;

    public Visit(int id){
        this.id = id;
    }

    // инструкции потоку на выполнение
    @Override
    public void run() {
        try {

            // Создаем путь к случайному файлу из трёх предложенных
            StringBuilder path = new StringBuilder("/home/ilsave/education/IdeaProjects/DecoratorTagsSpringThread/src/main/java/ru/gushchin/ivt/demo/StudentPojo");
            int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
            path.append(randomNum).append(".java");

            // Запускаются все функции для обработки файла из класса FileManager
            FileManager.CopyToHTML(FileManager.PrintInFile(FileManager.makeList(path.toString()), FileManager.checkFile()),randomNum);

        }catch (IOException e){
            e.printStackTrace();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}