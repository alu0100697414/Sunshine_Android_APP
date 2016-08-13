package com.example.android.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            // Arraylist con todos los elementos que se van a cargar en la lista
            ArrayList<String> list_predicciones = new ArrayList<>();
            list_predicciones.add("Lista numero 1");
            list_predicciones.add("Lista numero 2");
            list_predicciones.add("Lista numero 3");
            list_predicciones.add("Lista numero 4");
            list_predicciones.add("Lista numero 5");
            list_predicciones.add("Lista numero 6");
            list_predicciones.add("Lista numero 7");
            list_predicciones.add("Lista numero 8");
            list_predicciones.add("Lista numero 9");
            list_predicciones.add("Lista numero 10");

            // Creamos el adapter para la lista
            ArrayAdapter<String> list_adapter = new ArrayAdapter<String>(
                    getActivity(), // Cogemos el contexto
                    R.layout.list_item_forecast, // Cogemos el fichero donde está el elemento a cargar en la lista
                    R.id.list_item_forecast_textview, // Cogemos el elemento a cargar en la lista
                    list_predicciones // Datos a cargar en cada uno de los elementos de la lista
            );

            // Creamos la vista y le asociamos el adapter
            ListView list = (ListView) rootView.findViewById(R.id.listview_forecast);
            list.setAdapter(list_adapter);

            return rootView;
        }
    }
}
