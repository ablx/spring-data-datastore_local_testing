package com.example.localtesting.repository;

import com.example.localtesting.model.Article;
import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import java.util.List;

public interface ArticleRepository extends DatastoreRepository<Article, Long> {

  List<Article> findAllByTextIsNull();


}
