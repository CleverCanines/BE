package com.CleverCanines.be.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.CleverCanines.be.dto.output.ScreenInteraction;
import java.util.UUID;
import java.util.List;

@Repository
public interface ScreenInteractionRepository extends CrudRepository<ScreenInteraction, UUID> {
    List<ScreenInteraction> findByPersonId(UUID personId);
    List<ScreenInteraction> findByScreenId(UUID screenId);
    List<ScreenInteraction> findByPersonIdAndScreenId(UUID personId, UUID screenId);
    void deleteByPersonIdAndScreenId(UUID personId, UUID screenId);
}
