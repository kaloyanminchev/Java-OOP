package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DummyTest {
    private static final int BASE_HEALTH = 10;
    private static final int BASE_EXPERIENCE = 10;
    private static final int ATTACK_POINTS = 5;
    private static final int EXPECTED_POINTS = 5;

    private Dummy dummy;

    private void setupAliveDummy() {
        this.dummy = new Dummy(BASE_HEALTH, BASE_EXPERIENCE);
    }

    private void setupDeadDummy() {
        this.dummy = new Dummy(-BASE_HEALTH, BASE_EXPERIENCE);
    }

    @Test
    public void shouldLooseHealthWhenAttacked() {
        setupAliveDummy();
        this.dummy.takeAttack(ATTACK_POINTS);
        assertEquals(EXPECTED_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionIfDead() {
        setupDeadDummy();
        dummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void deadDummyShouldGiveXP() {
        setupDeadDummy();
        assertEquals(BASE_EXPERIENCE, this.dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyShouldThrowException() {
        setupAliveDummy();
        this.dummy.giveExperience();
    }
}
