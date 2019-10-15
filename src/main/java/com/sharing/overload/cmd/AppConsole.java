package com.sharing.overload.cmd;

import com.sharing.overload.entity.AppPost;
import com.sharing.overload.service.AppFriendsService;
import com.sharing.overload.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppConsole implements CommandLineRunner {

    @Autowired
    private AppUserService userService;

    @Autowired
    private AppFriendsService friendsService;

    @Override
    public void run(String... args) throws Exception {

        userService.addNewRegularUser("Kowalski");
        userService.addNewRegularUser("Stonoga");
        userService.addNewRegularUser("Nowak");

        friendsService.makeFriends("Kowalski", "Stonoga");
        friendsService.makeFriends("Kowalski", "Nowak");

        AppPost post = new AppPost( "Kowalski", "Siała baba mak");
        userService.addPostToTheBoard("Kowalski", post);
        userService.addPostToTheBoard("Kowalski", new AppPost( "Kowalski", "Nie siała baba maku"));

    }
}
