package com.tushar.skillswap.user.controller;

import com.tushar.skillswap.user.entity.UserSkillEntity;
import com.tushar.skillswap.user.repository.UserSkillRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-skills")
public class UserSkillController {

    private final UserSkillRepository userSkillRepository;

    public UserSkillController(UserSkillRepository userSkillRepository) {
        this.userSkillRepository = userSkillRepository;
    }

    @GetMapping("/user/{userId}")
    public List<UserSkillEntity> getSkillsForUser(@PathVariable("userId") Long userId) {
        return userSkillRepository.findByUserId(userId);
    }
}
