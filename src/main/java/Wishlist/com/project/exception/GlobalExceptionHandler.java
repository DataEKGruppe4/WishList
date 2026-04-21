package Wishlist.com.project.exception;

import Wishlist.com.project.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleDuplicateUserException(DuplicateUserException e, Model model) {

        model.addAttribute("errorMessage", e.getMessage());
        model.addAttribute("user", new User());

        return "opret";
    }

    @ExceptionHandler(InvalidLoginException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidLoginException(InvalidLoginException e, Model model) {

        model.addAttribute("error", e.getMessage());
        model.addAttribute("user", new User());

        return "login";
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(NoResourceFoundException e, Model model) {
        return "error/404";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGeneralException(Exception e, Model model) {

        model.addAttribute("errorMessage", "Der opstod en uventet fejl.");

        return "error/500";
    }
}