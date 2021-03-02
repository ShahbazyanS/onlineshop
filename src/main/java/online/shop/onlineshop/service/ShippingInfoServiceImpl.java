package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.exception.ResourceNotFoundException;
import online.shop.onlineshop.model.ShippingInfo;
import online.shop.onlineshop.model.User;
import online.shop.onlineshop.repository.ShippingInfoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShippingInfoServiceImpl implements ShippingInfoService {

    private final ShippingInfoRepository shippingInfoRepository;

    @Override
    public ShippingInfo save(ShippingInfo shippingInfo, User user) {
        user.setShippingInfo(shippingInfo);
        return shippingInfoRepository.save(shippingInfo);
    }

    @Override
    public ShippingInfo update(ShippingInfo shippingInfo, int id) {
        ShippingInfo shippingInfoDB = shippingInfoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Sipping Info with id " + id + " does not exist"));
        shippingInfo.setId(shippingInfoDB.getId());
        return shippingInfoDB;
    }

    @Override
    public ShippingInfo findById(int id) {
        return shippingInfoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Sipping Info with id " + id + " does not exist"));
    }
}
