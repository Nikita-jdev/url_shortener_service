package faang.school.urlshortenerservice.repository;

import faang.school.urlshortenerservice.entity.Hash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HashRepository extends JpaRepository<Hash, String> {
    @Query(nativeQuery = true, value = """
            SELECT NEXTVAL('unique_number_seq') FROM generate_series(1,?)
            """)
    List<Long> getUniqueNumbers(int number);

    @Query(nativeQuery = true, value = """
            DELETE FROM hash where hash IN (SELECT hash from hash ORDER BY RANDOM() LIMIT ?)
            RETURNING *
            """)
    @Modifying
    List<String> getHashBatch(long batchSize);
}
