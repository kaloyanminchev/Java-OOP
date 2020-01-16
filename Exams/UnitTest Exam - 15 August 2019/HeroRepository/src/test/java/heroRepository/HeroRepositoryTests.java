package heroRepository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroRepositoryTests {
    private HeroRepository heroRepository;
    private Hero hero;

    @Before
    public void shouldCreateHeroRepositoryWithNoArguments() {
        this.heroRepository = new HeroRepository();
        this.hero = new Hero("Pesho", 10);
    }

    @Test
    public void getCountShouldReturnSizeOfCollection() {
        int count = this.heroRepository.getCount();

        assertEquals(0, count);
    }

    @Test(expected = NullPointerException.class)
    public void createShouldThrowExceptionIfHeroArgumentIsNull() {
        this.heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShouldThrowExceptionIfHeroAlreadyExists() {
        this.heroRepository.create(this.hero);
        this.heroRepository.create(this.hero);
    }

    @Test
    public void createShouldReturnMessageIfHeroIsAddedCorrectly() {
        String message = String.format("Successfully added hero %s with level %d", this.hero.getName(), this.hero.getLevel());

        assertEquals(message, this.heroRepository.create(this.hero));
    }

    @Test
    public void removeShouldReturnTrueHeroExists() {
        this.heroRepository.create(this.hero);
        boolean isRemoved = this.heroRepository.remove(this.hero.getName());

        assertTrue(isRemoved);
    }

    @Test(expected = NullPointerException.class)
    public void removeShouldThrowExceptionIfHeroNameIsNull() {
        this.hero = new Hero(null, 10);
        this.heroRepository.remove(this.hero.getName());
    }

    @Test(expected = NullPointerException.class)
    public void removeShouldThrowExceptionIfHeroNameIsEmpty() {
        this.hero = new Hero("", 10);
        this.heroRepository.remove(this.hero.getName());
    }

    @Test
    public void shouldReturnHeroWithHighestLevel() {
        Hero testHero = new Hero("Gosho", 5);
        this.heroRepository.create(this.hero);
        this.heroRepository.create(testHero);

        assertEquals(this.hero, this.heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void shouldReturnHeroByGivenName() {
        this.heroRepository.create(this.hero);
        Hero testHero = this.heroRepository.getHero("Pesho");

        assertEquals(this.hero, testHero);
    }
}
