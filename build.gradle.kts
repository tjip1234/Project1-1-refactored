plugins {
    java
    application
    id("org.openjfx.javafxplugin") version "0.0.11"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

javafx {
    version = "17"
    modules("javafx.controls", "javafx.fxml", "javafx.graphics", "javafx.media", "javafx.swing", "javafx.web")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")


    // Add additional JavaFX or other dependencies if necessary
}
tasks.getByName<JavaExec>("run") {
    doFirst {
        jvmArgs = listOf(
                "--module-path", classpath.asPath,
                "--add-modules", "javafx.controls,javafx.fxml,javafx.graphics"
        )
    }
}
tasks.test {
    useJUnitPlatform()
}
