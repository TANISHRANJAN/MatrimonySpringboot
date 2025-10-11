package com.matrimonyapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimonyapplication.dto.PartnerPreferencesDto;
import com.matrimonyapplication.entity.PartnerPreferences;
import com.matrimonyapplication.entity.User;
import com.matrimonyapplication.repository.PartnerPreferencesRepository;
import com.matrimonyapplication.repository.UserRepository;
import com.matrimonyapplication.service.PartnerPreferencesService;

@Service
public class PartnerPreferencesServiceImpl implements PartnerPreferencesService {

    @Autowired
    private PartnerPreferencesRepository partnerPreferencesRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public PartnerPreferencesDto createPartnerPreferences(Long userId, PartnerPreferencesDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found."));
        PartnerPreferences p = new PartnerPreferences();
        p.setUser(user);
        p.setPreferredAgeStart(dto.getPreferredAgeStart());
        p.setPreferredAgeEnd(dto.getPreferredAgeEnd());
        p.setPreferredGender(dto.getPreferredGender());
        PartnerPreferences saved = partnerPreferencesRepository.save(p);
        return convertToDto(saved);
    }

    @Override
    public PartnerPreferencesDto getPartnerPreferences(Long userId) {
        PartnerPreferences p = partnerPreferencesRepository.findByUserId(userId);
        if (p == null) {
            throw new RuntimeException("Partner Preferences not found.");
        }
        return convertToDto(p);
    }

    @Override
    public PartnerPreferencesDto updatePartnerPreferences(Long userId, PartnerPreferencesDto dto) {
        PartnerPreferences p = partnerPreferencesRepository.findByUserId(userId);
        if (p == null) {
            throw new RuntimeException("Partner Preferences not found.");
        }
        p.setPreferredAgeStart(dto.getPreferredAgeStart());
        p.setPreferredAgeEnd(dto.getPreferredAgeEnd());
        p.setPreferredGender(dto.getPreferredGender());
        PartnerPreferences updated = partnerPreferencesRepository.save(p);
        return convertToDto(updated);
    }

    @Override
    public void deletePartnerPreferences(Long userId) {
        PartnerPreferences p = partnerPreferencesRepository.findByUserId(userId);
        if (p != null) {
            partnerPreferencesRepository.delete(p);
        }
    }

    private PartnerPreferencesDto convertToDto(PartnerPreferences p) {
        PartnerPreferencesDto dto = new PartnerPreferencesDto();
        dto.setId(p.getId());
        dto.setUserId(p.getUser().getId());
        dto.setPreferredAgeStart(p.getPreferredAgeStart());
        dto.setPreferredAgeEnd(p.getPreferredAgeEnd());
        dto.setPreferredGender(p.getPreferredGender());
        return dto;
    }
}