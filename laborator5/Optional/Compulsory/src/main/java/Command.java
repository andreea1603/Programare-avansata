import freemarker.template.TemplateException;

import java.io.IOException;

public interface Command {
    void execute(String ... params) throws IOException, ClassNotFoundException, TemplateException;
}
