package com.sharing.overload.cmd;

import com.sharing.overload.entity.AppPost;
import com.sharing.overload.service.AppFriendsService;
import com.sharing.overload.service.AppPostService;
import com.sharing.overload.service.AppUserBoardService;
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

    @Autowired
    private AppUserBoardService boardService;

    @Autowired
    private AppPostService postService;

    @Override
    public void run(String... args) throws Exception {

        userService.addNewRegularUser("Kowalski", "1234");
        userService.addNewRegularUser("Stonoga", "abcdefg");
        userService.addNewRegularUser("Nowak", "stol");

        friendsService.makeFriends("Kowalski", "Stonoga");
        friendsService.makeFriends("Kowalski", "Nowak");

        AppPost post = new AppPost(boardService.findBoardByUsername("Kowalski").getId(), "Kowalski", "Siała baba mak");
        AppPost secondPost = new AppPost(boardService.findBoardByUsername("Kowalski").getId(), "Kowalski", "Nie siała baba maku");
        postService.save(post);
        postService.save(secondPost);

    }
}
