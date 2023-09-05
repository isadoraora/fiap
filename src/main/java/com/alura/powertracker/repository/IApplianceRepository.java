package com.alura.powertracker.repository;

import com.alura.powertracker.entity.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IApplianceRepository extends JpaRepository<Appliance, Long> {
}
