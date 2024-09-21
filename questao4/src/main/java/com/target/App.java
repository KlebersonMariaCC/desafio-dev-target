package com.target;


import java.sql.*;
import java.io.*;



public class App {

    private static String dbUrl = "jdbc:sqlite:app.db";
    private static String schemaPath = "schema.sql";
    private static String insertPath = "insert.sql";
    private static String queryPath = "query.sql";

    public static void main( String[] args ){
        connection();
        runScript(schemaPath);
        runScript(insertPath);
        runQuery(queryPath);
        close(); 
    }
        
  private static void runScript(String scriptPath) {

    Connection conn = null; 
    StringBuilder script = new StringBuilder();

       try {
        
        conn = DriverManager.getConnection(dbUrl);
        BufferedReader br = new BufferedReader(new FileReader(scriptPath));
        String line;

        while((line = br.readLine()) != null) {
            script.append(line).append("\n");
        }
        Statement stmt = conn.createStatement();

        String[] commands = script.toString().split(";");

        for (String command : commands) {
            if (!command.trim().isEmpty()) {
                stmt.execute(command);
            }
        }

       } catch ( Exception e) {
        System.out.println(e.getMessage());
       }

  }

    public static void connection() {
        Connection conn = null; 

       try {
        
        conn = DriverManager.getConnection(dbUrl);
        System.out.println("Connection to SQLite has been established.");

       } catch ( Exception e) {
        System.out.println(e.getMessage());
       }

       
    }

    public static void runQuery(String scriptPath) {
        Connection conn = null; 
        StringBuilder script = new StringBuilder();
    
           try {
            
            conn = DriverManager.getConnection(dbUrl);
            BufferedReader br = new BufferedReader(new FileReader(scriptPath));
            String line;
    
            while((line = br.readLine()) != null) {
                script.append(line).append("\n");
            }
            Statement stmt = conn.createStatement();
    
            String[] commands = script.toString().split(";");
    
            for (String command : commands) {
                if (!command.trim().isEmpty()) {
                    ResultSet rs = stmt.executeQuery(command);

                    // Obtém os metadados para saber o número de colunas
                    ResultSetMetaData metaData = rs.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    // Exibe o cabeçalho
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(metaData.getColumnName(i) + "\t");
                    }
                    System.out.println();
                
                    // Exibe os dados
                    while (rs.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(rs.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                }
            }

            
    
           } catch ( Exception e) {
            System.out.println(e.getMessage());
           }
    }


    public static void close() {
        Connection conn;
        try {
            conn = DriverManager.getConnection(dbUrl);
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
}
