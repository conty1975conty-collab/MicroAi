plugins {
    // Указаны версии плагинов; Android Studio / Gradle может предложить обновления.
    id("com.android.application") version "8.3.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    // Добавляем явную версию для плагина Compose, иначе Gradle не найдёт его при указанном плагине в модуле app
    id("org.jetbrains.kotlin.plugin.compose") version "1.9.22" apply false
}
