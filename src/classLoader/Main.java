package classLoader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Scanner scan=new Scanner(System.in);
        String pathToClasses="C:\\Users\\Andey\\Desktop\\JAVA_kpi\\out\\production\\labs";
        String pathToJava="C:\\Users\\Andey\\Desktop\\JAVA_kpi\\src";
        String className="classLoader.TestModule";

        while(true){

            ClassLoader loader = new MyClassLoader(pathToClasses,pathToJava);
            Class newClass = Class.forName(className, true, loader);
            Object object = newClass.newInstance();
            System.out.println(object.toString());
            scan.nextLine();
        }
    }
}
