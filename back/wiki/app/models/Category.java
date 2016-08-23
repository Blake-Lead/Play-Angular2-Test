package models;

public class Category {
    private Long id;
    private String tag;
    private String description;

    public Category() { }

    public Category(Long id, String tag, String description) {
        this.id = id;
        this.tag = tag;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public String getTag() {
        return this.tag;
    }

    public String getDescription() {
        return this.description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}