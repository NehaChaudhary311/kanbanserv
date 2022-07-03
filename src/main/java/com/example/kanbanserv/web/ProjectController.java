package com.example.kanbanserv.web;

import com.example.kanbanserv.domain.Project;
import com.example.kanbanserv.domain.error.Error;
import com.example.kanbanserv.domain.error.ErrorDetails;
import com.example.kanbanserv.services.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, Errors errors){

        if(errors.hasErrors()){
            List<ErrorDetails> errorList = new ArrayList<>();
            for(FieldError error: errors.getFieldErrors()){
                errorList.add(ErrorDetails.builder()
                                          .field(error.getField())
                                          .description(error.getDefaultMessage())
                                          .build());
            }

            return new ResponseEntity<Error>(Error.builder()
                                                  .name("INVALID_REQUEST")
                                                  .message("Invalid Request")
                                                  .errorDetailsList(errorList)
                                                  .build(), HttpStatus.BAD_REQUEST);
        }
        try{
            Project project1 = projectService.saveOrUpdateProject(project);
            return new ResponseEntity<Project>(project, HttpStatus.CREATED);
        }
        catch(Exception e) {
            log.error("Project couldn't be created", e);
            return new ResponseEntity<Error>(Error.builder()
                                                  .name("DUPLICATE_REQUEST")
                                                  .message("Duplicate Project Identifier")
                                                  .build(),HttpStatus.BAD_REQUEST );
        }

    }

}
