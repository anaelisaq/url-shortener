# URL Shortener - Desafio Técnico Back-end TDS

> Este é um projeto de uma API Rest desenvolvida em Kotlin com Spring. O objetivo do projeto é a criação de um micro serviço com uma API para encurtar URLs que deverá seguir o padrão REST. Ao cadastrar uma URL, é necessário retornar uma outra URL encurtada que, ao ser acessada, redireciona o usuário para a URL original. Além da API base, deve ser feita a criação de um endpoint de estatísticas de acesso às URLs geradas.

## Como executar o projeto

Siga as etapas abaixo para executar o projeto em sua máquina local:

Execute os seguintes comandos a partir da pasta raiz do projeto:

### Clone este repositório

```bash
git clone git@github.com:anaelisaq/url-shortener.git
```

### Acesse o diretório do projeto:
```bash
cd url-shortener
```

### Ou abrir diretamente na sua IDE de preferência

## Estrutura de Pastas

A estrutura de pastas do projeto é organizada da seguinte maneira:

```
📂 gradle
📂 src
┣ 📂 main
┃ ┣ 📂 kotlin/com/tds/urlshortener
┃ ┃ ┣ 📂 config
┃ ┃ ┃ ┣ 📜 FilterConfig.kt
┃ ┃ ┃ ┗ 📜 SwaggerConfig.kt
┃ ┃ ┣ 📂 controller
┃ ┃ ┃ ┣ 📂 dto
┃ ┃ ┃ ┃ ┣ 📜 UrlShortenRequest.kt
┃ ┃ ┃ ┃ ┗ 📜 UrlShortenResponse.kt
┃ ┃ ┃ ┣ 📂 exception
┃ ┃ ┃ ┃ ┗ 📜 GlobalexceptionHandler.kt
┃ ┃ ┃ ┗ 📜 UrlController.kt
┃ ┃ ┣ 📂 domain
┃ ┃ ┃ ┣ 📂 model
┃ ┃ ┃ ┃ ┗ 📜 Url.kt
┃ ┃ ┃ ┗ 📂 model
┃ ┃ ┃ ┃ ┗ 📜 UrlRepository.kt
┃ ┃ ┣ 📂 service
┃ ┃ ┃ ┗ 📜 UrlService.kt
┃ ┃ ┣ 📂 util
┃ ┃ ┃ ┣ 📂 filter
┃ ┃ ┃ ┃ ┗ 📜 UrlAccessFilter.kt
┃ ┃ ┃ ┗ 📜 UrlShortenerUtil.kt
┃ ┃ ┗ 📜 UrlShortenerApplication.kt
┃ ┣ 📂 resources
┃ ┃ ┗ 📜 application.yml
┣ 📂 test/kotlin/com/tds/urlshortener
┃ ┣ 📂 unit
┃ ┃ ┗ 📜 UrlServiceTest.kt
┃ ┗ 📜 UrlShortenerApplicationTests.kt
📜 .gitignore
📜 build.gradle.kts
📜 gradle.properties
📜 gradlew
📜 gradlew.bat
📜 settings.gradle.kts
```
