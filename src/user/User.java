package user;

import book.Book;
import book.Chapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private static final Set<String> takenUsernames = new HashSet<>();
    private static int userCounts = 0;
    private String firstName;
    private String lastName;
    private String userName;
    private List<Book> books;
    private Set<User> followers = new HashSet<>();
    private Set<User> following = new HashSet<>();

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = generateUniqueUsername();
        this.books = new ArrayList<>();
        userCounts++;
    }

    private String generateUniqueUsername() {
        String fullNameStr = firstName + " " + lastName;
        String fullNameConcatenated = firstName.charAt(0) + lastName;
        String usernameWithCount = fullNameConcatenated + userCounts;
        String[] fullNameArr = fullNameStr.split(" ");
        String halfNames = fullNameArr[0].substring(0, fullNameArr[0].length() / 2)
                + fullNameArr[1].substring(0, fullNameArr[1].length() / 2);

        String noSpaceFullName = fullNameStr.replaceAll("\\s+", "");
        String fullNameWithUnderScore = fullNameStr.replaceAll("\\s+", "_");

        if (!takenUsernames.contains(firstName)) {
            takenUsernames.add(firstName);
            return firstName;
        } else if (!takenUsernames.contains(noSpaceFullName)) {
            takenUsernames.add(noSpaceFullName);
            return noSpaceFullName;
        } else if (!takenUsernames.contains(fullNameWithUnderScore)) {
            takenUsernames.add(fullNameWithUnderScore);
            return fullNameWithUnderScore;
        } else if (!takenUsernames.contains(fullNameConcatenated)) {
            takenUsernames.add(fullNameConcatenated);
            return fullNameConcatenated;
        } else if (!takenUsernames.contains(halfNames)) {
            takenUsernames.add(halfNames);
            return halfNames;
        }

        // If all else fails, append a number (user count) to make it unique
        while (takenUsernames.contains(usernameWithCount)) {
            userCounts++;
            usernameWithCount = fullNameConcatenated + userCounts;
        }
        takenUsernames.add(usernameWithCount);
        return usernameWithCount;
    }

    public void createBook(String title, String description, Chapter chapter) {
        books.add(new Book(title, description, chapter));
    }

    public void showBook(Book book) {
        System.out.println(book.getTitle() + " by " + book.getAuthor(this));
        System.out.println("Description: " + book.getDescription());
        System.out.println();

        for (Chapter chapter : book.getChapters()) {
            System.out.println("Chapter " + chapter.getChapterNum());
            System.out.println(chapter.getChapterName()
                    + "\n \t" + chapter.getContent());
        }
    }

    public int getUserCounts() {
        return userCounts;
    }

    public void follow(User user) {
        following.add(user);
        user.followers.add(this);
    }

    public void unfollow(User user) {
        following.remove(user);
        user.followers.remove(this);
    }

    public void showFollowers() {
        for (User followers : followers) {
            System.out.println(followers.getUserName());
        }
    }

    public int getNumOfFollowers() {
        return followers.size();
    }

    public int getNumOfFollowings() {
        return following.size();
    }

    public void showFollowings() {
        for (User followings : following) {
            System.out.println(followings.getUserName());
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        String sanitizedUserName = userName.replaceAll("[^a-zA-Z0-9_]", "");
        if (!takenUsernames.contains(userName)) {
            this.userName = sanitizedUserName;
            takenUsernames.add(sanitizedUserName);
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public void setFollowing(Set<User> following) {
        this.following = following;
    }
}
