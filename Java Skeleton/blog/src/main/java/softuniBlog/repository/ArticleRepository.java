package softuniBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuniBlog.entity.Article;

/**
 * Created by Pc on 11.4.2017 г..
 */
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
