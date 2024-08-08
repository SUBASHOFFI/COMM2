package com.gift.website.Controller;



import com.gift.website.Modal.Profile;
import com.gift.website.service.ProfileService ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping("/addProfile")
    public ResponseEntity<Profile> addProfile(@RequestBody Profile profile) {
        Profile newProfile = profileService.addProfile(profile);
        return ResponseEntity.ok(newProfile);
    }

    @GetMapping("/getProfile")
    public ResponseEntity<Optional<Profile>> viewProfile(@RequestParam Long profileId) {
        Optional<Profile> profile = profileService.viewProfile(profileId);
        return ResponseEntity.ok(profile);
    }

    @PostMapping("/editProfile/{profileId}")
    public ResponseEntity<Profile> editProfile(@PathVariable Long profileId, @RequestBody Profile updatedProfile) {
        Profile profile = profileService.editProfile(profileId, updatedProfile);
        return ResponseEntity.ok(profile);
    }

    @PostMapping("/deleteProfile/{profileId}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long profileId) {
        profileService.deleteProfile(profileId);
        return ResponseEntity.ok().build();
    }
}
