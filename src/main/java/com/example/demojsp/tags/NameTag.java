package com.example.demojsp.tags;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class NameTag extends TagSupport {

    @Override
    public int doStartTag() {
        try {
            pageContext.getOut().write("What is ur name?");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
