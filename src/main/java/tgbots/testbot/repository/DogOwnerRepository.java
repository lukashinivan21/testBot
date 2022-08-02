package tgbots.testbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tgbots.testbot.models.DogOwner;

@Repository
public interface DogOwnerRepository extends JpaRepository<DogOwner, Long> {

    DogOwner findDogOwnerById(Long id);
}
