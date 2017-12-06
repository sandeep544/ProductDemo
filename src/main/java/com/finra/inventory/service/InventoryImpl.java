package com.finra.inventory.service;

import org.springframework.stereotype.Component;

@Component
public class InventoryImpl implements Inventory {

	@Override
	public boolean CheckInventory(String id, int qty) {
		if (null != id && 0 != qty) {
			// Need to Read records from database by default making the total
			// quality as 100
			int totQty = 100;
			if (qty < totQty) {
				return true;
			}
		}

		return false;
	}

}
