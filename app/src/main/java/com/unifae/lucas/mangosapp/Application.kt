package com.unifae.lucas.mangosapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Classe Application do app MangosApp, anotada com @HiltAndroidApp para habilitar injeção de dependência com Hilt.
 * Serve como ponto de entrada para inicializar componentes Hilt no nível da aplicação.
 */
@HiltAndroidApp
class MangosApp: Application(){
}