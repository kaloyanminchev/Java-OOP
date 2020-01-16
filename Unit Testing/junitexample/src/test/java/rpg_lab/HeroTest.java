package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

public class HeroTest {

    private static final int TARGET_XP = 10;
    private static final String HERO_NAME = "Stamat";

    @Test
    public void attackGainsExperienceIfTargetIsDead() {

        Target mockTarget = Mockito.mock(Target.class);
        Mockito.when(mockTarget.giveExperience()).thenReturn(TARGET_XP);
        Mockito.when(mockTarget.isDead()).thenReturn(true);

        Weapon mockWeapon = Mockito.mock(Weapon.class);
        Mockito.when(mockWeapon.getAttackPoints()).thenReturn(10);

        Hero hero = new Hero(HERO_NAME, mockWeapon);
        hero.attack(mockTarget);
        Assert.assertEquals("Wrong experience", TARGET_XP, hero.getExperience());
    }
}
