# Bakery-Manager---Java 
 
**(Projeto com fim de aprendizado)** 

**Bakery Manager** é um sistema de gerenciamento para uma confeitaria/padaria com funções de estoque, produtos, finanças, funcionários, vitrine e etc, desenvolvido em Java. Este sistema tem como objetivo controlar a entrada e saída de materiais e de produtos prontos, caixa... garantindo um fluxo eficiente no gerenciamento.

## **Funcionalidades**

O sistema foi projetado (até o momento) para gerenciar os seguintes aspectos de uma confeitaria/padaria:

### 1. **Estoque de Material**
Gerencia os materiais e matérias-primas armazenadas no almoxarifado, permitindo adicionar, remover e consultar os itens.

### 2. **Estoque de Produtos/Comidas Prontas**
Gerencia os produtos prontos e preparados na cozinha e vitrine, permitindo controlar a quantidade disponível para venda.

### 3. **Entrada e Saída do Estoque**
Controla a entrada e saída dos ingredientes, ajudando a verificar se algum item está acabando e precisa ser reabastecido.

### 4. **Entrada e Saída da Vitrine**
Controla a entrada e saída de produtos na vitrine, permitindo saber quando algum item está acabando e precisa ser produzido. 
 
### 5. **Produtos mais vendidos e dias** 
Fornece relatórios sobre quais foram os produtos mais vendidos, em quais dias houve mais vendas, o que mais vendeu em um determinado dia, permitindo planejar as produções.

## **Tecnologias Utilizadas**
- **Linguagem de Programação**: Java
- **Desenvolvimento**: Ambiente de desenvolvimento Java padrão (Visual Studio Code)

## **Como Rodar o Projeto**

### 1. **Clonar o Repositório**
Para começar a usar o sistema, clone este repositório para a sua máquina local:

bash 
git clone 

## **Estrutura de Diretórios**
bakery - java
├── database
├── main
│   └── Main.java              # Ponto de entrada do sistema
├── model
│   ├── Ingredients.java       # Classe que define materiais (ingredientes)
│   └── Product.java           # Classe que define os produtos
├── services
│   ├── InventoryManager.java  # Lógica de gerenciamento de estoque e controle de itens 
│   ├── Items.java             # Classe base para itens no sistema
│   ├── Sales.java             # Classe para gerenciamento de vendas
│   ├── Showcase.java          # Controle da vitrine (produtos prontos para exibição)
│   └── Stock.java             # Controle do estoque (incluindo ingredientes e produtos)
├── README.md                  # Arquivo de documentação do projeto
└── .gitignore                 # Arquivo de configuração para o Git


## **Como Contribuir**
Contribuições são bem-vindas! Se você quiser melhorar este projeto, siga as etapas abaixo:

1. Faça um fork deste repositório.
2. Crie uma branch para sua modificação (git checkout -b minha-modificacao).
3. Faça o commit das suas alterações (git commit -am 'Adiciona uma nova funcionalidade').
4. Envie a branch para o repositório remoto (git push origin minha-modificacao).
5. Abra um pull request para o repositório principal.

## **Contato**
Caso tenha dúvidas ou queira discutir o projeto, sinta-se à vontade para abrir uma issue aqui no GitHub ou enviar um e-mail para [elyzastudy@gmail.com]. 



