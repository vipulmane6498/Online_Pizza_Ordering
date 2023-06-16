package com.pizzaOrdering.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaOrdering.model.Offer;

public interface OfferDao extends JpaRepository<Offer, Long>{

}
