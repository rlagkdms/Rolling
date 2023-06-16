package org.rolling.repository;

import org.rolling.domain.RollingPaper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RollingPaperRepository extends JpaRepository<RollingPaper, Long> {
}
