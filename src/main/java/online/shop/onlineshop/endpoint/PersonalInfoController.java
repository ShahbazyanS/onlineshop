package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.PersonalInfo;
import online.shop.onlineshop.security.CurrentUser;
import online.shop.onlineshop.service.PersonalInfoServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("personal_info")
public class PersonalInfoController {

    private final PersonalInfoServiceImpl personalInfoService;

    @PutMapping("/edit/{id}")
    public PersonalInfo update(@RequestBody PersonalInfo personalInfo, @PathVariable("id") int id) {
        return personalInfoService.update(personalInfo, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        personalInfoService.delete(id);
    }

    @GetMapping("/")
    public PersonalInfo getPI(@AuthenticationPrincipal CurrentUser currentUser) {
        return personalInfoService.getPI(currentUser.getUser().getEmail());
    }
}
