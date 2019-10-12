package com.sharing.overload.cmd;

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

        friendsService.makeFriends(userService.findAppUserByUsername("Kowalski"), userService.findAppUserByUsername("Stonoga"));
        friendsService.makeFriends(userService.findAppUserByUsername("Nowak"), userService.findAppUserByUsername("Kowalski"));
    }
}
