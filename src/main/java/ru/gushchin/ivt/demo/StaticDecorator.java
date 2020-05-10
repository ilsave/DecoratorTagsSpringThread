package ru.gushchin.ivt.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("StaticDecorator")
public class StaticDecorator implements ReturnInterface{


    @Override
    public String sendBackLine(String line) {
        StringBuilder a = new StringBuilder();
        String[] words= line.split(" ");
        int b = 1;
        for (String ln : words){
            if ("static".equals(ln)){
                break;
            }
            b++;
        }
        int i = 0;
        for (String ln : words){
            if(b - i == 1){
                a.append("<i><strong> <font color='blue' face='Compact'>");
            }
                i++;
            if ("static".equals(ln)){
                a.append(ln);
                a.append("</font> </strong></i>");
                continue;
            }
            a.append(" ");
            a.append(ln);
        }
        return a.toString();
    }
}
