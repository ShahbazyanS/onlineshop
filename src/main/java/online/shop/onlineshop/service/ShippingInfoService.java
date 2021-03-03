package online.shop.onlineshop.service;

import online.shop.onlineshop.model.ShippingInfo;
import online.shop.onlineshop.model.User;

public interface ShippingInfoService {

    ShippingInfo save(ShippingInfo shippingInfo, User user);

    ShippingInfo update(ShippingInfo shippingInfo, int id);

    ShippingInfo findById(int id);
}
