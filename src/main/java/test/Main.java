package test;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> urls = UrlScanner.scanAllUrls();
        if (urls.isEmpty()) {
            System.out.println("Aucune URL trouvée.");
        } else {
            System.out.println("Liste des URLs trouvées :");
            for (String url : urls) {
                System.out.println("- " + url);
            }
        }
    }
}
