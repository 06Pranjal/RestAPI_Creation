package com.practice.myapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.practice.myapp.MyappApplication;
import com.practice.myapp.helper.FileUploadHelper;

@RestController
public class FileUploadController {

    private final MyappApplication myappApplication;

    @Autowired
    private FileUploadHelper fileUploadHelper;

    FileUploadController(MyappApplication myappApplication) {
        this.myappApplication = myappApplication;
    }

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){

        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getContentType());
        // System.out.println(file.getName());

        try {
            
            if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must contain file");
        }

        if(file.getContentType().equals("image/jpg")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only Jpeg allowed");
        }

        //file upload code..

        boolean f=fileUploadHelper.uploadFile(file);
        if(f){
            return ResponseEntity.ok("File uploaded Succesfully");
        }


        } catch (Exception e) {
            e.printStackTrace();
        }
        



        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    
}
