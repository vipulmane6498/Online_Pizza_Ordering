package com.pizzaOrdering.services;

import java.util.List;
import java.util.Optional;

import com.pizzaOrdering.model.Offer;

public interface OfferService {

	//Add Offer
	public Offer addOffer(Offer offer);
	
	//delete offer
	public void deleteOfferById( long id);
	
	//get Offer By Id
	public Optional<Offer> findOfferById( long id);
	
	//find all offers
	public List<Offer> findAllOffers();
	
	//Encapsulation
	//Edit Offer by id
	public Offer updateOffer(Offer offer);
}
