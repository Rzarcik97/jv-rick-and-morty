package mate.academy.rickandmorty.service.impl;

import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.model.RickAndMortyCharacter;
import mate.academy.rickandmorty.repository.RickAndMortyCharacterRepository;
import mate.academy.rickandmorty.service.RickAndMortyService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RickAndMortyServiceImpl implements RickAndMortyService {

    private final RickAndMortyCharacterRepository rickAndMortyCharacterRepository;

    @Override
    public RickAndMortyCharacter getRandomCharacter() {
        Long randomId = new Random().nextLong(rickAndMortyCharacterRepository.count());
        return rickAndMortyCharacterRepository.getReferenceById(randomId);
    }

    @Override
    public List<RickAndMortyCharacter> getCharacterByName(String name, Pageable pageable) {
        return rickAndMortyCharacterRepository
                .findRickAndMortyCharactersByNameContains(name, pageable)
                .get().toList();
    }
}
