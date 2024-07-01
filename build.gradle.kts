plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.openjfx:javafx-controls:16") // Add this line for JavaFX controls
    implementation("org.openjfx:javafx-fxml:16") // Add this line if you are using FXML
    implementation("com.github.almasb:fxgl:11.17") // Add this line
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}