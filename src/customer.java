
import br.com.customer.dao.customerDAO;
import br.com.customer.factory.ConnectionFactory;
import br.com.customer.model.Customer;
import br.com.customer.util.util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thiago
 */
public class customer {

    public static void createCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.print("Deseja criar quantos clientes: ");
        int valor = input.nextInt();
        for (int i = 0; i < valor; i++) {
            Customer customer = new Customer();
            customerDAO dao = new customerDAO();
            if (valor % 2 == 0) {
                customer.setCpf_cnpj(util.generateCPF());
            } else {
                customer.setCpf_cnpj(util.generateCNPJ());
            }
            customer.setNm_customer(util.generateName());
            customer.setIs_active(util.generateBoolean());
            customer.setVl_total(util.generateValue());

            dao.save(customer);
        }
    }

    public static void calculateAverage() throws Exception {
        Connection connection = ConnectionFactory.createConnection();
        Statement stmt = null;
        double valor = 0;
        int qtd = 0;
        double media;

        String query = "SELECT id_customer, nm_customer, vl_total FROM tb_customer_account ";
        query += " WHERE vl_total > 560 AND id_customer BETWEEN 1500 AND 2700 ";
        query += " ORDER BY vl_total DESC";

        try {
            stmt = connection.prepareStatement(query);

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                valor = valor + rs.getFloat("vl_total");
                qtd++;
                System.out.println("Nome: " + rs.getString("nm_customer") + " -- Valor: " + rs.getString("vl_total"));
            }
            media = valor / qtd;
            System.out.printf("%.2f", media);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void createNewCustomer() {
        Scanner input = new Scanner(System.in);
        customerDAO dao = new customerDAO();
        Customer customer = new Customer();

        System.out.print("Digite o nome:");
        customer.setNm_customer(input.next());
        System.out.print("Digite o CNPJ ou CPF: ");
        customer.setCpf_cnpj(input.next());
        System.out.print("Digite o valor: ");
        customer.setVl_total(input.nextFloat());
        System.out.print("false - Ativo, true - Inativo: ");
        customer.setIs_active(input.nextBoolean());

        dao.save(customer);
    }

    public static void menuCustomer() throws Exception {
        Scanner input = new Scanner(System.in);
        int opt;

        while (true) {
            System.out.println("1 - Criar customer aleatórios\n"
                    + "2 - Listar os customer e a média\n"
                    + "3 - Criar um customer\n"
                    + "4 - Sair\n");
            opt = input.nextInt();
            switch (opt) {
                case 1:
                    createCustomer();
                    break;
                case 2:
                    calculateAverage();
                    break;
                case 3:
                    createNewCustomer();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Digite uma opção valida:");
            }
        }
    }
}
