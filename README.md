Claro! Aqui está o `README.md` completo em Markdown para você copiar e colar no seu projeto:

# OutseraResultsSelenium

Este projeto foi criado para realizar testes de automação E2E e API utilizando Selenium, Cucumber e RestAssured.

## Estrutura do Projeto

O projeto está organizado nas seguintes pastas:

- `src/test/java`: Contém os testes automatizados.
- `src/test/resources`: Contém os arquivos de recursos necessários para os testes, como arquivos de feature do Cucumber.

## Dependências

As principais dependências usadas neste projeto são:

- Selenium
- Cucumber
- RestAssured
- WebDriverManager
- Cucumber Reporting

## Configuração

1. Clone o repositório:

```bash
git clone https://github.com/andre-mendonca88/OutseraResultsSelenium.git
```

2. Navegue até o diretório do projeto:

```bash
cd OutseraResultsSelenium
```

3. Execute o comando Maven para baixar as dependências e compilar o projeto:

```bash
mvn clean install
```

## Executando os Testes
Para executar os testes, utilize a classe TestRunner.java. Você pode rodar esta classe diretamente a partir do seu IDE ou usando o Maven:

### Via IDE
Navegue até src/test/java/runner/TestRunner.java.
Clique com o botão direito na classe TestRunner e selecione "Run 'TestRunner'".

### Via Maven
Para executar os testes via Maven, utilize o seguinte comando:

```bash
mvn test
```

## Relatórios

Os relatórios de teste são gerados automaticamente após a execução dos testes e podem ser encontrados no diretório `target/cucumber-reports/`.

## Captura de Tela

As capturas de tela são salvas no diretório `target/cucumber-reports/screenshots/` e são anexadas ao relatório HTML gerado após a execução dos testes em caso de falha.

## Contribuição

Sinta-se à vontade para contribuir com melhorias ou correções. Para isso, siga os passos abaixo:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas alterações (`git commit -am 'Adiciona nova feature'`)
4. Faça um push para a branch (`git push origin feature/nova-feature`)
5. Crie um novo Pull Request

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo LICENSE para mais detalhes.

---

## Contato

- [LinkedIn](https://www.linkedin.com/in/andreluizmendonca/)
- [Email](mailto:andre.mendonca88@gmail.com)
