package org.example.consumer;

import org.example.service.annotation.Calculation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.stream.Collectors;

public class Consumer {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {






        //Look for classes in package org.example.provider

        Set<Class> classes = findAllClasses("org.example.provider");




        //Check if the class has the annotation @Calculation

        for (var c : classes) {
            var annotation = (Calculation) c.getAnnotation(Calculation.class);
            if (annotation != null) {
                System.out.println(annotation.value());
                var o = c.getConstructor().newInstance();

                var methods = c.getMethods();
                for (var m:methods) {
                    if ( m.getReturnType().equals(Integer.class) && m.getParameterCount() == 0 &&
                            !m.getName().equals("toString")) {
                        var s = (Integer) m.invoke(o);
                        System.out.println(s);
                    }

                }
            }
        }

    }












    private static void AdditionInterface(){
        System.out.println(findAllClasses("org.example.provider").equals("Addition"));
    }


    private static Set<Class> findAllClasses(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        assert stream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map( line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }
    public static Class getClass(String className, String packageName) {

        try {
            return Class.forName(packageName + "."
            + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {

        }

        return null;
    }

}
