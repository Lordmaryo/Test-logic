package book;


/*
 * Todo - Make user be able to write books with its own chapters and its content
 * Todo - make users like and comment on a chapter
 */

import user.User;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String description;
    private List<Chapter> chapters;

    public Book(String title, String description, Chapter chapter) {
        this.title = title;
        this.description = description;
        this.chapters = new ArrayList<>();
        this.chapters.add(chapter);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor(User user) {
        return user.getUserName();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
}
