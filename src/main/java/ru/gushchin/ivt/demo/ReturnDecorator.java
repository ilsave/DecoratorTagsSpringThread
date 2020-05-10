package ru.gushchin.ivt.demo;

import org.springframework.stereotype.Component;

@Component("ReturnDecorator")
public class ReturnDecorator implements ReturnInterface{

    @Override
    public String sendBackLine(String line) {
        StringBuilder a = new StringBuilder();
        String[] words= line.split(" ");
        int b = 1;
        for (String ln : words){
            if ("return".equals(ln)){
                break;
            }
            b++;
        }

        int i = 0;
        for (String ln : words){
            if(b - i == 1){
                a.append("<i><strong> <font color='navy' face='Compact'>");
            }
            i++;
            if ("return".equals(ln)){
                a.append(ln);
                a.append("</font></strong></i>");
                continue;
            }
            a.append(" ");
            a.append(ln);
        }
        return a.toString();
    }
}
