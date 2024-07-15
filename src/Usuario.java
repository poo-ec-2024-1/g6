package src;


// Classe Usuário
class Usuario {
    private String nome;
    private String email;
    private String senha; 
    private boolean logado = false;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public boolean login(String email, String senha) {
        // Verificação de login com senha armazenada
        if (this.email.equals(email) && this.senha.equals(senha)) {
            this.logado = true;
            System.out.println(nome + " logado com sucesso!");
            return true;
        }
        System.out.println("Falha no login!");
        return false;
    }

    public void logout() {
        this.logado = false;
        System.out.println(nome + " deslogado com sucesso!");
    }

    public boolean isLogado() {
        return logado;
    }
}
