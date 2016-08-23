package models;

public class Article {
    private Long    id;
    private String  title;
    private String  author;
    private String  body;
    private Long    categoryId;

    public Article() { }

    public Article(Long id,
        String title,
        String author,
        String body,
        Long categoryId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.body = body;
        this.categoryId= categoryId;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getBody() {
        return this.body;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}