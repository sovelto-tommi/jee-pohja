package fi.sovelto.cimcorpdemo.data;

import fi.sovelto.cimcorpdemo.model.Kirja;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface KirjaRepositorio extends PagingAndSortingRepository<Kirja, Long> {
}
