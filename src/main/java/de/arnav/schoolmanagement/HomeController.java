package de.arnav.schoolmanagement;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController
{
    @GetMapping ("/")
    public String greeting()
    {
        return "Hello";
    }
}

