package metromendeley;

import java.util.regex.Pattern;

/**
 * Clase Resumen
 * @author Andres
 */
public class Summary {
    private final String title;
    private final String body;
    private final String[] authors;
    private final String[] keywords;
    private final int[] keywordAppearances;

    public Summary(String title, String body, String[] authors, String[] keywords) {
        this.title = title;
        this.body = body;
        this.authors = authors;
        this.keywords = keywords;
        this.keywordAppearances = new int[keywords.length];
        for(int i = 0; i < keywords.length; i++) {
            keywordAppearances[i] = (int) Pattern.compile("(^|\\s)\\s*" + Pattern.quote(keywords[i]) + "\\s*(\\s|$)").matcher(body).results().count();
        }
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public int[] getKeywordAppearances() {
        return keywordAppearances;
    }
}
