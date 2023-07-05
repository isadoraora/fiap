package com.alura.powertracker.repository;

import com.alura.powertracker.domain.model.ApplianceDTO;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Repository;

@Repository
public class ApplianceRepository {

  private Set<ApplianceDTO> appliances;

  public ApplianceRepository(){
    appliances = new HashSet<>();
  }

  public void save(ApplianceDTO applianceDTO) {
    appliances.add(applianceDTO);
  }

}
