package com.example.reto1juanosorio.datos;

import android.app.ProgressDialog;
import android.os.Handler;

import com.example.reto1juanosorio.modelo.Sucursal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SucursalesJSON extends Thread {

    String data = "";
    ArrayList<Sucursal> sucursalesJSON = new ArrayList<Sucursal>();
    Handler sucursalesHandler = new Handler();
    ProgressDialog progressDialog;


    @Override
    public void run() {

        sucursalesHandler.post(new Runnable() {
            @Override
            public void run() {
               // progressDialog = new ProgressDialog(getActivityContext());


            }
        });

        try {
            URL url = new URL("https://g92c8d59813b029-restaurante.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/api/sucursales");
            HttpURLConnection httpURLConnection = (HttpURLConnection)  url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while((line = bufferedReader.readLine())!=null){
                data += line;
            }

            if(!data.isEmpty()){
                JSONObject jsonObject = new JSONObject(data);
                JSONArray id = jsonObject.getJSONArray("id");
                JSONArray nombre = jsonObject.getJSONArray("nombre");
                JSONArray direccion = jsonObject.getJSONArray("direccion");
                JSONArray latitude = jsonObject.getJSONArray("latitude");
                JSONArray longitude = jsonObject.getJSONArray("longitude");
                sucursalesJSON.clear();
                for(int i = 0 ; i<id.length();i++){
                    JSONObject ids = id.getJSONObject(i);
                    JSONObject nombres = nombre.getJSONObject(i);
                    JSONObject direcciones = direccion.getJSONObject(i);
                    JSONObject latitudes = latitude.getJSONObject(i);
                    JSONObject longitudes = longitude.getJSONObject(i);
                    //sucursalesJSON.add(new Sucursal(ids, nombres, direccion));

                }

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}

