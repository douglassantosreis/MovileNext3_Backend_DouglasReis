package com.dgssr.findrestaurants.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgssr.findrestaurants.exception.AddressNotFoundException;
import com.dgssr.findrestaurants.model.Address;
import com.dgssr.findrestaurants.model.InputSearch;
import com.dgssr.findrestaurants.repository.AddressRepository;
import com.dgssr.findrestaurants.service.AddressService;
import com.dgssr.findrestaurants.util.Haversine;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public List<Address> findAll() {

		List<Address> addresses = (List<Address>) addressRepository.findAll();
		
		return addresses;
	}

	@Override
	public List<Address> findByLatitudeAndLongitude(double latitude, double longitude, double maxKilometers) {

		List<Address> addresses = (List<Address>) addressRepository.findAll();

		return validateAdressesList(addresses, new InputSearch.InputSearchBuilder().addLatitude(latitude)
				.addLongitude(longitude).addMaxKilometers(maxKilometers).build());
	}

	@Override
	public List<Address> findByRestaurantAndLatitudeAndLongitude(Integer restaurantId, double latitude,
			double longitude, double maxKilometers) {

		InputSearch inputSearch = new InputSearch.InputSearchBuilder().addLatitude(latitude).addLongitude(longitude)
				.addMaxKilometers(maxKilometers).addRestaurantId(restaurantId).build();

		Optional<List<Address>> addresses = addressRepository.findByRestaurantId(inputSearch.getRestaurantId());

		if (addresses.isPresent()) {
			return validateAdressesList(addresses.get(), inputSearch);
		} else {
			return new ArrayList<Address>();
		}
	}

	public List<Address> validateAdressesList(List<Address> addresses, InputSearch inputSearch)
			throws AddressNotFoundException {

		List<Address> addressesReturn = new ArrayList<Address>();
		addresses.forEach(address -> {
			if (checkIfRestaurantIsElegible(inputSearch, address)) {
				addressesReturn.add(address);
			}
		});
		
		return addressesReturn;

	}

	public boolean checkIfRestaurantIsElegible(InputSearch inputSearch, Address address) {
		return (Haversine.distance(inputSearch.getLatitude(), inputSearch.getLongitude(), address.getLatitude(),
				address.getLongitude()) < inputSearch.getMaxKilometers()) && address.isOpen();
	}
}
