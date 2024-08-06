Relatório Lucas Gabriel da Silva Andrade

Introdução
Este relatório detalha o funcionamento de um sistema de login e cadastro desenvolvido com JavaFX e SQLite. O sistema é composto por três principais componentes: a tela de login, a tela de cadastro e a tela de perfil do usuário. Cada componente é gerido por um controlador específico que interage com a interface gráfica e o banco de dados.

Estrutura do Código
Criei as seguintes classes principais:
1. LoginViewController: Gerencia a tela de login.
2. CadastroViewController: Gerencia a tela de cadastro.
3. PerfilViewController: Gerencia a tela de perfil do usuário.
4. UserSession: Implementa o padrão Singleton para gerenciar a sessão do usuário.
5. Classe Msin para inicializar a tela de login.fxml.

 Funcionamento do Sistema

1. Tela de Login
A tela de login permite que o usuário insira seu email e senha para acessar o sistema. O controlador `LoginViewController` gerencia esta tela. Aqui está um resumo de suas funcionalidades:

- Campos de Entrada**: `TextField` para o email e `PasswordField` para a senha.
- Botões: `Button` para login e cadastro.
- Método de Login: `handleLogin()` verifica as credenciais do usuário no banco de dados. Se as credenciais forem válidas, a sessão do usuário é iniciada e a tela de perfil é aberta. Caso contrário, uma mensagem de erro é exibida.
- Método de Cadastro: `handleCadastro()` abre a tela de cadastro.
* A primeira versão contava com um metodo para se o email e senha forem autenticados, salvar o email e tranferi-lo para a tela de perfil, mas nao foi possive.

2. Tela de Cadastro
A tela de cadastro permite que novos usuários se registrem no sistema. O controlador `CadastroViewController` gerencia esta tela. Aqui estão suas funcionalidades:

- Campos de Entrada: `TextField` para nome e email, `PasswordField` para senha e confirmação de senha.
- Botões: `Button` para cadastro e voltar.
- Método de Cadastro: `handleCadastrar()` verifica se as senhas coincidem e insere os dados do usuário no banco de dados. Exibe mensagens de sucesso ou erro conforme o resultado.
- Método de Voltar: `handleVoltarButtonAction()` retorna à tela de login.

3. Tela de Perfil
A tela de perfil exibe as informações do usuário logado. O controlador `PerfilViewController` gerencia esta tela. Dde longe a tela mais complicada de fazer e achei que ficou muito simples, gostaria de adicionar mais coisas como a ediçao de curso e descrição, imagens de perfil aleatorias e curtidas. Aqui estão suas funcionalidades:

- Labels: Exibem o nome, email, curso e descrição do usuário.
- Botões: `Button` para navegar para outras telas (quiz, grupos de estudo, projetos) e voltar.
- Método de Inicialização: `initialize()` carrega os dados do usuário ao abrir a tela.
- Métodos de Navegação: `handleSelecaoButtonAction()`, `handleGruposButtonAction()`, `handleProjetoButtonAction()` e `handleVoltarButtonAction()` gerenciam a navegação entre as telas.

4. Gerenciamento de Sessão
A classe `UserSession` implementa o padrão Singleton para garantir que apenas uma instância da sessão do usuário exista durante a execução do aplicativo. Ela armazena o email do usuário logado e fornece métodos para definir e obter o email.

 Melhorias Sugeridas

1. Validação de Campos: Adicionar validações mais robustas para os campos de entrada, como verificação de formato de email e força da senha.
2. Mensagens de Erro: Melhorar a exibição de mensagens de erro na interface gráfica para uma melhor experiência do usuário.
3. Segurança: Implementar hashing de senhas antes de armazená-las no banco de dados para aumentar a segurança.
4. Fechamento de Conexões: Garantir que todas as conexões com o banco de dados sejam fechadas corretamente, mesmo em caso de exceção, utilizando blocos `finally`.
5. Interface Gráfica: Melhorar a interface gráfica com estilos CSS visto em projetos de colegas, para torná-la mais atraente e intuitiva.
6. Testes: Adicionar testes unitários e de integração para garantir a funcionalidade correta do sistema.
7. Organização e boas maneiras de programação, acredito que poderia ter organizado melhor as classes e nao repetir o mesmo metodo diversas vezes, poderia ter declarado ele por fora e ter chamado quando necessario.

Participações

- Participei em todas as classes do codigo e concertei diversos bugs.
- Criação do Banco de Dados principal e reposanvel pelas classes para gerenciar ele.

Conclusão
Este sistema de login e cadastro com JavaFX e SQLite é uma base sólida para aplicações que necessitam de autenticação de usuários. Com as melhorias sugeridas, ele pode se tornar ainda mais robusto, seguro e amigável para os usuários. Esse foi um projeto muito importante para o meu aprendizado, varios termos confusos em sala de aula foram esclarecidos enquanto eu estudava o codigo, sendo o banco de dados e o javafx os principais. Acredito que seja um otimo esqueleto para um projeto de rede social e que tem muti espaço para evoluir, graças a materia de POO, consigo pensar em diversas maneiras de fazer isso.
