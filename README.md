# 💱 Conversor de Moedas

Este projeto é um conversor de moedas simples feito em Java, desenvolvido como parte do desafio do programa ONE - Oracle Next Education em parceria com a Alura.

Ele utiliza a API pública do [ExchangeRate API](https://www.exchangerate-api.com/) para obter cotações de moedas e realizar conversões entre as principais moedas do mercado.

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Biblioteca HTTP Client (java.net.http)
- Biblioteca Gson para manipulação de JSON
- IDE IntelliJ IDEA
- API ExchangeRate

---

## 📌 Funcionalidades

- Conversão entre diferentes moedas (USD, BRL, EUR, GBP, JPY, ARS)
- Consulta da cotação atual baseada no Real (BRL)
- Interface via console para interação com o usuário
- Validação de entrada para maior robustez

---

## 📷 Demonstração

Bem-vindo ao Conversor de Moedas!
Moedas disponíveis:
USD - Dólar Americano
BRL - Real Brasileiro
EUR - Euro
GBP - Libra Esterlina
JPY - Iene Japonês
ARS - Peso Argentino

Menu:
1 - Converter moeda
2 - Verificar cotação
3 - Sair

## 📁 Organização do projeto
src/
├── br/com/ayran/conversor/
│   └── Main.java
├── br/com/ayran/conversor/modelo/
│   └── Conversao.java
├── br/com/ayran/conversor/servico/
    ├── ApiConversor.java
    └── ApiCotacao.java

✍️ Autor
Desenvolvido por Ayran Vieira
🔗 LinkedIn
📧 ayran.developer@gmail.com
📱 Instagram @ayran.code

