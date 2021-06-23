package com.example.model.service.implement;

import com.example.model.entity.Province;
import com.example.model.repository.IProvinceRepository;
import com.example.model.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository provinceRepository;
    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void delete(Long id) {
        provinceRepository.deleteById(id);
    }
}
