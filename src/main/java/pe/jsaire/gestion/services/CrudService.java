package pe.jsaire.gestion.services;

public interface CrudService <T, ID>{

    T findById(ID id);

    T save(T entity);

    void delete(ID id);
}
