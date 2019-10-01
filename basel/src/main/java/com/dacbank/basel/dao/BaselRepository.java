package com.dacbank.basel.dao;

import com.dacbank.basel.dto.Basel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BaselRepository extends JpaRepository<Basel, Long> {
}
