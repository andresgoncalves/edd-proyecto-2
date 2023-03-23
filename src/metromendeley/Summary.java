package metromendeley;

/**
 * Clase Resumen
 * @author Andres
 */
public class Summary {
    private String title;
    private String body;
    private String[] authors;
    private String[] keywords;

    public Summary(String title, String body, String[] authors, String[] keywords) {
        this.title = title;
        this.body = body;
        this.authors = authors;
        this.keywords = keywords;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }
}
