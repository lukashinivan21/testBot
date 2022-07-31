package tgbots.testbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tgbots.testbot.models.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Candidate findCandidateById(Long id);

}
