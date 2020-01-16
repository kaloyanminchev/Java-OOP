package footballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        ValidatorInput.validateName(name);
        this.name = name;
    }

    public void setEndurance(int endurance) {
        ValidatorInput.validateStats(endurance, "Endurance");
        this.endurance = endurance;
    }

    public void setSprint(int sprint) {
        ValidatorInput.validateStats(sprint, "Sprint");
        this.sprint = sprint;
    }

    public void setDribble(int dribble) {
        ValidatorInput.validateStats(dribble, "Dribble");
        this.dribble = dribble;
    }

    public void setPassing(int passing) {
        ValidatorInput.validateStats(passing, "Passing");
        this.passing = passing;
    }

    public void setShooting(int shooting) {
        ValidatorInput.validateStats(shooting, "Shooting");
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.0;
    }
}
