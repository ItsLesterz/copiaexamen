import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Facebook extends SocialClass implements Commentable {
    private ArrayList<Comment> comments;

    public Facebook(String username) {
        super(username);
        comments = new ArrayList<>();
    }

    @Override
    public boolean addComment(Comment comment) {
        int postId = comment.getPostId();

        if (postId < 0 || postId >= getPosts().size()) {
            JOptionPane.showMessageDialog(null, "Post ID no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        comments.add(comment);
        return true;
    }

    @Override
    public void timeline() {
        StringBuilder timeline = new StringBuilder("Timeline de " + getUsername() + ":\n");

        for (int i = 0; i < getPosts().size(); i++) {
            timeline.append("POST ID ").append(i).append(": ").append(getPosts().get(i)).append("\n");

            for (Comment comment : comments) {
                if (comment.getPostId() == i) {
                    timeline.append("  COMENTARIO: ").append(comment.getAutor()).append(" - ")
                            .append(String.format("%1$td/%1$tm/%1$tY", comment.getFecha())).append("\n")
                            .append("    ").append(comment.getContenido()).append("\n");
                }
            }
        }

        JOptionPane.showMessageDialog(null, timeline.toString(), "Timeline", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void myProfile() {
        StringBuilder profile = new StringBuilder("Perfil de " + getUsername() + ":\n");

        // Mostrar el timeline del usuario
        profile.append("\n--- Timeline ---\n");
        for (int i = 0; i < getPosts().size(); i++) {
            profile.append("POST ID ").append(i).append(": ").append(getPosts().get(i)).append("\n");

            // Recorre todos los comentarios y muestra los que pertenecen al post actual
            for (Comment comment : comments) {
                if (comment.getPostId() == i) {
                    profile.append("  COMENTARIO: ").append(comment.getAutor()).append(" - ")
                            .append(String.format("%1$td/%1$tm/%1$tY", comment.getFecha())).append("\n")
                            .append("    ").append(comment.getContenido()).append("\n");
                }
            }
        }

        // Mostrar los amigos
        profile.append("\n--- Amigos ---\n");
        for (int i = 0; i < getFriends().size(); i++) {
            profile.append(getFriends().get(i)).append(" ");
            if ((i + 1) % 10 == 0) { // Muestra 10 amigos por fila
                profile.append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, profile.toString(), "Perfil", JOptionPane.INFORMATION_MESSAGE);
    }
}
