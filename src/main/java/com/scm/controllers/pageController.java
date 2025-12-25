package com.scm.controllers;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helper.Message;
import com.scm.helper.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class pageController {

  @Autowired
  private UserService userService;

  @RequestMapping("/home")
  public String home(Model model) {
    System.out.println("Home page handler");

    // Sending data to view
    model.addAttribute("name", "Lens World");
    model.addAttribute("youtubeChannel", "Code With Mahesh");
    model.addAttribute("gitUsername", "mahesh4434");
    model.addAttribute("Hello", " India is my Country");
    model.addAttribute("reviewLink",
        "https://www.google.com/search?sca_esv=48308ae346848ecf&cs=1&sxsrf=AE3TifMahfqfSxUelRjoRvCotLBGh51e8Q:1765716003548&si=AMgyJEtREmoPL4P1I5IDCfuA8gybfVI2d5Uj7QMwYCZHKDZ-E-9dH13wkf3-1hz6b3T_ynlqWFMsBYI9GgOEk84_bVUx2eJ8e5ubIjdmnhk_H259fQQNNPZ6NwSfWSm6S7Fc0CETxyKbf8UlSWM2rNfF468uhl2cVA%3D%3D&q=Lens+World+Krushna+Chowk+Reviews&sa=X&ved=2ahUKEwjWuqnZjL2RAxUJTmwGHbcQHbwQ0bkNegQIHhAD&biw=1536&bih=730&dpr=1.25");
    return "home";
  }

  // Controller for About

  @RequestMapping("/about")
  public String aboutPage() {
    System.out.println("About Page loading!!");
    return "about";
  }

  // Controller for Serviece
  @RequestMapping("/services")
  public String aboutServicePage() {
    System.out.println("Service Page loading!!");
    return "services";
  }

  // Controller for contact
  @RequestMapping("/contact")
  public String aboutContactPage() {
    System.out.println("Contact Page loading!!");
    return "contact";
  }

  // Controller for Login
  @RequestMapping("/login")
  public String aboutLoginPage() {
    System.out.println("Login Page loading!!");
    return "login";
  }

  // Controller for Login
  @RequestMapping("/register")
  public String aboutRegisterPage(Model model) {
    UserForm userForm = new UserForm();
    // Ya madhe tumhi default data pn add kru shkta!!
    model.addAttribute("userForm", userForm);

    return "register";

  }

  // Processing Register
  @RequestMapping(value = "/do-register", method = RequestMethod.POST)
  public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult,
      HttpSession session) {
    System.out.println("Processing Registration!!!");

    // 1) Fetch data from request
    // UserForm navacha ek class banvun tya madhe data fetch karel
    System.out.println(userForm);
    // Validaate form data
    if (rBindingResult.hasErrors()) {
      return "register";
    }
    // Save to database
    // Ithe apn user from se ek user banaya hai!
    /*
     * User user = User.builder()
     * .name(userForm.getName())
     * .email(userForm.getEmail())
     * .password(userForm.getPassword())
     * .about(userForm.getAbout())
     * .phoneNumber(userForm.getPhoneNumber())
     * .profilePic(
     * "https://www.freepik.com/free-vector/user-circles-set_145856997.htm#fromView=keyword&page=1&position=2&uuid=3d6cd15c-4824-40e5-893d-7084dc20fa3c&query=Default+user")
     * .build();
     */

    User user = new User();
    user.setName(userForm.getName());
    user.setEmail(userForm.getEmail());
    user.setPassword(userForm.getPassword());
    user.setAbout(userForm.getAbout());
    user.setProfilePic(
        "https://www.freepik.com/free-vector/user-circles-set_145856997.htm#fromView=keyword&page=1&position=2&uuid=3d6cd15c-4824-40e5-893d-7084dc20fa3c&query=Default+user");
    userService.saveUser(user);
    System.out.println(" Registration sucessfull!;");
    // Ya sathi ek userService navachi method user karel ki ji USer che sagel
    // databse che bussinesslogic execute karel
    Message message = Message.builder().content("Registration Sucessfull!").type(MessageType.green).build();
    session.setAttribute("message", message);
    // message= " Registration sucessfull!;"
    // redirect to same register page
    return "redirect:/register";

  }
}
