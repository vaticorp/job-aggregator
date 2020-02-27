package job.aggregator.common.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface AbstractRepository<T> extends JpaRepository<T, Long> {
    /**
     * <p>Alias for {@link CrudRepository#findById(Serializable)}.</p>
     *
     * <p>Returns an entity with the given identifier.</p>
     *
     * @param id must not be null
     * @return entity with the given identifier or null in case entity was not found
     */
    Optional<T> findById(Long id);

    /**
     * <p>Alias for {@link JpaRepository#getOne(Serializable)}.</p>
     *
     * <p>Returns an entity with the given identifier.</p>
     *
     * @param id must not be null
     * @return entity with the given identifier
     */
    T getById(Long id);
}
