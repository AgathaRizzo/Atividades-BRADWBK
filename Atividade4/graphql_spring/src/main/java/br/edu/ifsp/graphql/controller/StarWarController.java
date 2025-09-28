package br.edu.ifsp.graphql.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.edu.ifsp.graphql.model.Character;
import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Episode;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.model.Review;
import br.edu.ifsp.graphql.model.ReviewInput;
import br.edu.ifsp.graphql.model.Starship;
import br.edu.ifsp.graphql.service.HumanService;
import br.edu.ifsp.graphql.service.DroidService;
import br.edu.ifsp.graphql.service.StarshipService;
import br.edu.ifsp.graphql.service.ReviewService;
import br.edu.ifsp.graphql.service.SearchService;

@Controller
public class StarWarController {
    
    
    private final HumanService humanService;
    private final DroidService droidService;
    private final StarshipService starshipService;
    private final ReviewService reviewService;
    private final SearchService searchService;
    
    
    public StarWarController(HumanService humanService, DroidService droidService,
                            StarshipService starshipService, ReviewService reviewService,
                            SearchService searchService) {
        this.humanService = humanService;
        this.droidService = droidService;
        this.starshipService = starshipService;
        this.reviewService = reviewService;
        this.searchService = searchService;
    }
    
    @QueryMapping
    public Character hero(@Argument Episode episode) {
        return droidService.getHero(episode);
    }

    @QueryMapping
    public Droid droid(@Argument String id) {
        return droidService.getDroidById(id);
    }
    
    @QueryMapping
    public List<Object> search(@Argument String text) {
        return searchService.search(text);
    }

    @QueryMapping
    public List<Human> humans() {
        return humanService.getAllHumans();
    }

    @QueryMapping
    public List<Starship> starships() {
        return starshipService.getAllStarships();
    }

    @QueryMapping
    public Character character(@Argument String id) {
        return searchService.getCharacterById(id);
    }

    @MutationMapping
    public Human createHuman(@Argument String id, @Argument String name, @Argument Float height) {
        return humanService.createHuman(id, name, height);
    }

    @MutationMapping
    public Droid createDroid(@Argument String id, @Argument String name, @Argument String primaryFunction) {
        return droidService.createDroid(id, name, primaryFunction);
    }

    @MutationMapping
    public Starship createStarship(@Argument int id, @Argument String name, @Argument Float length) {
        return starshipService.createStarship(id, name, length);
    }
    @MutationMapping
    public Character addFriend(@Argument String characterId, @Argument String friendId) {
        
        Character mainCharacter = searchService.getCharacterById(characterId);
        
        if (mainCharacter instanceof Human) {
            return humanService.addFriend(characterId, friendId);
        }
        
        if (mainCharacter instanceof Droid) {
            return droidService.addFriend(characterId, friendId);
        }
        
        return null;
    }

    @MutationMapping
    public Review createReview(@Argument Episode episode, @Argument ReviewInput review) {
        return reviewService.createReview(episode, review);
    }
}