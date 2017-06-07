package com.example.andresteran_i014213.projectofinal_sti.Views.Fragments;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.andresteran_i014213.projectofinal_sti.Adapters.BusAdapter;
import com.example.andresteran_i014213.projectofinal_sti.Adapters.FavoriteBusAdapter;
import com.example.andresteran_i014213.projectofinal_sti.Adapters.FavoritesAdapter;
import com.example.andresteran_i014213.projectofinal_sti.Adapters.UserAdapter;
import com.example.andresteran_i014213.projectofinal_sti.Data.DataUser;
import com.example.andresteran_i014213.projectofinal_sti.HttpManager;
import com.example.andresteran_i014213.projectofinal_sti.LoginActivity;
import com.example.andresteran_i014213.projectofinal_sti.Models.Bus;
import com.example.andresteran_i014213.projectofinal_sti.Models.Favorites;
import com.example.andresteran_i014213.projectofinal_sti.Models.User;
import com.example.andresteran_i014213.projectofinal_sti.Parser.Json;
import com.example.andresteran_i014213.projectofinal_sti.R;

import java.io.IOException;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    View view;
    ProgressBar loader;
    ListView listaFavor;
    List<User> myUser;
    UserAdapter adapterUser;
    DataUser dataUser;
    FavoriteBusAdapter adapterFavorites;
    List<Bus> busList;
    BusAdapter busAdapter;

    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_home, container, false);
        loader = (ProgressBar) view.findViewById(R.id.loader);
        //myRecycler = (RecyclerView) view.findViewById(R.id.myRecycler);
        listaFavor = (ListView) view.findViewById(R.id.id_lv_fovorites);
        dataUser = new DataUser(getActivity());
        dataUser.open();
        LoginActivity.userLogin = dataUser.checkStatusLogin();


        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        //myRecycler.setLayoutManager(linearLayoutManager);

        showTolbar(getResources().getString(R.string.txt_title_toolbar_Container),true);
        setHasOptionsMenu(true); // para poder poner toolbar  en fragmento
        //onClickButton();


        //mysFavorites = dataUser.findAllFavorites();
        //adapterFavorites = new FavoritesAdapter(getActivity().getApplicationContext(),mysFavorites);
        //listaFavor.setAdapter(adapterFavorites);

        busList = dataUser.listFavorites(LoginActivity.userLogin.getId());
        if (busList.size()<=0) Toast.makeText(getActivity().getApplicationContext(), " no hay Favoritos", Toast.LENGTH_SHORT).show();
        else {
            adapterFavorites = new FavoriteBusAdapter(getActivity().getApplicationContext(),busList);
            listaFavor.setAdapter(adapterFavorites);
            registerForContextMenu(listaFavor);
        }

        listaFavor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bus bus=(Bus) parent.getItemAtPosition(position);
                Toast.makeText(getActivity().getApplicationContext(),bus.getNeighborhood(), Toast.LENGTH_SHORT).show();
            }
        });
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.favorites_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_item_menu_more_Information:
                Toast.makeText(getActivity().getApplicationContext(),"Mas informacion", Toast.LENGTH_SHORT).show();
                return (true);
            case  R.id.id_item_menu_favorite:
                Toast.makeText(getActivity().getApplicationContext(),"Se ha desmarcado como favorito", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
