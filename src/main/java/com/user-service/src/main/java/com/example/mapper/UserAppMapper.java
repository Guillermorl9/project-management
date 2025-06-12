package com.example.mapper;

import com.example.dto.UserAppDto;
import com.example.model.UserApp;

public class UserAppMapper {

    public static UserAppDto toDto(UserApp userApp) {
        if (userApp == null) return null;

        UserAppDto dto = new UserAppDto();
        dto.setId(userApp.getId());
        dto.setName(userApp.getName());
        dto.setLastname(userApp.getLastname());
        dto.setEmail(userApp.getEmail());

        return dto;
    }
}
