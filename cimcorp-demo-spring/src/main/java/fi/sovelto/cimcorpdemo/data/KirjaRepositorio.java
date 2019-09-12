package fi.sovelto.cimcorpdemo.data;

import fi.sovelto.cimcorpdemo.model.Kirja;
import org.springframework.data.repository.CrudRepository;

public interface KirjaRepositorio extends CrudRepository<Kirja, Long> {
}
