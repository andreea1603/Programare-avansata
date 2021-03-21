import java.io.IOException;
import java.io.*;
import java.util.*;

import freemarker.template.*;

public class ReportCommand implements Command {
    Catalog c1;

    public ReportCommand(Catalog c1) {
        this.c1 = c1;
    }
    public ReportCommand() {
    }

    @Override
    public  void execute(String ... params) throws IOException, TemplateException {
        c1=new Catalog("Catalogul nr.3", "C:\\Users\\andre\\OneDrive\\Desktop\\Compulsory\\");

        c1.add(new Book("Book1","Aa"));
        c1.add(new Book("Book2","Autor2"));
        c1.add(new Book("Book3","Autor3"));

        Map<String, Catalog> afis= new HashMap<>();
        afis.put("PrimulCatalog", c1);
        //System.out.println(c1.path + c1.name + c1.items);
        Configuration configuration= new Configuration();
        configuration.setClassForTemplateLoading(ReportCommand.class, "templates");
        configuration.setIncompatibleImprovements(new Version(2,3,20));
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setDirectoryForTemplateLoading(new File("C:\\Users\\andre\\OneDrive\\Desktop\\Compulsory\\"));

        Template template=configuration.getTemplate("file.ftl");

        Writer consoleWriter= new OutputStreamWriter(System.out);

        template.process(afis, consoleWriter);


        Writer fileWriter = new FileWriter(new File("C:\\Users\\andre\\OneDrive\\Desktop\\Compulsory\\output.html"));

        try {
            template.process(afis, fileWriter);
        } finally {
            fileWriter.close();
        }

    }


}
