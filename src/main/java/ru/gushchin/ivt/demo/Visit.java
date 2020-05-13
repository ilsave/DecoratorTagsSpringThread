package ru.gushchin.ivt.demo;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

class Visit implements Runnable{
    private int id;

    public Visit(int id){
        this.id = id;
    }
    @Override
    public void run() {
        try {
            StringBuilder path = new StringBuilder("C:\\Users\\дом\\Documents\\GitHub\\DecoratorTagsSpringThread3\\src\\main\\java\\ru\\gushchin\\ivt\\demo\\StudentPojo");
            Thread.sleep(1000);
            int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);

            path.append(randomNum).append(".java");
            FileManager.CopyToHTML(FileManager.PrintInFile(FileManager.makeList(path.toString()), FileManager.checkFile()),randomNum);
            System.out.println("Task №"+id+" completed");
        }catch (IOException e){
            e.printStackTrace();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}