package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.PersonalInfo;
import online.shop.onlineshop.model.User;
import online.shop.onlineshop.security.CurrentUser;
import online.shop.onlineshop.service.PersonalInfoService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("personal_info")
public class PersonalInfoController {

    private final PersonalInfoService personalInfoService;

    @PostMapping("/add")
    public PersonalInfo save(@RequestBody PersonalInfo personalInfo, @AuthenticationPrincipal CurrentUser currentUser) {
        User user = currentUser.getUser();
        personalInfo.setName(user.getUsername());
        personalInfo.setEmail(user.getEmail());
        return personalInfoService.save(personalInfo);
    }

    @PutMapping("/edit/{id}")
    public PersonalInfo update(@RequestBody PersonalInfo personalInfo, @PathVariable("id") int id) {
        return personalInfoService.update(personalInfo, id);
    }

    @DeleteMapping("/delete{id}")
    public void delete(@PathVariable("id") int id) {
        personalInfoService.delete(id);
    }

    @GetMapping("/get")
    public PersonalInfo getPI(@AuthenticationPrincipal CurrentUser currentUser){
        return personalInfoService.getPI(currentUser.getUser().getEmail());
    }
}
