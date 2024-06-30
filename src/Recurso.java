package src;
public class Recurso {
    private String titulo;
    private String tipo;
    private String conteudo;

    public Recurso(String titulo, String tipo, String conteudo) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getConteudo() {
        return conteudo;
    }
}

