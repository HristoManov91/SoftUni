package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.*;

public class GunRepository implements Repository<Gun> {

    private Map<String , Gun> models;

    public GunRepository(){
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return this.models.values();
        //return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Gun model) {
        models.putIfAbsent(model.getName() , model);
    }

    @Override
    public boolean remove(Gun model) {
        return this.models.remove(model.getName() , model);
    }

    @Override
    public Gun find(String name) {
        return models.get(name);
    }
}
