package com.matrimonyapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matrimonyapplication.dto.PartnerPreferencesDto;
import com.matrimonyapplication.service.PartnerPreferencesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/preferences")
public class PartnerPreferencesController {

    @Autowired
    private PartnerPreferencesService partnerPreferencesService;

    @PostMapping
    public ResponseEntity<PartnerPreferencesDto> createPreferences(@RequestParam Long userId, @Valid @RequestBody PartnerPreferencesDto partnerPreferencesDto) {
        PartnerPreferencesDto createdDto = partnerPreferencesService.createPartnerPreferences(userId, partnerPreferencesDto);
        return ResponseEntity.ok(createdDto);
    }

    @GetMapping
    public ResponseEntity<PartnerPreferencesDto> getPreferences(@RequestParam Long userId) {
        PartnerPreferencesDto dto = partnerPreferencesService.getPartnerPreferences(userId);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<PartnerPreferencesDto> updatePreferences(@RequestParam Long userId, @Valid @RequestBody PartnerPreferencesDto partnerPreferencesDto) {
        PartnerPreferencesDto updatedDto = partnerPreferencesService.updatePartnerPreferences(userId, partnerPreferencesDto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping
    public ResponseEntity<?> deletePreferences(@RequestParam Long userId) {
        partnerPreferencesService.deletePartnerPreferences(userId);
        return ResponseEntity.ok().build();
    }
}