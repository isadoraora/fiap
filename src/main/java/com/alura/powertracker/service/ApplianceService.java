package com.alura.powertracker.service;

import com.alura.powertracker.entity.model.ApplianceDTO;
import com.alura.powertracker.exception.GatewayException;
import com.alura.powertracker.exception.NotFoundException;
import com.alura.powertracker.mapper.ApplianceMapper;
import com.alura.powertracker.repository.IApplianceRepository;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplianceService {

  @Autowired
  private IApplianceRepository iApplianceRepository;

  @Transactional(readOnly = true)
  public Page<ApplianceDTO> findAll(PageRequest pageRequest) {
    var appliances = iApplianceRepository.findAll(pageRequest);
    return appliances.map(ApplianceMapper::fromEntity);
  }

  @Transactional(readOnly = true)
  public ApplianceDTO findById(Long id) {
    var appliance = iApplianceRepository.findById(id).orElseThrow(
        () -> new NotFoundException("Appliance not found.")
    );

    return ApplianceMapper.fromEntity(appliance);
  }

  @Transactional
  public ApplianceDTO save(ApplianceDTO applianceDTO) {
    try {
      var appliance = iApplianceRepository.getReferenceById(applianceDTO.id());
      var entity = ApplianceMapper.toEntity(applianceDTO);
      var savedAppliance = iApplianceRepository.save(entity);
      return ApplianceMapper.fromEntity(savedAppliance);

    } catch (DataIntegrityViolationException die) {
      throw new GatewayException("Data integrity violation");
    }
  }

  @Transactional
  public ApplianceDTO update(Long id, ApplianceDTO applianceDTO) {
    try {
      var appliance = iApplianceRepository.getReferenceById(id);
      ApplianceMapper.mapperDtoToEntity(applianceDTO, appliance);
      appliance = iApplianceRepository.save(appliance);
      return ApplianceMapper.fromEntity(appliance);

    } catch (EntityNotFoundException enf) {
      throw new NotFoundException("Appliance not found.");
    }
  }

  @Transactional
  public void delete(Long id) {
    try {
      iApplianceRepository.deleteById(id);
    } catch (DataIntegrityViolationException die) {
      throw new GatewayException("Data integrity violation");
    }
  }
}
