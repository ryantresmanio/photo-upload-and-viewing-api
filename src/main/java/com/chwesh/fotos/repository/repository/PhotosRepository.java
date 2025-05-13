package com.chwesh.fotos.repository.repository;

import com.chwesh.fotos.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotosRepository extends CrudRepository<Photo, Integer> {
}
