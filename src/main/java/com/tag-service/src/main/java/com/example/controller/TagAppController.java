package com.example.controller;

import com.example.model.TagApp;
import com.example.service.TagAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagAppController {

    private final TagAppService tagAppService;

    @GetMapping
    public List<TagApp> getAllTags() {
        return tagAppService.getAllTags();
    }

    @GetMapping("/{tagId}")
    public TagApp getTagById(@PathVariable Long tagId) {
        return tagAppService.getTagById(tagId);
    }

    @PostMapping
    public TagApp createTag(@RequestBody TagApp tagApp) {
        return tagAppService.createTag(tagApp);
    }

    @PutMapping("/{tagId}")
    public TagApp updateTag(@PathVariable Long tagId, @RequestBody TagApp tagApp) {
        return tagAppService.updateTag(tagId, tagApp);
    }

    @DeleteMapping("/{tagId}")
    public void deleteTag(@PathVariable Long tagId) {
        tagAppService.deleteTag(tagId);
    }

}
