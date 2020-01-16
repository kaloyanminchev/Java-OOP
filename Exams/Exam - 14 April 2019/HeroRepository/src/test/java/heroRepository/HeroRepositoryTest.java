package heroRepository;

import heroRepository.Hero;
import heroRepository.HeroRepository;
import heroRepository.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroRepositoryTest {

    private HeroRepository heroRepository;
    private Hero hero;

    @Before
    public void setUp() {
        this.heroRepository = new HeroRepository();
        this.hero = new Hero("Hercules", 42, new Item(0, 0, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMethodShouldThrowExceptionIfHeroIsDuplicated() {
        this.heroRepository.add(this.hero);
        this.heroRepository.add(this.hero);
    }

    @Test
    public void addMethodShouldAddHeroToRepository() {
        this.heroRepository.add(this.hero);

        assertEquals(1, this.heroRepository.getCount());
    }

    @Test
    public void getCountMethodShouldReturnTheRepositorySize() {
        assertEquals(0, this.heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void removeMethodShouldThrowExceptionIfHeroIsNull() {
        this.heroRepository.remove(this.hero.getName());
    }

    @Test
    public void removeMethodShouldRemoveHeroByGivenName() {
        Hero testHero = new Hero("Spartak", 8, new Item(6, 9, 11));
        this.heroRepository.add(testHero);
        this.heroRepository.add(this.hero);
        this.heroRepository.remove(this.hero.getName());

        assertEquals(1, this.heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAgilityMethodShouldThrowExceptionIfBestHeroNotFound() {
        this.heroRepository.add(this.hero);
        Hero testHero = new Hero("Spartak", 8, new Item(6, 0, 11));
        this.heroRepository.add(testHero);

        this.heroRepository.getHeroWithHighestAgility();
    }

    @Test
    public void getHeroWithHighestAgilityMethodShouldReturnBestHero() {
        Hero testHero = new Hero("Spartak", 8, new Item(6, 9, 11));
        this.heroRepository.add(testHero);
        this.heroRepository.add(this.hero);

        assertEquals(testHero, this.heroRepository.getHeroWithHighestAgility());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceMethodShouldThrowExceptionIfBestHeroNotFound() {
        this.heroRepository.add(this.hero);
        Hero testHero = new Hero("Spartak", 8, new Item(6, 9, 0));
        this.heroRepository.add(testHero);

        this.heroRepository.getHeroWithHighestIntelligence();
    }

    @Test
    public void getHeroWithHighestIntelligenceMethodShouldReturnBestHero() {
        Hero testHero = new Hero("Spartak", 8, new Item(6, 9, 11));
        this.heroRepository.add(testHero);
        this.heroRepository.add(this.hero);

        assertEquals(testHero, this.heroRepository.getHeroWithHighestIntelligence());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestStrengthMethodShouldThrowExceptionIfBestHeroNotFound() {
        this.heroRepository.add(this.hero);
        Hero testHero = new Hero("Spartak", 8, new Item(0, 9, 11));
        this.heroRepository.add(testHero);

        this.heroRepository.getHeroWithHighestStrength();
    }

    @Test
    public void getHeroWithHighestStrengthMethodShouldReturnBestHero() {
        Hero testHero = new Hero("Spartak", 8, new Item(6, 9, 11));
        this.heroRepository.add(testHero);
        this.heroRepository.add(this.hero);

        assertEquals(testHero, this.heroRepository.getHeroWithHighestStrength());
    }

    @Test
    public void toStringMethodShouldReturnToStringForEachHeroInRepository() {
        this.heroRepository.add(this.hero);
        String output = this.heroRepository.toString();

        String expected = String.format("Hero: %s – %d%n" +
                        "  *  Strength: %d%n" +
                        "  *  Agility: %d%n" +
                        "  *  Intelligence: %d%n",
                this.hero.getName(),
                this.hero.getLevel(),
                this.hero.getItem().getStrength(),
                this.hero.getItem().getAgility(),
                this.hero.getItem().getIntelligence());

        assertEquals(expected, output);
    }
}