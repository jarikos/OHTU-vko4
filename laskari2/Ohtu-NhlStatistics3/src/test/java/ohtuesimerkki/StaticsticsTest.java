package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StaticsticsTest {

    Statistics stats;
    PlayerReader playerReader = mock(PlayerReader.class);
//    //Player palayer = mock(Player.class);
//    PlayerReader playerReader = new PlayerReader() {
//
//        public List<Player> getPlayers() {
//            ArrayList<Player> players = new ArrayList<Player>();
//
//            players.add(new Player("Semenko", "EDM", 4, 12));
//            players.add(new Player("Lemieux", "PIT", 45, 54));
//            players.add(new Player("Kurri", "EDM", 37, 53));
//            players.add(new Player("Yzerman", "DET", 42, 56));
//            players.add(new Player("Gretzky", "EDM", 35, 89));
//
//            return players;
//        }
//    };

    @Before
    public void setUp() {
        stats = new Statistics(playerReader);
    }

    @Test
    public void playerFound() {
        Player p = stats.search("Lemieux");
        assertEquals("PIT", p.getTeam());
        assertEquals(45, p.getGoals());
        assertEquals(54, p.getAssists());
        assertEquals(45 + 54, p.getPoints());
//        verify(playerReader).getPlayers();

    }
    
    @Test
    public void teamMembersFound(){
        List<Player> players = stats.team("EDM");
        assertEquals(3, players.size());
        for (Player player : players) {
            assertEquals("EDM", player.getTeam());
        }
    }
    
    @Test
    public void topScorersFound(){
        List<Player> players = stats.topScorers(2);
        assertEquals(3, players.size());
        assertEquals("Gretzky", players.get(0).getName());
        assertEquals("Lemieux", players.get(1).getName());
    }
    
    @Test
    public void listPlayers(){
        List<Player> players = stats.topScorers(4);
        for(Player player : players)
            System.out.println(player.getName());
//        List<Player> players = stats.topScorers(2);
//        assertEquals(3, players.size());
//        assertEquals("Gretzky", players.get(0).getName());
//        assertEquals("Lemieux", players.get(1).getName());
//        verify(players).size();
    }
}
