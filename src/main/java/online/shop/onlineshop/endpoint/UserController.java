package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.dto.AuthRequest;
import online.shop.onlineshop.dto.AuthResponse;
import online.shop.onlineshop.dto.UserDto;
import online.shop.onlineshop.model.User;
import online.shop.onlineshop.security.CurrentUser;
import online.shop.onlineshop.security.JwtTokenUtil;
import online.shop.onlineshop.service.EmailService;
import online.shop.onlineshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final JwtTokenUtil jwtTokenUtil;
    private final EmailService emailService;


    @PostMapping("/add")
    public ResponseEntity<User> save(@RequestBody UserDto userDto, Locale locale) throws MessagingException {
        if (userDto.getPassword().equals(userDto.getConfirmPassword())) {
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            User user = modelMapper.map(userDto, User.class);
            user.setActive(false);
            user.setToken(UUID.randomUUID().toString());

            userService.saveUser(user);
            String link = "http://localhost:8080/user/activate?email=" + user.getEmail() + "&token=" + user.getToken();
            emailService.sendHtmlEmil(userDto.getEmail(), "Welcome", user, link, "email/userEmail.html", locale);
            return ResponseEntity.ok(user);
        }
        return null;
    }

    @GetMapping("/activate")
    public User activate(@RequestParam("email") String email, @RequestParam("token") String token) {
        User user = userService.findByEmail(email);
        if (user.getToken().equals(token)) {
            user.setActive(true);
            user.setToken("");
            userService.saveUser(user);
            return user;
        }
        return null;
    }


    @PostMapping("/auth")
    public ResponseEntity auth(@RequestBody AuthRequest authRequest) {
        User user = userService.findByEmail(authRequest.getEmail());
        if (user != null) {
            if (passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
                String token = jwtTokenUtil.generateToken(user.getEmail());
                return ResponseEntity.ok(AuthResponse.builder()
                        .token(token)
                        .name(user.getUsername())
                        .build());
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");

    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @GetMapping("/")
    public User getUser(@AuthenticationPrincipal CurrentUser currentUser) {
        int id = currentUser.getUser().getId();
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }

    @DeleteMapping("/delete")
    public void delete(@AuthenticationPrincipal CurrentUser currentUser) {
        int id = currentUser.getUser().getId();
        userService.deleteUser(id);
    }
}
