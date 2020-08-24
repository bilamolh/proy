/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication30;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
public class db {
    MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://uqumwigyfcmdecu29uiz:8fRQRwxgMMbf7tjwqdKm@bv0d58maiskw13w-mongodb.services.clever-cloud.com:27017/bv0d58maiskw13w"));
    DB database = (DB) mongoClient.getDB("bv0d58maiskw13w");
    
    DBCollection control = database.getCollection("control");
    DBCollection ventas = database.getCollection("ventas");
    DBCollection facturacion = database.getCollection("facturacion");
    DBCollection inventario = database.getCollection("inventario");
    DBCollection clientes = database.getCollection("clientes");
    
    public void SubirControl(String cod,String des,int cantidad) {
        
        try {
            Date date = new Date();    
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fe = ""+dateFormat.format(date);
            DBObject prod = new BasicDBObject("_id",cod)//codigo
            .append("desc",des )//descripcion       
            .append("fecha",fe)//fecha sin la hora
            .append("cantidad",cantidad);//cantidad de venta
            control.insert(prod);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en los datos");//po si se ingresa un priary key repetido
        }
        
    }
    public static void main(String[] args) {
       db ok = new db();
       //ok.SubirControl("6","3",3);
    }
}
