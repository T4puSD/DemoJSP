package com.example.demojsp.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class HelloTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        try {
            getJspContext().getOut().write("Hellooooooooooooooooooooooo!!!!!!!!!!!!!!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
