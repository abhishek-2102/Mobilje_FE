package com.niit.mobilje.dao;

import com.niit.mobilje.trans.OrderDetails;

public interface OrderDao {

	public String saveOrder(OrderDetails order);
}
