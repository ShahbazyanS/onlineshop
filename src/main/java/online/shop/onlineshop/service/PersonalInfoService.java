package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.exception.ResourceNotFoundException;
import online.shop.onlineshop.model.PersonalInfo;
import online.shop.onlineshop.repository.PersonalInfoRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PersonalInfoService {

    private final PersonalInfoRepository personalInfoRepository;

    public PersonalInfo save(PersonalInfo personalInfo){
        return personalInfoRepository.save(personalInfo);
    }

    public PersonalInfo update(PersonalInfo personalInfo, int id){
        PersonalInfo personalInfo1 = personalInfoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource by id " + id + " does not exist"));

        personalInfo1.setName(personalInfo.getName());
        personalInfo1.setEmail(personalInfo.getEmail());
        personalInfo1.setPhone(personalInfo.getPhone());

        return personalInfoRepository.save(personalInfo1);
    }

    public PersonalInfo findById(int id){
        return personalInfoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Personal info by id " + id + " does not exist"));
    }

    public void delete(int id){
        personalInfoRepository.deleteById(id);
    }

    public PersonalInfo getPI(String email){
        return personalInfoRepository.findByEmail(email);
    }
}
