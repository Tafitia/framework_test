package test;

import myframework.Controller;
import myframework.UrlAnnotation;

@Controller
public class Test2Controller {
    @UrlAnnotation(url = "/hello")
    public void hello() {
        // ...
    }

    @UrlAnnotation(url = "/test")
    public void test() {
        // ...
    }
}
