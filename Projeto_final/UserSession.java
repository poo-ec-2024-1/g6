
/**
 * Classe para gerenciar a sessão do usuário.
 */
public class UserSession {
    //variável com a instância única do UserSession
    private static UserSession instance;
    private String email;

    /**
     * Construtor privado.
     * Evita instanciamento externo.
     */
    private UserSession() {}

    /**
     * Recebe a única instância do UserSession.
     * @return a instância do UserSession.
     */
    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    /**
     * Recebe o email do usuário.
     * @return o email do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do usuário na sessão.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
