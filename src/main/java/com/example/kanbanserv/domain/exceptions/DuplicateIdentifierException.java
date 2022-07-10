package com.example.kanbanserv.domain.exceptions;

public class DuplicateIdentifierException extends Exception{
    private String projectId;
    private String message;

    public DuplicateIdentifierException(String message) {
        super(message);
        this.message = message;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
