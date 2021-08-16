package com.softuni.judjev2.service.impl;

import com.softuni.judjev2.repository.CommentRepository;
import com.softuni.judjev2.service.CommandService;
import org.springframework.stereotype.Service;

@Service
public class CommandServiceImpl implements CommandService {

    private final CommentRepository commentRepository;

    public CommandServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
