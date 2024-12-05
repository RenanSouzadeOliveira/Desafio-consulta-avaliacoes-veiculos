# Consultando Avaliações de Veículos

Este projeto é parte do desafio realizado no curso **"Java: Trabalhando com Lambdas, Streams e Spring Framework"** oferecido pela [Alura](https://www.alura.com.br). O objetivo é consumir a API da Tabela FIPE para consultar marcas, modelos e avaliações de veículos como carros, motos e caminhões.

---

## 🚗 Funcionalidades

1. **Menu de Opções**:
   - Consultar marcas de carros, motos ou caminhões.
   
2. **Filtragem de Modelos**:
   - Busca por trecho do nome do veículo.
   
3. **Consulta de Avaliações**:
   - Exibição de informações detalhadas de valores por ano.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17** (ou superior)
- **API REST** - [FIPE API](https://deividfortuna.github.io/fipe/)
- **Biblioteca Gson** para manipulação de JSON
- **Paradigma funcional** com Lambdas e Streams

---

## 🗂️ Estrutura do Projeto

- `Principal`: Classe principal que interage com o usuário via terminal.
- `ConsumoApi`: Classe responsável por realizar requisições HTTP à API.
- `ConverteDados`: Classe que converte JSON em objetos Java.
- `Dados`: Classe modelo para representar marcas e modelos.
- `Modelos`: Classe que encapsula a lista de modelos.
- `Veiculo`: Classe que armazena detalhes das avaliações dos veículos.

---

## 📖 Como Executar

### Pré-requisitos

- Java JDK 17 (ou superior) instalado.
- IDE como IntelliJ IDEA, Eclipse ou qualquer editor de texto.
- Acesso à internet para consumir a API.
- 
### Passos para Execução

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/consultando-avaliacoes-veiculos.git
2. javac Principal.java
   java Principal

### 📝 Exemplo de Uso
#### Fluxo de Navegação:

Escolha uma categoria: Carro, Moto ou Caminhão.
Insira o código da marca desejada para visualizar os modelos disponíveis.
Filtre os modelos por trecho do nome.
Insira o código de um modelo específico para consultar as avaliações de valores por ano.
Confira os detalhes no terminal.

#### Entrada e Saída de Dados
##### Entrada:
  Categoria de veículo (ex.: "Carro").
  Código da marca (ex.: "59").
  Nome ou trecho do modelo (ex.: "Civic").
  Código do modelo (ex.: "7261").

##### Saída:
  Lista de marcas disponíveis.
  Modelos associados à marca.
  Valores de avaliação dos modelos por ano.

### 📦 Dependências
  Gson: Para manipulação de JSON.
  Biblioteca padrão do Java (java.net.HttpURLConnection, java.util, etc.).

### 🌟 Aprendizados

Este projeto foi essencial para consolidar os seguintes tópicos:

Consumo de APIs REST utilizando HttpURLConnection.
Manipulação de dados com Streams e Lambdas no Java.
Conversão eficiente de JSON para objetos Java.
Uso prático do paradigma funcional para filtrar e organizar dados.

