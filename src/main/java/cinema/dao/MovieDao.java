package cinema.dao;

import cinema.model.Movie;
import java.util.List;
import java.util.Optional;

public interface MovieDao extends GenericDao<Movie> {
    Optional<Movie> get(Long id);

    List<Movie> getAll();
}
