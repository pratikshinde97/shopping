package com.example.shopping.Item;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AppController {

    @Autowired
    private CandidateRepository candidateRepo;
 //   Candidate candidate;
    @PostMapping("/upload_multiple")
    public String handleFormSubmit(  Candidate candidate,
                                   @RequestParam("profilePictureFile") MultipartFile multipartFile1,
                                   @RequestParam("photoIdFile") MultipartFile multipartFile2,
                                   @RequestParam("documentFile") MultipartFile multipartFile3) throws IOException {

        String profilePictureFileName = StringUtils.cleanPath(multipartFile1.getOriginalFilename());
        String photoIdFileName = StringUtils.cleanPath(multipartFile2.getOriginalFilename());
        String documentFileName = StringUtils.cleanPath(multipartFile3.getOriginalFilename());

        candidate.setProfilePicture(profilePictureFileName);
        candidate.setPhotoId(photoIdFileName);
        candidate.setDocument(documentFileName);

        Candidate savedCandidate = candidateRepo.save(candidate);
        String uploadDir = "candidates/" + savedCandidate.getId();

        FileUploadUtil.saveFile(uploadDir, profilePictureFileName, multipartFile1);
        FileUploadUtil.saveFile(uploadDir, photoIdFileName, multipartFile2);
        FileUploadUtil.saveFile(uploadDir, documentFileName, multipartFile3);

        return "message";
    }

}