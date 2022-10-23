package at.fhtw.swen3.model.repositories;

import at.fhtw.swen3.model.entities.RecipientModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends JpaRepository<RecipientModelEntity, Long> {

}
