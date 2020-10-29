package com.app.common;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

public abstract class Ac2Repository<TEntity extends BaseEntity, TPayload extends ToEntity<TEntity>> {
    private ArrayList<TEntity> entities;

    @PostConstruct
    public void initialize() {
        entities = new ArrayList<TEntity>();
    }

    public TEntity save(TPayload payload) {
        TEntity entity = payload.toEntity();
        entities.add(entity);
        return entity;
    }

    public TEntity findOne(int id) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getId() == id)
                return entities.get(i);
        }
        return null;
    }

    public ArrayList<TEntity> getAll() {
        return entities;
    }

    public void delete(int id) {
        entities.remove(findOne(id));
    }

    public void update(int id, TPayload payload) {
        delete(id);
        TEntity entity = payload.toEntity();
        entities.add(entity);
    }
}
