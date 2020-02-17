package com.androidcommand.app.business.entities.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.androidcommand.app.business.entities.SeedStarter;


@Repository
public class SeedStarterRepository {

    private final List<SeedStarter> seedStarters = new ArrayList<SeedStarter>();
    
    
    
    public SeedStarterRepository() {
        super();
    }
    
    
    
    public List<SeedStarter> findAll() {
        return new ArrayList<SeedStarter>(this.seedStarters);
    }

    
    public void add(final SeedStarter seedStarter) {
        this.seedStarters.add(seedStarter);
    }
    
    
    
}
