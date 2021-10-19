package com.example.localtesting.model;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;

import java.util.Objects;
import org.springframework.data.annotation.Id;

@Entity(name = "article") // 'kind' in datastore
public class Article {

  @Id
  private Long id;

  private String title;

  private String text;

  public Article(String title, String text) {
    this.title = title;
    this.text = text;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Article article = (Article) o;
    return Objects.equals(id, article.id) && Objects.equals(title, article.title)
        && Objects.equals(text, article.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, text);
  }
}
