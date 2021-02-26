package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.exception.ResourceNotFoundException;
import online.shop.onlineshop.model.ShippingInfo;
import online.shop.onlineshop.model.User;
import online.shop.onlineshop.repository.ShippingInfoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShippingInfoService {

    private final ShippingInfoRepository shippingInfoRepository;


    public ShippingInfo save(ShippingInfo shippingInfo, User user) {
        user.setShippingInfo(shippingInfo);
        return shippingInfoRepository.save(shippingInfo);
    }

    public ShippingInfo update(ShippingInfo shippingInfo, int id) {
        ShippingInfo shippingInfo1 = shippingInfoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Sipping Info with id " + id + " does not exist"));
        shippingInfo1.setAddressLine(shippingInfo.getAddressLine());
        shippingInfo1.setCity(shippingInfo.getCity());
        shippingInfo1.setCountry(shippingInfo.getCountry());
        return shippingInfo1;
    }

    public ShippingInfo findById(int id){
        return shippingInfoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Sipping Info with id " + id + " does not exist"));
    }
}
