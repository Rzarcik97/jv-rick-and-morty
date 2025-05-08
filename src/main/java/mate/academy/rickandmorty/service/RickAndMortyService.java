package mate.academy.rickandmorty.service;

import java.util.List;
import mate.academy.rickandmorty.model.RickAndMortyCharacter;
import org.springframework.data.domain.Pageable;

public interface RickAndMortyService {

    RickAndMortyCharacter getRandomCharacter();

    List<RickAndMortyCharacter> getCharacterByName(String name, Pageable pageable);
}
