<img src="img/pngwing.com.png" width="30%"/>

# 📚Projeto ofertado na diciplina de POO.

## 👨🏽‍💻Dev: Vagner Ferreira 
## 👨🏽‍🏫Professor: Gregory

# 🌐Sistema Proposto 

## Meu sistema será utilizado para gerenciar cursos online. Ele permitirá que professores registrem cursos, alunos se inscrevam nos cursos e acompanhe seu progresso. Além disso, será possível adicionar avaliações para os cursos e feedback dos alunos para melhoria contínua.

# ☁️Modelo de Banco de Dados

<img src="img/cursopng.png" width="40%"/>

## 🛑Requisitos para o banco de dados:
* Deve possuir no mínimo 4 tabelas.
* Deve ter ao menos uma tabela com chave estrangeira e relação 1 para muitos.
* Deve ter ao menos uma tabela de relação muitos para muitos.

## 🛠️Tecnologias Utilizadas

O sistema será desenvolvido utilizando as seguintes tecnologias:

1. **Java 17**: A versão mais recente do Java, com melhorias significativas de desempenho e suporte a novas funcionalidades que facilitam o desenvolvimento de aplicações modernas.

2. **MySQL**: O banco de dados relacional será gerenciado através do MySQL, que permitirá armazenar informações dos cursos, alunos, professores, avaliações e feedback. O desenvolvimento será feito utilizando o **MySQL Workbench**, uma ferramenta que oferece uma interface gráfica para gerenciar e visualizar o banco de dados.

3. **JFrame**: A interface gráfica do usuário será construída com **JFrame**, permitindo a criação de janelas, botões e campos de entrada de dados para interação com os usuários.

4. **Apache NetBeans**: O **Apache NetBeans** será utilizado como IDE para desenvolvimento do sistema, oferecendo suporte completo ao Java, integração com o MySQL e ferramentas para a criação de interfaces gráficas com o JFrame.

Essas tecnologias permitem a criação de um sistema robusto, fácil de gerenciar e com uma interface amigável para o usuário.

## 🚀 Como Clonar e Rodar o Projeto

Este tutorial irá guiar você sobre como clonar o projeto e configurá-lo em seu ambiente de desenvolvimento.

### 1. **Clonar o Repositório**

Primeiramente, você precisará clonar o repositório do projeto para sua máquina local. Para isso, siga os seguintes passos:

1. Abra o terminal (ou Git Bash) na pasta onde deseja armazenar o projeto.
2. Execute o comando abaixo para clonar o repositório:

   ```bash
   git clone https://github.com/vagnerflj/Proposta-CRUD-IFPR.git


# 📊Diagrama de Classes 

# ⚒️Estrutura de Pacotes

```bash
    src/
│
├── conexao/
│   └── Conexao.java         
│
├── model/
│   ├── bean/
│   │   ├── Curso.java       
│   │   ├── Aluno.java       
│   │   ├── Professor.java   
│   │   └── Feedback.java    
│   ├── dao/
│       ├── CursoDAO.java    
│       ├── AlunoDAO.java    
│       ├── ProfessorDAO.java
│       └── FeedbackDAO.java 
│
├── views/
│   ├── CursoView.java       
│   ├── AlunoView.java       
│   ├── ProfessorView.java   
│   └── FeedbackView.java    
│
└── Main.java                
        
```


## 🛑REQUISITOS OBRIGATÓRIOS PARA O DIAGRAMA:
* Deve possuir ao menos duas classes com relacionamento de associação/agregação/composição;
* deve possuir no mínimo uma classe com associação de multiplicidade muitos para muitos (com array/arraylist);
* Requisito facultativo para o diagrama:
* Representar uma herança ou possibilidade de implementação de polimorfismo (herança com classe concreta/abstrata ou interface).

---


## 📬Endpoints do Sistema

| **Endpoint**               | **Operação CRUD**  | **Descrição**                                                   |
|----------------------------|--------------------|-----------------------------------------------------------------|
| `/login`                   | Login              | Realiza o login de um usuário (aluno/professor)                 |
| `/register`                | Criar              | Registra um novo usuário                                        |
| `/cursos`                  | Ler                | Retorna a lista de todos os cursos                              |
| `/curso/{id}`              | Ler                | Detalhes de um curso específico                                  |
| `/curso`                   | Criar              | Cria um novo curso                                              |
| `/curso/{id}`              | Atualizar          | Atualiza um curso existente                                     |
| `/curso/{id}`              | Deletar            | Deleta um curso                                                 |
| `/professores`             | Ler                | Retorna lista de professores                                    |
| `/professor/{id}`          | Ler                | Detalhes de um professor específico                              |
| `/professor`               | Criar              | Registra um novo professor                                      |
| `/professor/{id}`          | Atualizar          | Atualiza um professor                                           |
| `/professor/{id}`          | Deletar            | Deleta um professor                                             |
| `/alunos`                  | Ler                | Retorna lista de alunos                                         |
| `/aluno/{id}`              | Ler                | Detalhes de um aluno                                            |
| `/aluno`                   | Criar              | Registra um novo aluno                                          |
| `/aluno/{id}`              | Atualizar          | Atualiza informações de um aluno                                |
| `/aluno/{id}`              | Deletar            | Deleta um aluno                                                 |
| `/inscricao`               | Criar              | Inscreve um aluno em um curso                                  |
| `/inscricoes/{aluno_id}`   | Ler                | Retorna os cursos em que o aluno está inscrito                  |
| `/inscricao`               | Deletar            | Cancela inscrição de aluno em um curso                          |
| `/feedback`                | Criar              | Deixa um feedback para um curso                                 |
| `/feedback/{curso_id}`     | Ler                | Retorna os feedbacks de um curso específico                      |
| `/feedback/{id}`           | Deletar            | Deleta um feedback específico                                   |

