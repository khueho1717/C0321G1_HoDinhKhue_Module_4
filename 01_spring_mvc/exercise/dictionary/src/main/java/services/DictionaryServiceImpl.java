package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DictionaryRepository;
import repository.DictionaryRepositoryIml;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    DictionaryRepository dictionaryRepository;

    @Override
    public String findWord(String english) {
        return dictionaryRepository.findWord(english);
    }
}
