
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


import book.Chapter;
import user.User;

import java.util.ArrayList;
import java.util.List;

// TODO - Make setUserName() only letters and numbers
// follow functionalities have been tested.

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

        String chapContent = "It was a sunny day in metropolis in, inside a farm house the legend " +
                "superman was born";

        userList.get(0).createBook("The Star-man", overview, new Chapter(
                1,
                "The Star-man was born",
                chapContent
        ));

//        System.out.println(userList.get(0).showBook(userList.get(0)));
    }
}
