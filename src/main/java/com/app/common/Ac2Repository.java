package com.app.common;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

public abstract class Ac2Repository<TEntity extends BaseEntity, TPayload extends ToEntity<TEntity>> {

    private List<TEntity> entities;

    @PostConstruct
    public void initialize() {
        entities = new ArrayList<TEntity>();
    }

    public TEntity save(TPayload payload) {
        TEntity entity = payload.toEntity();
        entity.setId(UUID.randomUUID().toString());
        entities.add(entity);
        return entity;
    }

    public TEntity findOne(String id) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getId().equals(id))
                return entities.get(i);
        }
        return null;
    }

    public List<TEntity> getAll() {
        return entities;
    }

    public void delete(String id) {
        entities.removeIf(entity -> entity.id.equals(id));
    }

    public void update(String id, TPayload payload) {
        delete(id);
        TEntity entity = payload.toEntity();
        entity.setId(id);
        entities.add(entity);
    }

    public boolean contains(String id) {
        return entities.stream().anyMatch(entity -> entity.id.equals(id));
    }

}
