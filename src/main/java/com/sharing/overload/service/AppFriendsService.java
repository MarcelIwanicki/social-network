package com.sharing.overload.service;

import com.sharing.overload.entity.AppFriends;
import com.sharing.overload.entity.AppUser;
import com.sharing.overload.repository.AppFriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class AppFriendsService {

    @Autowired
    private AppFriendsRepository repository;

    public void makeFriends(@NotNull AppUser firstUser, @NotNull AppUser secondUser) {
        repository.save(new AppFriends(firstUser.getId(), secondUser.getId()));
        repository.save(new AppFriends(secondUser.getId(), firstUser.getId()));
    }
}
