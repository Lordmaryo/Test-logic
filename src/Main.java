
/*
 * This application is a simple logical programming that works like a book
 * social platform. Users are able to have a list of followers and also a list of
 * following consist of other users.
 *
 * Users are able to create a book and choose to read a book
 * Users are able to like and comment on a book chapter
 * Users should have a unique username that's auto generated, and they can also choose to edit the username
 *
 * */


import book.Book;
import book.Chapter;
import user.User;

import java.util.ArrayList;
import java.util.List;

// TODO - Make setUserName() only letters and numbers
// follow functionalities have been tested.
// users can now add books and chapters.

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("John", "Doe"));
        userList.add(new User("Amaka", "Okafor"));
        userList.add(new User("Amaka", "Ofoneta"));
        userList.add(new User("Amaka", "Ofoneta"));
        userList.add(new User("Amaka", "wayne"));
        userList.add(new User("Amaka", "Ofoneta"));
        userList.add(new User("Peter", "Theo"));
        userList.add(new User("Abraham", "Philip"));
        userList.add(new User("Mathew", "John"));
        userList.add(new User("Phillip", "James"));
        userList.add(new User("abraham", "Berth"));
        userList.add(new User("micheal", "Mark"));
        userList.add(new User("John", "Doe"));
        userList.add(new User("Thunder", "Phoebe"));
        userList.add(new User("Bruce", "Doe"));
        userList.add(new User("abraham", "Berth"));
        userList.add(new User("micheal", "Mark"));
        userList.add(new User("John", "Doe"));
        userList.add(new User("Thunder", "Phoebe"));
        userList.add(new User("Bruce", "Doe"));

        String overview = "This is a story about a star man being in the sky and his name is " +
                "superman";

        Chapter chapter1 = new Chapter(1, "The Star-man was born",
                "It was a sunny day in Metropolis, inside a farmhouse, the legend Superman was born.");

        // Chapter 2 content
        Chapter chapter2 = new Chapter(2, "The Star-man's first flight",
                "Superman discovered his ability to fly and soared across the sky, over the tall skyscrapers.");

        // Chapter 3 content
        Chapter chapter3 = new Chapter(3, "Saving the day",
                "Superman uses his powers to save the citizens of Metropolis from impending disaster.");


        User user1 = userList.get(0);
        user1.setUserName("John *99/;_fr@!");

        user1.createBook("The Star-man", overview, chapter1);
        Book user1Book = user1.getBooks().get(0);

        user1Book.addChapter(chapter2);
        user1Book.addChapter(chapter3);

        Chapter user1FirstChapter = user1.getBooks().get(0).getChapters().get(0);

        System.out.println("Those that liked");
        for (User user : userList) {
            user1FirstChapter.likeChapter(user);
        }
        user1FirstChapter.getLikes().forEach(user -> System.out.println(user.getUserName()));

        user1.showBook(user1Book);

        System.out.println("Comments");
        for (User user : userList) {
            String comment = user.getUserName() + ": This is the best chapter of John's book!";
            user1FirstChapter.addComment(comment);
        }

        user1FirstChapter.getComments().forEach(System.out::println);



        System.out.println("Chapter 1 of John's book now has " + user1FirstChapter.getLikes().size() +
                " likes"
        );
        System.out.println("Chapter 1 of John's book now has " + user1FirstChapter.getComments().size() +
                " Comments"
        );
    }
}
