package com.gift.website.service;


import com.gift.website.Modal.Profile;
import com.gift.website.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public Profile addProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Optional<Profile> viewProfile(Long profileId) {
        return profileRepository.findById(profileId);
    }

    public Profile editProfile(Long profileId, Profile updatedProfile) {
        return profileRepository.findById(profileId)
            .map(profile -> {
                profile.setName(updatedProfile.getName());
                profile.setEmail(updatedProfile.getEmail());
                profile.setPhoneNumber(updatedProfile.getPhoneNumber());
                profile.setAddress(updatedProfile.getAddress());
                return profileRepository.save(profile);
            }).orElseGet(() -> {
                updatedProfile.setId(profileId);
                return profileRepository.save(updatedProfile);
            });
    }

    public void deleteProfile(Long profileId) {
        profileRepository.deleteById(profileId);
    }
}
