plugins {
    kotlin("plugin.allopen") version "1.6.21"
}


dependencies {
    implementation("org.springframework:spring-tx:6.0.3")
}

tasks.register("prepareKotlinBuildScriptModel"){}

allOpen {
    annotation("com.example.cqrsread.common.annotation.UseCase")
    annotation("com.example.cqrsread.common.annotation.ReadOnlyUseCase")
}