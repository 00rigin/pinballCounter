import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.20"
    kotlin("plugin.spring") version "1.9.20"
    kotlin("plugin.jpa") version "1.6.21"
    kotlin("kapt") version "1.6.21"
}

group = "com.juni"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springdoc:springdoc-openapi-kotlin:1.6.11")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.11")

    implementation("commons-codec:commons-codec")
    implementation("io.jsonwebtoken:jjwt:0.9.1")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql")

    implementation("org.apache.commons:commons-lang3")
    implementation("org.apache.commons:commons-io:1.3.2")

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    runtimeOnly("com.mysql:mysql-connector-j")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")

    val koTestVersion = "5.4.2"
    testImplementation("io.mockk:mockk:1.12.7")
    testImplementation("com.ninja-squad:springmockk:3.0.1")
    testImplementation("org.junit.jupiter", "junit-jupiter", "5.8.2")
    testImplementation("io.kotest:kotest-runner-junit5:$koTestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$koTestVersion")
    testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")
    testImplementation("com.h2database:h2")
    testImplementation("com.midasit:rpm-test:latest.integration")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation(kotlin("stdlib-jdk8"))

    // aws parameter store
    implementation("io.awspring.cloud:spring-cloud-starter-aws-parameter-store-config")

    implementation("com.querydsl:querydsl-jpa:5.0.0")
    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
