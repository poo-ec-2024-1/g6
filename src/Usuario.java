package src;
public class Usuario {
    private String nome;
    private String email;
    private String país;

    public Usuario(String nome, String email,String país) {
        this.nome = nome;
        this.email = email;
        this.país = país;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getPaís() {
        return país;
    }
}
