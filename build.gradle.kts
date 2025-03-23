plugins {
    id("java")
}

group = "com.marcinseweryn"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")
    testCompileOnly("org.projectlombok:lombok:1.18.36")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.36")

    annotationProcessor("org.hibernate.orm:hibernate-jpamodelgen:6.6.11.Final")

    implementation("org.hibernate:hibernate-core:6.6.11.Final")
    implementation("org.hibernate.reactive:hibernate-reactive-core:2.4.5.Final")

    implementation("org.flywaydb:flyway-core:11.4.1")
    implementation("io.vertx:vertx-pg-client:4.5.13")

    implementation("com.ongres.scram:client:2.1")

    implementation("org.slf4j:slf4j-api:2.0.17")
    implementation("ch.qos.logback:logback-classic:1.5.16")
}

tasks.test {
    useJUnitPlatform()
}