package com.example.service;

import com.example.model.TagApp;
import com.example.repository.TagAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagAppService {

    private final TagAppRepository tagAppRepository;

    public List<TagApp> getAllTags() {
        return tagAppRepository.findAll();
    }

    public TagApp getTagById(Long id) {
        return tagAppRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag not found with id: " + id));
    }

    public TagApp createTag(TagApp tagApp) {
        return tagAppRepository.save(tagApp);
    }

    public TagApp updateTag(Long tagId, TagApp tagApp) {
        TagApp existingTagApp = tagAppRepository.findById(tagId)
                .orElseThrow(() -> new RuntimeException("Tag not found with id: " + tagId));

        existingTagApp.setTitle(tagApp.getTitle());
        existingTagApp.setDescription(tagApp.getDescription());

        return tagAppRepository.save(existingTagApp);
    }

    public void deleteTag(Long id) {
        tagAppRepository.deleteById(id);
    }
}
