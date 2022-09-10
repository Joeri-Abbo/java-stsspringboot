package com.skillsoft.stsspringboot.controller;

import com.skillsoft.stsspringboot.model.User;
import com.skillsoft.stsspringboot.service.LookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class LookupAppController {
    private static final Logger logger = LoggerFactory.getLogger(LookupAppController.class);

    @Autowired
    private LookupService lookupService;

    private static int userIndex = 0;

    private static final List<String> userList = new ArrayList<String>();

    static {
        userList.add("PyTorch");
        userList.add("Tensorflow");
        userList.add("Scikit-learn");
        userList.add("spring-boot");
        userList.add("spring-mvc");
        userList.add("spring-security");
        userList.add("joeri-abbo");
    }

    @Scheduled(fixedRate = 2000)
    public void scheduledTasks() throws Exception {
        CompletableFuture<User> info = lookupService.findUser(userList.get(userIndex));
        userIndex = (userIndex + 1) % userList.size();
        logger.info("--> " + info.get());
    }
}