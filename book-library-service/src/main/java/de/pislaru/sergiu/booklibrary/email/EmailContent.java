package de.pislaru.sergiu.booklibrary.email;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.Map;

public class EmailContent {

    private final String textContent;

    public EmailContent(String textContent) {
        this.textContent = textContent;
    }

    public EmailContent(Template template, Map<String, Object> templateModel) throws TemplateException, IOException {
        this.textContent = geContentFromTemplate(template, templateModel);
    }

    private String geContentFromTemplate(Template template, Map<String, Object> templateModel) throws IOException, TemplateException {
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, templateModel);
    }

    public String getTextContent() {return textContent;}
}
