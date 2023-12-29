package com.youtube.Bridge.controller;

import com.youtube.Bridge.entity.Course;
import com.youtube.Bridge.entity.ImageModel;
import com.youtube.Bridge.service.Courseservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
public class CourseConroller {
    @Autowired
    private Courseservice courseservice;
    @PostMapping(value={"/addnewcourse"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Course addNewCourse(@RequestPart("course") Course course,
                               @RequestPart("imageFile")MultipartFile[] file) {

try {
Set<ImageModel> images=uploadImage(file);
course.setCourseImage(images);
return courseservice.addnewcourse(course);
}catch (Exception e){
    System.out.println(e.getMessage());
}return null;
            }
    public Set<ImageModel> uploadImage(MultipartFile[] MultipartFiles)throws IOException {
        Set<ImageModel> imageModels= new HashSet<>();
        for(MultipartFile file:MultipartFiles){
            ImageModel imageModel=new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()

            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }
}
