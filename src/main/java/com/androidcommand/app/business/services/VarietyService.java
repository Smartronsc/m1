/*
 * =============================================================================
 *
 *   Copyright (c) 2020, RichardBradleySmith.com All Rights Reserved
 *
 * =============================================================================
 */
package com.androidcommand.app.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.androidcommand.app.business.entities.Variety;
import com.androidcommand.app.business.entities.repositories.VarietyRepository;

@Service
public class VarietyService {
    
    @Autowired
    private VarietyRepository varietyRepository; 
    
    
    public VarietyService() {
        super();
    }
    
    
    
    public List<Variety> findAll() {
        return this.varietyRepository.findAll();
    }

    public Variety findById(final Integer id) {
        return this.varietyRepository.findById(id);
    }
    
}
