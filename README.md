# AppIntro
Um simples pacote para adicionar telas de introdução no seu aplicativo.

# Contribuição
Você pode contribuir para este projeto, fazendo o Fork, e o pull request. Ajude a manter o projeto, contribuindo.

# Contactos
Fale comigo pelo <a href="https://www.facebook.com/pedromassango.m">Facebook</a>, <a href="https://twitter.com/pedro_massango3">Twitter</a>.
Visite também o meu <a href="https://www.youtube.com/channel/UCBiJzXGvkuT9aG2Yq8BYYnQ">Canal no youtube</a>.

<img src="/screenshots/device-2018-02-01-154210.png" width="260" height="480"> <img src="/screenshots/device-2018-02-01-154304.png" width="260" height="480"> <img src="/screenshots/device-2018-02-01-154329.png" width="260" height="480">

## Requisitos
​
- Android API level 16 ou posterior
- Sua IDE favorita

## Setting up

Gradle:

Passo 1. Adicionar o jitpack.io
Adiciona isto no seu build.gradle do diretorio principal:
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Passo 2. Adicionar a dependência
```groovy
dependencies {
	        compile 'com.github.pedromassango:appIntro:v1.0-beta'
	}
```


Maven:

Passo 1. registar o jitpack.io
```xml
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```

Passo 2. Adicionar a dependência

```xml
<dependency>
    <groupId>com.github.pedromassango</groupId>
    <artifactId>appIntro</artifactId>
    <version>v1.0-beta</version>
</dependency>
```

## Uso básico

Para adicionar um slide você deve usar a classe `IntroSlide`, como descrita abaixo:
```java
    IntroSlide(
            // Slide title (String)
            ,
            // Slide description (String)
            ,
            // Slide bacground color (Int)
            ,
            // Slide icon (resource icon -> Int)
            )
```


Crie uma classe que extenda de `IntroActivity` e sobrescreva os métodos necessários:
`setupIntro()` - Inicie/Adicione os slides neste método.
`onBack(slide: IntroSlide)` - Será executado quando o botão BACK for clicado
`onNext(slide: IntroSlide)` - Será executado quando o botão NEXT for clicado
`onFinish(slide: IntroSlide)` - Será executado quando o último slide for alcançado, e não haver mais slides.

Código de exemplo:
```java
class TestIntroActivity : IntroActivity() {

    // Do not override onCreate()

    override fun setupIntro() {

        // Adding slides to show
        addSlide(IntroSlide(
                getString(R.string.app_name).toUpperCase(),
                getString(R.string.descp),
                backgroundColor = Color.MAGENTA,
                mIcon = R.mipmap.ic_launcher))
    }

    override fun onBack(slide: IntroSlide) {
        // Back pressed
    }

    override fun onNext(slide: IntroSlide) {
        // Next pressed
    }

    override fun onFinish(slide: IntroSlide) {
        // All slides was shown.
    }
}
```