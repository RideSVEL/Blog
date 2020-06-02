package com.serejka.blogging.repository;

import com.serejka.blogging.models.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
