package com.envio.email.services;


import com.envio.email.models.Companies;
import com.envio.email.repositories.CompaniesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class CompaniesSevice {


    private final CompaniesRepository repository;
    private final ModelMapper modelMapper;


    public CompaniesSevice(
            CompaniesRepository repository,
            ModelMapper modelMapper
    ) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }


    public List<Companies> findAll() {
            return Optional.ofNullable(repository.findAll()).orElse(new ArrayList<>());
        }
}
