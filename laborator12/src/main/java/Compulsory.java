import javax.print.attribute.standard.Destination;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public class Compulsory {

    public static class MyClassloader extends URLClassLoader {

        public MyClassloader() {
            super(new URL[0], ClassLoader.getSystemClassLoader());
        }
        @Override
        public void addURL(URL url) {
            super.addURL(url); //addUrl is protected in the superclass
        }

    }


    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
        MyClassloader myLoader1 = new MyClassloader();

        File path=new File("C:\\Users\\andre\\OneDrive\\Desktop\\pa-lab9\\Programare-avansata\\laborator2\\Optional\\out\\production\\laborator2\\");

        if(path.exists()){
            URL url[]= new URL[1];
            url[0]=path.toURI().toURL();
            //myLoader1.addURL(url);
            ClassLoader cl=new URLClassLoader(url);
            cl.loadClass("Warehouse");
            System.out.println(Arrays.toString(cl.getDefinedPackages().getClass().getDeclaredMethods()));
        }
        else{
            System.out.println("Nu exista");
        }


    }
}
