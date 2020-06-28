/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz5lubao;

import doublylinkedlist.DList;
import doublylinkedlist.DNode;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeo
 */
public class CustomerTransaction {

    public static void main(String[] args) {
        Customer person1 = new Customer(1, "Jonny Greenwood");
        Customer person2 = new Customer(2, "John Meyer");
        Customer person3 = new Customer(3, "Kurt Cobain");
        Customer person4 = new Customer(4, "Daft Punk");
        Customer person5 = new Customer(5, "Mark Knopfler");

        DNode<Customer> customer1 = new DNode<>(null, person1, null);
        DNode<Customer> customer2 = new DNode<>(null, person2, null);
        DNode<Customer> customer3 = new DNode<>(null, person3, null);
        DNode<Customer> customer4 = new DNode<>(null, person4, null);
        DNode<Customer> customer5 = new DNode<>(null, person5, null);

        DequeList<DNode> TransactionDList = new DequeList<>();

        TransactionDList.addFirst(customer1);
        TransactionDList.addFirst(customer2);
        TransactionDList.addLast(customer3);
        TransactionDList.addFirst(customer4);
        TransactionDList.addFirst(customer5);

        System.out.println("Deque List: \n");
        System.out.println("List of Transactions: \n");
        try {
            displayTransaction(TransactionDList);
        } catch (EmptyDequeException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nremoveFirst() implementation\n");
        try {
            TransactionDList.removeFirst();
            displayTransaction(TransactionDList);
        } catch (EmptyDequeException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("\nremoveLast() implementation\n");
        try {
            TransactionDList.removeLast();
            displayTransaction(TransactionDList);
        } catch (EmptyDequeException ex) {
            System.out.println(ex.getMessage());
        }
        
        

    }

    private static void displayTransaction(DequeList<DNode> dequeList) throws EmptyDequeException {
        try {
            DNode<Customer> temp = dequeList.first();
            for (int i = 0; i < dequeList.size(); i++) {
                System.out.println("Transaction Number " + (i + 1) + ": " + temp.getElement().getCustomerName() + ", Customer ID: " + temp.getElement().getCustomerID());
                temp = temp.getNext();
            }
        } catch (quiz5lubao.EmptyDequeException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
