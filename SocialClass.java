import javax.swing.*;
import java.util.ArrayList;

public abstract class SocialClass {
    private ArrayList<String> friends;
    private ArrayList<String> posts;
    private String username;

    public SocialClass(String username) {
        this.username = username;
        this.friends = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
    }

    public ArrayList<String> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<String> posts) {
        this.posts = posts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean addFriend(String user) {
        if (!user.equals(username) && !friends.contains(user)) {
            friends.add(user);
            return true;
        }
        return false;
    }

    public void addPost(String msg) {
        posts.add(msg);
    }

    public abstract void timeline();

    public void myProfile() {
        StringBuilder profile = new StringBuilder();
        profile.append("Usuario: ").append(username).append("\n\nPosts:\n");
        for (String post : posts) {
            profile.append("- ").append(post).append("\n");
        }

        profile.append("\nAmigos:\n");
        if (friends.isEmpty()) {
            profile.append("No tienes amigos.");
        } else {
            for (int i = 0; i < friends.size(); i++) {
                profile.append(friends.get(i));
                if (i < friends.size() - 1) {
                    profile.append(", ");
                }
            }
        }

        JOptionPane.showMessageDialog(null, profile.toString(), "Perfil de " + username, JOptionPane.INFORMATION_MESSAGE);
    }
}
