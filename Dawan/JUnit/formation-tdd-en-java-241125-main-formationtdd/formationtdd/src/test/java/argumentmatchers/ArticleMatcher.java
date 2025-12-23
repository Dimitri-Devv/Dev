package argumentmatchers;

import beans.Article;
import org.mockito.ArgumentMatcher;

public class ArticleMatcher implements ArgumentMatcher<Article> {
    @Override
    public boolean matches(Article article) {
        return article.getPrix()>100.0 && !article.getDescription().isEmpty();
    }
}
