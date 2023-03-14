package com.shoppershub.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppershub.entity.CartInfo;

public interface CartRepo extends JpaRepository<CartInfo, Integer> {

}
