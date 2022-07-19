package com.project.mirinae.domain.manual.repository;

import com.project.mirinae.domain.manual.entity.Manual;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ManualRepository extends JpaRepository<Manual, Integer> {

    Manual getReferenceByTitle(String title);

    Optional<Manual> findByTitle(String title);

    List<Manual> findAllByCategory(String category);

}
