package uw;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

public class TemplateReporter implements Reporter {


    private final Template template;

    public TemplateReporter(String name) {
        Configuration cfg = new Configuration();
        try {
            // todo clean up
            cfg.setDirectoryForTemplateLoading(new File("/Users/tomakehurst/dev/uw/guitar-shop/src/test/resources"));
            this.template = cfg.getTemplate(name);
        } catch (IOException e) {
             throw new RuntimeException("could not find" + name, e);

        }

    }

    @Override
    public void process(List<Model.Sale> sales, Writer writer) {
        try {
            template.process(new HashMap<String, Object>(), writer);
        } catch (Exception e) {
            throw new RuntimeException("template error", e);
        }
    }
}
