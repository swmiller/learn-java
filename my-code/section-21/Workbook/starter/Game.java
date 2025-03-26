import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Game {

    private String arena;
    private LocalDate date;

    public Game(String arena) {
        this.setArena(arena);
        this.date = LocalDate.now();
    }

    public void begin(Team home, Team away) {
        String formattedDate = this.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(
                "\n - This matchup takes place at the " + this.arena + " arena on " + formattedDate + "." +
                        "\n - Tonight's game is between the " + home.getName() + " and the " + away.getName() + ".\n" +
                        "\n - The starting lineup for the home team is: at point guard, "
                        + getPlayerByPosition(away, "POINT_GUARD")
                        + "; at shooting guard, " + getPlayerByPosition(home, "SHOOTING_GUARD") + "; at small forward, "
                        + getPlayerByPosition(home, "SMALL_FORWARD") + "; at power forward, "
                        + getPlayerByPosition(home, "POWER_FORWARD")
                        + "; and at center, "
                        + getPlayerByPosition(home, "CENTER") + ".\n" +
                        "\n - The starting lineup for the visiting team is: at point guard, "
                        + getPlayerByPosition(away, "POINT_GUARD")
                        + "; at shooting guard, " + getPlayerByPosition(away, "SHOOTING_GUARD") + "; at small forward, "
                        + getPlayerByPosition(away, "SMALL_FORWARD") + "; at power forward, "
                        + getPlayerByPosition(away, "POWER_FORWARD") + "; and at center, "
                        + getPlayerByPosition(away, "CENTER") + ".\n" +
                        "\n - Let's give a warm round of applause for both teams as they take the court!");
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    private String getPlayerByPosition(Team team, String position) {
        return team.getPlayer(position);
    }
}
