package pl.kazmierczak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kazmierczak.domain.Reader;
import pl.kazmierczak.repositories.ReaderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public List<Reader> listAll() {
        List<Reader> readers = new ArrayList<>();
        readerRepository.findAll().forEach(readers::add);
        return readers;
    }

    @Override
    public void delete(Integer id) {
        readerRepository.delete(id);
    }

    @Override
    public Reader saveOrUpdate(Reader reader) {
        readerRepository.save(reader);
        return reader;
    }
}
