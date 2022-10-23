package at.fhtw.swen3.model.repositories;

import at.fhtw.swen3.model.entities.GeoCoordinateModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeoCoordinateRepository extends JpaRepository<GeoCoordinateModelEntity, Long> {

}
