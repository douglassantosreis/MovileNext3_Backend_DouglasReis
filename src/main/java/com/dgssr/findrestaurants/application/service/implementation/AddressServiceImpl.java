package com.dgssr.findrestaurants.application.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgssr.findrestaurants.application.service.AddressService;
import com.dgssr.findrestaurants.domain.Address;
import com.dgssr.findrestaurants.domain.InputSearch;
import com.dgssr.findrestaurants.infrastructure.repositories.AddressRepository;
import com.dgssr.findrestaurants.infrastructure.utilities.HaversineCalc;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public List<Address> findAll() {
		return (List<Address>) addressRepository.findAll();
	}

	@Override
	public List<Address> findByLatitudeAndLongitude(double latitude, double longitude, double maxKilometers) {

		List<Address> addresses = (List<Address>) addressRepository.findAll();

		InputSearch inputSearch = new InputSearch
										.InputSearchBuilder()
										.addLatitude(latitude)
										.addLongitude(longitude)
										.addMaxKilometers(maxKilometers).build();

		return transformResult(addresses, inputSearch);
	}

	@Override
	public List<Address> findByRestaurantAndLatitudeAndLongitude(Integer restaurantId, double latitude,
			double longitude, double maxKilometers) {

		InputSearch inputSearch = new InputSearch
										.InputSearchBuilder()
										.addLatitude(latitude)
										.addLongitude(longitude)
										.addMaxKilometers(maxKilometers)
										.addRestaurantId(restaurantId).build();

		Optional<List<Address>> addresses = addressRepository.findByRestaurantId(inputSearch.getRestaurantId());

		if (addresses.isPresent()) {
			return transformResult(addresses.get(), inputSearch);
		} else {
			return new ArrayList<Address>();
		}
	}

	@Override
	public List<Address> transformResult(List<Address> addresses, InputSearch inputSearch) {

		List<Address> addressesReturn = new ArrayList<Address>();
		
		addresses.forEach(address -> {
			
			HaversineCalc haversineCalc = new HaversineCalc(inputSearch.getLatitude(), inputSearch.getLongitude(), address.getLatitude(),
					address.getLongitude());
			
			if (address.getRestaurant().isOpen() && (haversineCalc.distance() < inputSearch.getMaxKilometers())) {
				addressesReturn.add(address);
			}
		});

		return addressesReturn;
	}
}
