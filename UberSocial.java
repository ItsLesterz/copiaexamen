import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UberSocial {
    private ArrayList<SocialClass> accounts;

    public UberSocial() {
        accounts = new ArrayList<>();
    }

    public SocialClass buscar(String username) {
        for (SocialClass account : accounts) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }

    public void agregarCuenta(String username, String tipo) {
        if (buscar(username) != null) {
            JOptionPane.showMessageDialog(null, "El username ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        SocialClass account = null;
        if (tipo.equals("FACEBOOK")) {
            account = new Facebook(username);
        } else if (tipo.equals("TWITTER")) {
            account = new Twitter(username);
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de cuenta no válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        accounts.add(account);
    }

    public void agregarPost(String user, String post) {
        SocialClass account = buscar(user);
        if (account == null) {
            JOptionPane.showMessageDialog(null, "El usuario no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        account.addPost(post);
    }

    public void agregarAmigo(String user1, String user2) {
        SocialClass account1 = buscar(user1);
        SocialClass account2 = buscar(user2);
        if (account1 == null || account2 == null) {
            JOptionPane.showMessageDialog(null, "Uno o ambos usuarios no existen.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (account1 instanceof Facebook && account2 instanceof Facebook) {
            account1.addFriend(user2);
            account2.addFriend(user1);
        } else if (account1 instanceof Twitter && account2 instanceof Twitter) {
            account1.addFriend(user2);
            account2.addFriend(user1);
        } else {
            JOptionPane.showMessageDialog(null, "Ambos usuarios deben ser del mismo tipo de cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregarComment(String user, int postID, String autor, String comment) {
        SocialClass account = buscar(user);
        if (account == null) {
            JOptionPane.showMessageDialog(null, "La red social con ese usuario no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (account instanceof Facebook) {
            Facebook fbAccount = (Facebook) account;
            Comment newComment = new Comment(postID, autor, comment);
            if (!fbAccount.addComment(newComment)) {
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Comentarios solo están disponibles para Facebook.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void profileFrom(String user) {
        SocialClass account = buscar(user);
        if (account == null) {
            JOptionPane.showMessageDialog(null, "El usuario no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        account.myProfile();
    }
}
