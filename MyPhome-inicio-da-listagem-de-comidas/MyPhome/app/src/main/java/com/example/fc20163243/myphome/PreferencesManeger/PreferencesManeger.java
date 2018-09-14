package com.example.fc20163243.myphome.PreferencesManeger;

import android.app.Activity;
import android.content.SharedPreferences;

public class PreferencesManeger {

        //persistir coisas rapidas (preferencias do aplicativo)
    public static void salvar(Activity activity, boolean value) {

        //abre a base de persistencia
        SharedPreferences preferencias =
                activity.getSharedPreferences("config",
                        Activity.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferencias.edit();

        editor.putBoolean("notificacoes", value);

        editor.commit();

    }

    public static boolean getValue(Activity activity) {

        //abre a base de preference_persistence
        SharedPreferences preferencias =
                activity.getSharedPreferences("config",
                        Activity.MODE_PRIVATE);

        //verifica se existe a chave "config"
        if (preferencias.contains("notificacoes")){
            //parameter: chave , parametro para retornar se nao encontrar a chave
            return preferencias.getBoolean("notificacoes", false);
        }

        return false;
    }

}
