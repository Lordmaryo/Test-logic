package book;

import user.User;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
    private String chapterName;
    private String content;
    private boolean isLiked;
    private List<User> likes;
    private List<String> comments;

    public Chapter(int chapterNum, String chapterName, String content) {
        this.chapterName = chapterName;
        this.content = content;
        this.isLiked = false;
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isLiked() {
        return false;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public void likeChapter(User user) {
        if (!likes.contains(user)) {
            likes.add(user);
            setLiked(true);
        }
    }

    public void unLikeChapter(User user) {
        if (likes.contains(user)) {
            likes.remove(user);
            if (likes.isEmpty()) {
                setLiked(false);
            }
        }
    }

    public List<User> getLikes() {
        return likes;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public void deleteComment(int index) {
        if (index > 0 && index < comments.size()) {
            comments.remove(index);
        }
    }
}
