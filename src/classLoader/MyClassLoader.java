package classLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class MyClassLoader extends ClassLoader {

    public final String classPath;
    public final String javaPath;

    public MyClassLoader(String classPath, String javaPath) {
        this.classPath = classPath;
        this.javaPath = javaPath;
    }

    @Override
    protected synchronized Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class result = findClass(name);
        if (resolve) {
            resolveClass(result);
        }
        return result;
    }

    @Override
    protected Class findClass(String name) throws ClassNotFoundException {
        String s = name.replace('.', '/');
        File f1 = findFile(classPath, s, ".class");
        File f2 = findFile(javaPath, s, ".java");

        if (f1 == null) {
            return findSystemClass(name);
        }
        if (f1.lastModified() < f2.lastModified()) {
            String[] args = new String[]{"-d", classPath, f2.getAbsolutePath()};
            JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
            javac.run(null, null, null, args);
        }

        try {
            byte[] classBytes = loadFileAsBytes(f1);
            Class result = defineClass(name, classBytes, 0, classBytes.length);
            return result;
        } catch (IOException e) {
            throw new ClassNotFoundException("Cannot load class " + name + ": " + e);
        } catch (ClassFormatError e) {
            throw new ClassNotFoundException("Format of class file incorrect for class " + name + ": " + e);
        }
    }

    private File findFile(String path, String name, String extension) {
        File f = new File(path + '/' + name + extension);
        if (f.exists()) {
            return f;
        }
        return null;
    }

    public static byte[] loadFileAsBytes(File file) throws IOException {
        byte[] result = new byte[(int) file.length()];
        FileInputStream f = new FileInputStream(file);
        try {
            f.read(result, 0, result.length);
        } finally {
            f.close();


        }
        return result;

    }

}

