import java.util.Calendar;
import java.text.SimpleDateFormat;

public final class Comment {
    private int postId;
    private String autor;
    private String contenido;
    private Calendar fecha;

    public Comment(int postId, String autor, String contenido) {
        this.postId = postId;
        this.autor = autor;
        this.contenido = contenido;
        this.fecha = Calendar.getInstance(); // Inicializa con la fecha actual
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public void print() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        String formattedDate = dateFormat.format(fecha.getTime());
        System.out.println(autor + " – " + formattedDate);
        System.out.println(contenido);
    }
}
