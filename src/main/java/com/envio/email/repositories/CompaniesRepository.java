package com.envio.email.repositories;

import com.envio.email.models.Companies;

import java.util.Optional;

public interface CompaniesRepository extends BaseRepository<Companies,Long> {

    Optional<Companies> findById(Long Id);

}
