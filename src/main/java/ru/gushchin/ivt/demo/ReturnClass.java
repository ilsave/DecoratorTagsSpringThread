package ru.gushchin.ivt.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component("ReturnClass")
public class ReturnClass implements ReturnInterface{
    String line; // Строка из файла

    @Override
    public String sendBackLine(String line) {
        return line;
    } // Возвращает строку
}
