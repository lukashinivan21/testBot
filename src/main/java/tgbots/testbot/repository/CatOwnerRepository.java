package tgbots.testbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tgbots.testbot.models.CatOwner;

@Repository
public interface CatOwnerRepository extends JpaRepository<CatOwner, Long> {

    CatOwner findCatOwnerById(Long id);
}
