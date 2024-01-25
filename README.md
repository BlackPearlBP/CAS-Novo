# CAS-Novo
![Mês do Lançamento](https://img.shields.io/badge/release%20date-january-blue) ![Versão](https://img.shields.io/badge/version-0.0.1%2017.01.2024-green)

Uma calculadora salarial com base legal, cujo seu objetivo é calcular e informar os descontos realizados na sua folha de pagamento.

# :hammer: Funcionalidades do projeto

- Tela Inicial -> Imprime opções disponíveis na tela: login de usuário, cadastro de usuário, login como admin e sair do programa;
  
- Tela de Login -> Após inserção dos dados de login, abre uma tela para selecionar entre as opções de calcular salário ou voltar. Inicia-se um prompt para inserção do salário bruto do usuário.
  
- Tela de seleção de descontos -> Tela onde será selecionado os descontos da folha.
            Por hora as seleções serão realizadas por números, os números selecionados irão contribuir para um maior desconto da folha de pagamento;
            Nesta tela também foi planejado um menu (futuramente uma lista suspensa), no qual o usuário seleciona o mês e o ano que está realizando a consuta, 
            para que seu histórico seja montado; (Não presente nessa versão)
  
            Versão 0.1: Seleção do Vale-Transporte e cálculo automático dos descontos esseciais conforme CLT (FGTS, IRRF e INSS)
- Tela de Resultados -> Será impresso na tela um menu no qual o salário bruto possa ser consultado, em conjunto do salário líquido e seus respectivos descontos. Ainda na tela de resultados, quando a opção descontos forem selecionadas, será possível selecionar algum desconto e receber uma informação prévia sobre ele (Não presente nessa versão). Ainda nessa tela serão impressas as opções de calcular o salário novamente ou voltar à tela inicial.

- Tela de Cadastro: Nessa tela será possível cadastrar um novo usuário. São solicitadas as informações de nome do usuário e senha, não havendo especificação de padrão, seja ele alfanumérico ou alfabético.
 
- Tela de Login Administrativo:  Nessa tela estarão presentes as opções onde sejam realizadas modificações nos valores padrões dos descontos.

- Alterar Descontos: Os descontos estão dispostos tendo como base de cálculo a sua porcentagem. Ex: O desconto real do FGTS é 8%, para modificar esse valor, na opção "Alterar descontos" é necessário realizar a pesquisa do desconto pela sua sigla e inserir o novo valor no padrão de porcentagem "0,00"; (8% sendo 0,08, nesse caso). Siglas dos descontos (Não utilizar as aspas!):

             VT: Vale Transporte;
             IRRF: Imposto de Renda Retido na Fonte;
             INSS: Desconto do Instituto Nacional do Seguro Social;
             FGTS: Fundo de Garantia do Tempo de Serviço;
  
- Alterar login Administrador -> Essa tela apresenta a possibilidade da alteração do usuário e senha padrões.
  
            Usuário (padrão): admin
            Senha (padrão): admin
  
- Excluir usuários -> Essa tela reseta toda parte do usuário, excluindo todos os usuários cadastrados e zerando seus valores.

# :blond_haired_man: Contribuidores:

| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/92534443?v=4" width=115><br><sub>Brunno Pedro de Oliveira</sub>](https://github.com/BlackPearlBP) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/143548075?v=4" width=115><br><sub>Gabriel Campos Fregatti Reis</sub>](https://github.com/Freegrattis) |  [<img loading="lazy" src="https://avatars.githubusercontent.com/u/92793218?v=4" width=115><br><sub>Gabriel Lucas Soares</sub>](https://github.com/FlashySniper) |
| :-----: | :-----: | :-----: |

