package src;


// Classe Recurso
class Recurso {
    private String titulo;
    private String tipo;
    private String conteudo;

    public Recurso(String titulo, String tipo, String conteudo) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.conteudo = conteudo;
    }

    public void visualizar() {
        System.out.println("Título: " + titulo);
        System.out.println("Tipo: " + tipo);
        System.out.println("Conteúdo: " + conteudo);
    }
}
