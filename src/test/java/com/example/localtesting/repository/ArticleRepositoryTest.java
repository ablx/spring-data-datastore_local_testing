package com.example.localtesting.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.localtesting.model.Article;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArticleRepositoryTest {

  @Autowired
  private ArticleRepository articleRepository;

  @BeforeEach
  void setUp() {
    // Makes sure we have a clean repository for each test.
    articleRepository.deleteAll();
  }

  @Test
  void shouldFindEmptyArticles() {
    // given
    Article article = new Article("Title 1", "Some Text");
    Article emptyArticle = new Article("Empty Article", null);
    articleRepository.saveAll(List.of(article, emptyArticle));

    // when
    List<Article> emptyArticles = articleRepository.findAllByTextIsNull();

    // then
    assertThat(emptyArticles).hasSize(1).containsExactly(emptyArticle);
  }
}