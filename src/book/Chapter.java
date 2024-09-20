package book;

import user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Chapter {
    private final int chapterNum;  // Chapter number, starting from 1
    private String chapterName;
    private String content;
    private boolean isLiked;
    private Set<User> likes;
    private List<String> comments;

    public Chapter(int chapterNum, String chapterName, String content) {
        this.chapterNum = chapterNum;
        this.chapterName = chapterName;
        this.content = content;
        this.isLiked = false;
        this.likes = new HashSet<>();
        this.comments = new ArrayList<>();
    }

    public int getChapterNum() {
        return chapterNum;
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
        return isLiked;
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

    public Set<User> getLikes() {
        return likes;
    }

    public List<User> getAllLikes() {
        return new ArrayList<>(likes);  // Make a copy to avoid modifying the original list
    }

    public void setLikes(Set<User> likes) {
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
        if (index >= 0 && index < comments.size()) {
            comments.remove(index);
        }
    }
}
