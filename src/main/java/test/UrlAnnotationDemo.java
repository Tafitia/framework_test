package test;

import myframework.UrlAnnotation;
import java.lang.reflect.Method;

public class UrlAnnotationDemo {

    static class DemoController {
        @UrlAnnotation(url = "/hello")
        public void hello() {
            System.out.println("Hello depuis /hello");
        }

        @UrlAnnotation(url = "/goodbye")
        public void goodbye() {
            System.out.println("Au revoir depuis /goodbye");
        }
    }

    public static void main(String[] args) throws Exception {
        DemoController controller = new DemoController();
        for (Method method : DemoController.class.getDeclaredMethods()) {
            UrlAnnotation annotation = method.getAnnotation(UrlAnnotation.class);
            if (annotation == null) {
                continue;
            }
            System.out.println("URL -> " + annotation.url());
            method.invoke(controller);
        }
    }
}
