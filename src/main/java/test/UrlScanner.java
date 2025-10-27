package test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import myframework.Controller;
import myframework.UrlAnnotation;

public class UrlScanner {
    public static List<String> scanAllUrls() {
        List<String> urls = new ArrayList<>();
        
        try {
            // Récupérer le ClassLoader actuel
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            
            // Récupérer le chemin racine des classes
            URL resource = classLoader.getResource("");
            if (resource == null) {
                return urls;
            }
            
            File classesDir = new File(resource.getFile());
            
            // Scanner tous les fichiers .class
            List<Class<?>> allClasses = findAllClasses(classesDir, "");
            
            // Filtrer les classes annotées avec @Controller
            for (Class<?> clazz : allClasses) {
                if (clazz.isAnnotationPresent(Controller.class)) {
                    // Scanner les méthodes pour trouver les @UrlAnnotation
                    for (Method method : clazz.getDeclaredMethods()) {
                        if (method.isAnnotationPresent(UrlAnnotation.class)) {
                            UrlAnnotation annotation = method.getAnnotation(UrlAnnotation.class);
                            urls.add(annotation.url());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return urls;
    }
    
    private static List<Class<?>> findAllClasses(File directory, String packageName) {
        List<Class<?>> classes = new ArrayList<>();
        
        if (!directory.exists()) {
            return classes;
        }
        
        File[] files = directory.listFiles();
        if (files == null) {
            return classes;
        }
        
        for (File file : files) {
            if (file.isDirectory()) {
                // Recursion dans les sous-packages
                String subPackage = packageName.isEmpty() ? file.getName() : packageName + "." + file.getName();
                classes.addAll(findAllClasses(file, subPackage));
            } else if (file.getName().endsWith(".class")) {
                // Charger la classe
                String className = file.getName().substring(0, file.getName().length() - 6);
                String fullClassName = packageName.isEmpty() ? className : packageName + "." + className;
                
                try {
                    Class<?> clazz = Class.forName(fullClassName);
                    classes.add(clazz);
                } catch (ClassNotFoundException | NoClassDefFoundError e) {
                    // Ignorer les classes qui ne peuvent pas être chargées
                }
            }
        }
        
        return classes;
    }
}
