package xyz.todooc4.university.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import xyz.todooc4.university.entity.ObligationDefinition;

@Repository
public interface ObligationDefinitionRepository extends JpaRepository<ObligationDefinition, Integer>, JpaSpecificationExecutor<ObligationDefinition> {

}