package com.example.enterprise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such department")
public class DepartmentNotFoundException extends RuntimeException {
  public DepartmentNotFoundException() {}
}
