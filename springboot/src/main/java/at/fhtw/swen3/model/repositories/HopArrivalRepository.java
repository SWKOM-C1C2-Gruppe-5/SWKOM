package at.fhtw.swen3.model.repositories;

import at.fhtw.swen3.model.entities.HopArrivalModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HopArrivalRepository extends JpaRepository<HopArrivalModelEntity, Long> {

}
