package Wishlist.com.project.exception;

import Wishlist.com.project.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleDuplicateUserException(DuplicateUserException ex, Model model) {

        model.addAttribute("errorMessage", ex.getMessage());
        model.addAttribute("user", new User());

        return "opret";
    }

    @ExceptionHandler(InvalidLoginException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidLoginException(InvalidLoginException ex, Model model) {

        model.addAttribute("error", ex.getMessage());
        model.addAttribute("user", new User());

        return "login";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGeneralException(Exception ex, Model model) {

        model.addAttribute("errorMessage", "Der opstod en uventet fejl.");

        return "error/500";
    }
}