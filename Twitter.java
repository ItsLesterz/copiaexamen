import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Twitter extends SocialClass {
    public Twitter(String username) {
        super(username);
    }

    @Override
    public void timeline() {
        StringBuilder timeline = new StringBuilder("Timeline de " + getUsername() + ":\n");
        for (int i = 0; i < getPosts().size(); i++) {
            timeline.append("POST ID ").append(i).append(": ").append(getPosts().get(i)).append("\n");
        }
        JOptionPane.showMessageDialog(null, timeline.toString(), "Timeline", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void myProfile() {
        StringBuilder profile = new StringBuilder("Perfil de " + getUsername() + ":\n");
        profile.append("\n--- Timeline ---\n");
        for (int i = 0; i < getPosts().size(); i++) {
            profile.append("POST ID ").append(i).append(": ").append(getPosts().get(i)).append("\n");
        }
        profile.append("\n--- Amigos ---\n");
        for (int i = 0; i < getFriends().size(); i++) {
            profile.append(getFriends().get(i)).append(" ");
            if ((i + 1) % 10 == 0) {
                profile.append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, profile.toString(), "Perfil", JOptionPane.INFORMATION_MESSAGE);
    }
}
