package com.example.andresteran_i014213.projectofinal_sti.Views.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.andresteran_i014213.projectofinal_sti.Adapters.BusAdapter;
import com.example.andresteran_i014213.projectofinal_sti.Data.DataUser;
import com.example.andresteran_i014213.projectofinal_sti.Models.Bus;
import com.example.andresteran_i014213.projectofinal_sti.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    View view;
    List<Bus> busesList;
    DataUser dataBus;
    ListView listView;
    BusAdapter busAdapter;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_search, container, false);
        showTolbar(getResources().getString(R.string.txt_title_toolbar_search),true);
        setHasOptionsMenu(true);
        listView = (ListView) view.findViewById(R.id.id_fragment_list_buses);
        dataBus = new DataUser(getActivity());
        dataBus.open();
        busesList = dataBus.findAllBuses();
        if (busesList.size()<=0) {
            createData();
            busesList = dataBus.findAllBuses();
            busAdapter = new BusAdapter(getActivity().getApplicationContext(), busesList);
            listView.setAdapter(busAdapter);
        }else{
        busAdapter = new BusAdapter(getActivity().getApplicationContext(), busesList);
        listView.setAdapter(busAdapter);
        }
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_cargar_datos:
                //onClickButton();
                return (true);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showTolbar(String title, boolean upButton) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    private void createData(){
        Bus bus  = new Bus();

        bus.setRoute("E1");
        bus.setNeighborhood("POPULAR");
        dataBus.createBus(bus);

        bus.setRoute("E1");
        bus.setNeighborhood("PARQUE BOLIVAR");
        dataBus.createBus(bus);

        bus.setRoute("E1");
        bus.setNeighborhood("CALLE 20");
        dataBus.createBus(bus);

        bus.setRoute("E1");
        bus.setNeighborhood("UNIVERSIDAD MARIANA");
        dataBus.createBus(bus);

        bus.setRoute("E1");
        bus.setNeighborhood("BRICEÑO");
        dataBus.createBus(bus);

        bus.setRoute("E6");
        bus.setNeighborhood("SINDAGUA");
        dataBus.createBus(bus);

        bus.setRoute("E6");
        bus.setNeighborhood("H DEPARTAMENTAL");
        dataBus.createBus(bus);

        bus.setRoute("E6");
        bus.setNeighborhood("AV COLOMBIA");
        dataBus.createBus(bus);

        bus.setRoute("E6");
        bus.setNeighborhood("SAN ANDRESITO");
        dataBus.createBus(bus);

        bus.setRoute("E6");
        bus.setNeighborhood("PANAMERICANA");
        dataBus.createBus(bus);

        bus.setRoute("C2");
        bus.setNeighborhood("ALTOS DE LA COLINA");
        dataBus.createBus(bus);

        bus.setRoute("C2");
        bus.setNeighborhood("CESMAG");
        dataBus.createBus(bus);

        bus.setRoute("C2");
        bus.setNeighborhood("SAN JUAN BOSCO");
        dataBus.createBus(bus);

        bus.setRoute("C2");
        bus.setNeighborhood("CHAMPAGNAT");
        dataBus.createBus(bus);

        bus.setRoute("C2");
        bus.setNeighborhood("TERMINAL");
        dataBus.createBus(bus);

        bus.setRoute("C2");
        bus.setNeighborhood("LA PAZ");
        dataBus.createBus(bus);

        bus.setRoute("C2");
        bus.setNeighborhood("BOMBONA");
        dataBus.createBus(bus);


    }

}
