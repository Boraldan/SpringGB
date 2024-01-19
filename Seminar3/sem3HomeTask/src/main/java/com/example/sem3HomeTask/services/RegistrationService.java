package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Getter
@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final DataProcessingService dataProcessingService;
    private final UserService userService;
    private final NotificationService notificationService;

    public void processRegistration(User user){
        dataProcessingService.saveUser(user);
        notificationService.notifyUser(user);
    }


}
