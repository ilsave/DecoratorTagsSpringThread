package ru.gushchin.ivt.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("FinalDecorator")
public class FinalDecorator implements ReturnInterface{

    /*
    Все последующие декораторы работают по идентичному принципу
     */

    @Override
    public String sendBackLine(String line) {
        StringBuilder a = new StringBuilder();
        String[] words= line.split(" ");
        int b = 1; // Определяет позицию сразу за искомым словом
        for (String ln : words){
            if ("final".equals(ln)){
                break;
            }
            b++;
        }
        int i = 0; // Определяет позицию прямо перед искомым словом
        for (String ln : words){
            if(b - i == 1){
                a.append("<i><strong> <font color='purple' face='Compact'>"); // Теги вставляеются передм словом
            }
            i++;
            if ("final".equals(ln)){
                a.append(ln);
                a.append("</font> </strong></i>"); // Теги вставляются после слова
                continue;
            }
            a.append(" ");
            a.append(ln);
        }
        return a.toString();
    }
}

