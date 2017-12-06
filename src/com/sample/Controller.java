package com.sample;

import com.model.Bill;
import com.model.Product;
import com.model.Sale;
import com.model.Stock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

@org.springframework.stereotype.Controller
public class Controller {
    @FXML
    private TextArea products;
    @FXML
    private TextArea stock;
    @FXML
    private TextArea vanzari;
    @FXML
    private TextArea facturi;
    @FXML
    private TextField codsearch;
    @FXML
    private TextField cantitateid;
    @FXML
    private TextField rezultat;

    public void initialPopulation() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8080/printAll";
        ResponseEntity<Product[]> response = restTemplate.getForEntity(fooResourceUrl , Product[].class);
        Product[] all = response.getBody();
        ArrayList<Product> productArrayList = new ArrayList<>();
        Collections.addAll(productArrayList, all);
        String text = "";
        for (Product p : productArrayList) {
            text = text + p.toString() + "\n";
        }
        products.setText(text);

        RestTemplate restTemplate2 = new RestTemplate();
        String fooResourceUrl2 = "http://localhost:8080/printStock";
        ResponseEntity<Stock[]> response2 = restTemplate2.getForEntity(fooResourceUrl2 , Stock[].class);
        Stock[] all2 = response2.getBody();
        ArrayList<Stock> productArrayList2 = new ArrayList<>();
        Collections.addAll(productArrayList2, all2);
        String text2 = "";
        for (Stock p : productArrayList2) {
            text2 = text2 + p.toString() + "\n";
        }
        stock.setText(text2);
    }

    public void populateBills() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8080/printBill";
        ResponseEntity<Bill[]> response = restTemplate.getForEntity(fooResourceUrl , Bill[].class);
        Bill[] all = response.getBody();
        ArrayList<Bill> productArrayList = new ArrayList<>();
        Collections.addAll(productArrayList, all);
        String text = "";
        for (Bill p : productArrayList) {
            text = text + p.toString() + "\n";
        }
        facturi.setText(text);
    }

    public void populateSales() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8080/printSale";
        ResponseEntity<Sale[]> response = restTemplate.getForEntity(fooResourceUrl , Sale[].class);
        Sale[] all = response.getBody();
        ArrayList<Sale> productArrayList = new ArrayList<>();
        Collections.addAll(productArrayList, all);
        String text = "";
        for (Sale p : productArrayList) {
            text = text + p.toString() + "\n";
        }
        vanzari.setText(text);
    }

    public void click(ActionEvent actionEvent) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8080/sellProduct?code="+codsearch.getText() + "&quantity=" + cantitateid.getText();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(fooResourceUrl, String.class);
        String ceva = responseEntity.getBody();
        rezultat.setText(ceva);

        initialPopulation();
        populateBills();
        populateSales();
    }
}
