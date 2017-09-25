package pl.kazmierczak.services;

import pl.kazmierczak.domain.Reader;

import java.util.List;

public interface ReaderService {
    List<Reader> listAll();
    void delete(Integer id);
    Reader saveOrUpdate(Reader book);
    ;
}
