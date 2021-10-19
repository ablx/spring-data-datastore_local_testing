package com.example.localtesting.repository;

import com.example.localtesting.model.Article;
import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.google.datastore.v1.Key;
import java.util.List;

public interface ArticleRepository extends DatastoreRepository<Article, Key> {

  List<Article> findAllByTextIsNull();


}
