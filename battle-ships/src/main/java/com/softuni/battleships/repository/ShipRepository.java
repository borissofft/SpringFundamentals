package com.softuni.battleships.repository;

import com.softuni.battleships.model.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    Optional<Ship> findByName(String name);
    List<Ship> findAllByUser_Id(Long user_id);
    List<Ship> findAllByUser_IdNot(Long user_id);

}
