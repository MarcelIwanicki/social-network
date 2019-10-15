package com.sharing.overload.service;

import com.sharing.overload.entity.AppPost;
import com.sharing.overload.entity.AppUser;
import com.sharing.overload.entity.AppUserBoard;
import com.sharing.overload.repository.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class AppUserService {

    private final Logger logger = LoggerFactory.getLogger(AppUserService.class);

    @Autowired
    private AppUserRepository repository;

    @Autowired
    private AppUserBoardService boardService;

    public void save(AppUser appUser) {
        repository.save(appUser);
    }

    public void addNewRegularUser(String userName) {
        if (repository.existsByUsername(userName)) {
            logger.info("Tried to add user with existing username!");
            return;
        }
        AppUser user = new AppUser(AppUser.Role.REGULAR_USER, userName);
        AppUserBoard board = new AppUserBoard();
        board.setHeader("Tablica użytkownika " + user.getUsername());
        boardService.save(board);
        user.setAppUserBoard(board);
        repository.save(user);
    }

    public AppUser findAppUserByUsername(String userName) {
        return repository.findAppUserByUsername(userName);
    }

    public List<AppUser> getAllUsers() {
        return repository.findAll();
    }
}
