plugins {
    kotlin("jvm") version "1.6.10"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("com.squareup.moshi:moshi:1.12.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.12.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
}

tasks.withType<Jar> {
    manifest {
        attributes["Implementation-Title"] = "V2Ray AdGuard Core"
        attributes["Implementation-Version"] = version
    }
}

kotlin {
    jvmToolchain {
        (this as org.jetbrains.kotlin.gradle.dsl.JvmTarget).languageVersion.set(JavaLanguageVersion.of(11))
    }
}