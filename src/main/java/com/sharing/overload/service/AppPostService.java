package com.sharing.overload.service;

import com.sharing.overload.entity.AppPost;
import com.sharing.overload.repository.AppPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppPostService {

    @Autowired
    private AppPostRepository repository;

    public void save(AppPost post) {
        repository.save(post);
    }
}
