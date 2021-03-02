package online.shop.onlineshop.service;

import online.shop.onlineshop.model.ShippingInfo;
import online.shop.onlineshop.model.User;

public interface ShippingInfoServiceImpl {

    public ShippingInfo save(ShippingInfo shippingInfo, User user);

    public ShippingInfo update(ShippingInfo shippingInfo, int id);

    public ShippingInfo findById(int id);
}
