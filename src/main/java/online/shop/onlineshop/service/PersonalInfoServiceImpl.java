package online.shop.onlineshop.service;

import online.shop.onlineshop.model.PersonalInfo;
import online.shop.onlineshop.model.User;

public interface PersonalInfoServiceImpl {

    public PersonalInfo save(PersonalInfo personalInfo, User user);

    public PersonalInfo update(PersonalInfo personalInfo, int id);

    public PersonalInfo findById(int id);

    public void delete(int id);

    public PersonalInfo getPI(String email);
}
