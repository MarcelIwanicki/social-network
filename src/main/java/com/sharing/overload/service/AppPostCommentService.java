package com.sharing.overload.service;

import com.sharing.overload.repository.AppPostCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppPostCommentService {

    @Autowired
    private AppPostCommentRepository repository;

}
