package com.dzg.springarcgis.service.impl;

import com.dzg.springarcgis.domain.Location;
import com.dzg.springarcgis.mapper.LocationMapper;
import com.dzg.springarcgis.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationMapper locationMapper;
    @Override
    public int insertLocation(Location location) {

        return locationMapper.insertLocation(location);
    }
}
