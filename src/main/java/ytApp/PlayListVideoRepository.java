package ytApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayListVideoRepository extends JpaRepository<PlayListVideo,Integer> {

}
