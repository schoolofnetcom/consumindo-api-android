package com.schoolofnet.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.BasicResponseHandler;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;

public class AddContact extends AppCompatActivity {

    private EditText txtName;
    private EditText txtLastname;
    private EditText txtEmail;
    private EditText txtCompanyName;
    private EditText txtTelephone;
    private HttpClient httpClient = HttpClientBuilder.create().build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_contact);

        txtName = (EditText) findViewById(R.id.txt_name);
        txtLastname = (EditText) findViewById(R.id.txt_lastname);
        txtEmail = (EditText) findViewById(R.id.txt_email);
        txtCompanyName = (EditText) findViewById(R.id.txt_company_name);
        txtTelephone = (EditText) findViewById(R.id.txt_telephone);
    }

    public void save(View v) throws JSONException, IOException {
        HttpPost client = new HttpPost("http://10.0.2.2:8080/api/person");
        JSONObject obj = new JSONObject();

        obj.put("name", txtName.getText());
        obj.put("lastname", txtLastname.getText());
        obj.put("email", txtEmail.getText());
        obj.put("companyName", txtCompanyName.getText());
        obj.put("telephone", txtTelephone.getText());

        client.addHeader("Content-Type", "application/json");
        client.addHeader("Accept", "application/json");
        StringEntity strObj = new StringEntity(obj.toString());

        client.setEntity(strObj);

        HttpResponse reponse = httpClient.execute(client);
    }
}
