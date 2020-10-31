package com.app.common;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

public abstract class BaseRepository<
    TEntity extends BaseEntity,
    TCreatePayload extends ToEntity<TEntity>,
    TUpdatePayload extends ModifyEntity<TEntity>
> {

    private List<TEntity> entities;

    public BaseRepository() { }

    @PostConstruct
    public void initialize() {
        entities = new ArrayList<TEntity>();
    }

    public TEntity save(TCreatePayload createPayload) {
        TEntity entity = createPayload.toEntity();
        entity.setId(UUID.randomUUID().toString());
        entities.add(entity);
        return entity;
    }

    public void save(TEntity entity) {
        entity.setId(UUID.randomUUID().toString());
        entities.add(entity);
    }

    public TEntity findOne(String id) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getId().equals(id))
                return entities.get(i);
        }
        return null;
    }

    public List<TEntity> find(Predicate<TEntity> predicate) {
        return entities
            .stream()
            .filter(predicate)
            .collect(Collectors.toList());
    }

    public List<TEntity> find() {
        return entities;
    }

    public void delete(String id) {
        entities
            .removeIf(entity -> entity.id.equals(id));
    }

    public void update(String id, TUpdatePayload updatePayload) {
        updatePayload.modifyEntity(findOne(id));
    }

    public boolean contains(String id) {
        return entities
            .stream()
            .anyMatch(entity -> entity.id.equals(id));
    }

}
