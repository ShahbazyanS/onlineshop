package online.shop.onlineshop.service;

import online.shop.onlineshop.model.PersonalInfo;
import online.shop.onlineshop.model.User;

public interface PersonalInfoService {

    PersonalInfo save(PersonalInfo personalInfo, User user);

    PersonalInfo update(PersonalInfo personalInfo, int id);

    PersonalInfo findById(int id);

    void delete(int id);

    PersonalInfo getPI(String email);
}
