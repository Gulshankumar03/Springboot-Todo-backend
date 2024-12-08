//package com.example.todoapp.controller;
//
//import com.example.todoapp.entity.User;
//import com.example.todoapp.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> signUp(@RequestBody User user) {
//        User createdUser = userService.createUser(user);
//        return ResponseEntity.ok(createdUser);
//    }
//
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
//        String username = credentials.get("username");
//        String password = credentials.get("password");
//        try {
//            User user = userService.authenticate(username, password);
//            Map<String, String> response = new HashMap<>();
//            response.put("message", "Login successful");
//            response.put("username", user.getUsername());
//            return ResponseEntity.ok(response);
//        } catch (UsernameNotFoundException | IllegalArgumentException e) {
//            return ResponseEntity.status(401).body("Invalid username or password");
//        }
//    }
//
//
//}


//
//
//
//package com.example.todoapp.controller;
//
//import com.example.todoapp.entity.User;
//import com.example.todoapp.service.UserService;
//import jakarta.servlet.http.Cookie;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
////import javax.servlet.http.Cookie; // Import this class
////import javax.servlet.http.HttpServletResponse; // Import this class
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> signUp(@RequestBody User user) {
//        User createdUser = userService.createUser(user);
//        return ResponseEntity.ok(createdUser);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials, HttpServletResponse response) {
//        String username = credentials.get("username");
//        String password = credentials.get("password");
//        try {
//            User user = userService.authenticate(username, password);
//            Map<String, String> responseBody = new HashMap<>();
//            responseBody.put("message", "Login successful");
//            responseBody.put("username", user.getUsername());
//
//            // Create a session cookie
//            Cookie cookie = new Cookie("sessionId", username); // Consider using a session ID instead
//            cookie.setPath("/");
//            cookie.setMaxAge(60 * 60); // Cookie expires in 1 hour
//            cookie.setSecure(true); // Set to true if using HTTPS
////            cookie.setDomain("yourdomain.com"); // Set to your domain if needed
//            cookie.setComment("Session ID cookie"); // Optional comment
//
//            response.addCookie(cookie); // Add the cookie to the response
//
//            return ResponseEntity.ok(responseBody);
//        } catch (UsernameNotFoundException | IllegalArgumentException e) {
//            return ResponseEntity.status(401).body("Invalid username or password");
//        }
//    }
//
//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(HttpServletResponse response) {
//        Cookie cookie = new Cookie("sessionId", null);
//        cookie.setPath("/");
//        cookie.setMaxAge(0); // Expire the cookie immediately
//
//        response.addCookie(cookie); // Remove the cookie from the response
//        return ResponseEntity.ok("Logout successful");
//    }
//}


//
//
//
//package com.example.todoapp.controller;
//
//import com.example.todoapp.entity.User;
//import com.example.todoapp.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import jakarta.servlet.http.Cookie; // Import from jakarta.servlet
//import jakarta.servlet.http.HttpServletResponse; // Import from jakarta.servlet
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> signUp(@RequestBody User user) {
//        User createdUser = userService.createUser(user);
//        return ResponseEntity.ok(createdUser);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials, HttpServletResponse response) {
//        String username = credentials.get("username");
//        String password = credentials.get("password");
//        try {
//            User user = userService.authenticate(username, password);
//            Map<String, String> responseBody = new HashMap<>();
//            responseBody.put("message", "Login successful");
//            responseBody.put("username", user.getUsername());
//
//            // Create a session cookie
//            Cookie cookie = new Cookie("sessionId", username); // Consider using a session ID instead
//            cookie.setPath("/");
//            cookie.setMaxAge(60 * 60); // Cookie expires in 1 hour
//            cookie.setSecure(false); // Set to true if using HTTPS
//            cookie.setHttpOnly(true); // Mitigate XSS attacks
//            response.addCookie(cookie); // Add the cookie to the response
//
//            return ResponseEntity.ok(responseBody);
//        } catch (UsernameNotFoundException | IllegalArgumentException e) {
//            return ResponseEntity.status(401).body("Invalid username or password");
//        }
//    }
//
//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(HttpServletResponse response) {
//        Cookie cookie = new Cookie("sessionId", null);
//        cookie.setPath("/");
//        cookie.setMaxAge(0); // Expire the cookie immediately
//
//        response.addCookie(cookie); // Remove the cookie from the response
//        return ResponseEntity.ok("Logout successful");
//    }
//}


package com.example.todoapp.controller;

import com.example.todoapp.entity.User;
import com.example.todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/basicauth")
    public String basicAuthCheck() {
        return "Success";
    }


//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials, HttpServletResponse response) {
//        String username = credentials.get("username");
//        String password = credentials.get("password");
//
//        try {
//            User user = userService.authenticate(username, password);
//
//            // Generate a unique session ID for the user session
//            String sessionId = UUID.randomUUID().toString();
//
//            // Add session ID as a cookie
//            Cookie cookie = new Cookie("sessionId", sessionId);
//            cookie.setPath("/");
//            cookie.setMaxAge(60 * 60); // Cookie expires in 1 hour
//            cookie.setSecure(false); // Set to true if using HTTPS
//            cookie.setHttpOnly(true); // Mitigate XSS attacks
//            response.addCookie(cookie);
//
//            // Return session ID and username in the response body
//            Map<String, String> responseBody = new HashMap<>();
//            responseBody.put("message", "Login successful");
//            responseBody.put("username", user.getUsername());
//            responseBody.put("sessionId", sessionId);
//
//            return ResponseEntity.ok(responseBody);
//
//        } catch (UsernameNotFoundException | IllegalArgumentException e) {
//            return ResponseEntity.status(401).body("Invalid username or password");
//        }
//    }
//
//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(HttpServletResponse response) {
//        // Clear the session ID cookie
//        Cookie cookie = new Cookie("sessionId", null);
//        cookie.setPath("/");
//        cookie.setMaxAge(0); // Expire the cookie immediately
//        cookie.setHttpOnly(true);
//        cookie.setSecure(true); // Set to true if using HTTPS
//
//        response.addCookie(cookie);
//        return ResponseEntity.ok("Logout successful");
//    }
}

