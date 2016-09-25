package ie.murph.sports.clinic.repository;

import org.springframework.data.repository.CrudRepository;

import ie.murph.sports.clinic.domain.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
}
