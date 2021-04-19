import java.io.IOException;
import java.io.*;
import java.util.*;

import freemarker.template.*;

import java.io.File;

public class Report
{

    public void getTemplate(HashMap<String, String> searches) throws IOException, TemplateException {

        Map map= new HashMap();
        map.put("Operation", searches);

        Configuration cfg = new Configuration();

        cfg.setClassForTemplateLoading(Report.class, "templates");
        cfg.setIncompatibleImprovements(new Version(2,3,20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setDirectoryForTemplateLoading(new File("src/main/java"));

        Template template= cfg.getTemplate("operations.ftl");

        Writer consoleWriter= new OutputStreamWriter(System.out);
        template.process(map, consoleWriter );

        Writer fileWriter= new FileWriter("output.html");
        try{
            template.process(map, fileWriter);
        }
        finally {
            fileWriter.close();
        }

    }
}
