package com.backendargp.login.exp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpRepository extends JpaRepository<Exp, Integer> {
    public Optional<Exp> findByNameE(String nameE);
    public boolean existsByNameE(String nameE);
}
