package ru.gushchin.ivt.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Этот класс реализует всю работу с файлами
public class FileManager {

    // Функция возвращает путь к файлу, который пользователь введет
    static String getPath(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Пожалуйста, введите путь к файлу, который вы бы хотели перевести в HTML формат: ");
        String path = reader.nextLine(); // Читается вся строка
        File file = new File(path);
        while (!file.exists()) {
            System.out.println("Такого файла не существует! Попробуйте указать другой путь: ");
            path = reader.nextLine();
            file = new File(path);
        }
        return path;

    }

    // Функция считывае исходный код и помещает его в список
    static List<String> makeList(String path){
        BufferedReader br = null;
        List<String> list = new LinkedList<>(); // Список, в который читаются все строки файла
        try {
            // Чтение из одного файла
            br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                int count_spaces = 0; // Счетчик пробелов
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) != ' ') { // Если встречается не пробел, то цикл завершается
                        break;
                    } else if (line.charAt(i) == ' ') { // Если встречается пробел, то счетчик пробелов увеличивается на 1
                        count_spaces++;
                    }
                }
                StringBuffer buf = new StringBuffer(line);
                for (int j = 0; j < count_spaces; j++) { // В строку вставляется соответствующее количество пробелов в начало
                    buf.insert(0, "&nbsp");
                }
                line = buf.toString();
                list.add(line); // Строка помещается в список всех строк
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return list;
    }

    // Функция создает файл, в который будут выведены результаты работы
    static File checkFile() throws IOException{
        File file = new File("result.txt"); // Обозначаем файл для записи
        if (!file.exists())
            file.createNewFile(); // Если файла нет, то он создается
        return file;
    }

    // Записывает весь список строк в файл, добавляя HTML разметку
    static File PrintInFile(List<String> list, File file){
        String line2 =
                "<head>" +
                        "<title>" +
                        "Hey There!" + // Первая часть разметки
                        "</title>" +
                        "</head>" +
                        "<body>";
        String line3 =
                "\n" +
                        " </body>\n" + // Вторая часть разметки
                        "</html>";

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ReturnInterface FinalDecorator = ctx.getBean("FinalDecorator", FinalDecorator.class);
        ReturnInterface PrivateDecorator = ctx.getBean("PrivateDecorator", PrivateDecorator.class);
        ReturnInterface ProtectedDecorator = ctx.getBean("ProtectedDecorator", ProtectedDecorator.class);
        ReturnInterface PublicDecorator = ctx.getBean("PublicDecorator", PublicDecorator.class);
        ReturnInterface ReturnDecorator = ctx.getBean("ReturnDecorator", ReturnDecorator.class);
        ReturnInterface StaticDecorator = ctx.getBean("StaticDecorator", StaticDecorator.class);
        ReturnInterface VoidDecorator = ctx.getBean("VoidDecorator", VoidDecorator.class);


        try {
            if (!file.exists())
                file.createNewFile();
            PrintWriter pw = new PrintWriter(file);
            pw.print(line2); // Первая часть разметки пишется в файл
            for (String line1 : list){
                pw.print("<br>");
                // Применяем все возможные декораторы для строки и записываем в файл
                pw.print(ReturnDecorator.sendBackLine((VoidDecorator.sendBackLine(StaticDecorator.sendBackLine(ReturnDecorator.sendBackLine(PublicDecorator.sendBackLine(ProtectedDecorator.sendBackLine(PrivateDecorator.sendBackLine(FinalDecorator.sendBackLine(line1))))))))));
                pw.println("</br>");
            }
            pw.print(line3); // Вторая часть разметки пишется в файл
            pw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return file; // Возвращает .txt файл с кодом
    }

    // Функция создает копию .txt файла и меняет расширение на .html
    static void CopyToHTML(File source, int a) throws IOException{
        InputStream is = null;
        OutputStream os = null;
        StringBuilder pathname = new StringBuilder("result");
        pathname.append(a).append(".html");
        File dest = new File(pathname.toString()); // Файл, куда будет записан html код
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length); // Копирование файла в новый
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
            os.close();
        }
        System.out.println("Работа завершена, результат можно увидеть в файле " + dest.getAbsolutePath().toString());

    }

}
