plugins {
    id("com.android.application") version "7.2.1" apply false
    id("com.android.library") version "7.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.7.0" apply false
    kotlin("plugin.serialization") version "1.7.0"
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}