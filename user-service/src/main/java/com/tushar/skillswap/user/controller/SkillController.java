package com.tushar.skillswap.user.controller;

import com.tushar.skillswap.user.entity.SkillEntity;
import com.tushar.skillswap.user.repository.SkillRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillRepository skillRepository;

    public SkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @GetMapping
    public List<SkillEntity> getAllSkills() {
        return skillRepository.findAll();
    }
}
